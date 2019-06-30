# Documentaçao da rede social dos rebeldes

## Api
    GET /rebeldes -> Pega todos os rebeldes. [{..},{...},...]

    POST /rebeldes -> Cria um novo rebelde. 
    Ex.: { "nome" : "Gilvando" , "idade":26, "genero":"masculino", 
            "items": {"agua":5,"arma":5,"comida":5,"municao":5} }
    
    GET /rebeldes/{id} -> Retorna um rebelde, vide exemplo acima.

    POST /rebeldes/{id}/negocia/{rebelde} -> Faz uma negociacao entre rebeldes. 
    Ex. de payload: {"agua":1,"arma":1,"comida":1,"municao":1}

    POST /traicao -> Cria uma nova traicao. 
    Ex.: { "traido": 1, "traidor":2 } 
    (No caso o rebelde de id=1 eh informado como traidor pelo rebelde de id=2)
    A cada tres traicoes, 
    POST /traicao { "traido": 1, "traidor":2 }, 
    POST /traicao { "traido": 1, "traidor":3 }, 
    POST /traicao { "traido": 1, "traidor":3 }
    o rebelde de id=1 eh marcado como traidor e consegue mais negociar seus items.
    
    GET /relatorios/porcentagem-de-traidores -> Retorna um double que eh a porcentagem de traidores
    
    GET /relatorios/porcentagem-de-rebeldes -> Retorna um double que eh a porcentagem de rebeldes
    
    GET /relatorios/medias -> Retorna as medias de agua, armas, comida e municao. 
    Ex. {"agua":5.06,"arma":33.2,"comida":22.0,"municao":19.0}
    
    GET /relatorios/pontos-perdidos -> Retorna um long que eh a soma dos pontos travados pelos traidores 
    
### Weirdness
    RebeldesServiceTest.java
    
    @Test
    public void pontosPerdidosPorTraidores() {
            assertThat(rebeldesService.pontosPerdidos()).isEqualTo(60l);
    }
Esse teste quando rodado isolado dos outros passa normal, mas quando roda a suite inteira ele retorna um valor maluco. Investiguei ate onde pude mas nao consegui encontrar a causa do problema.

## Configuracao

O projeto esta usando Spring Boot, Spring Data, H2 db, Spring Web.