package star.wars.resistance.network.socialnetwork;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import star.wars.resistance.network.socialnetwork.models.Rebelde;
import star.wars.resistance.network.socialnetwork.models.Traicao;
import star.wars.resistance.network.socialnetwork.service.RebeldesService;
import star.wars.resistance.network.socialnetwork.service.TraicaoService;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TraicaoReposiotoryTest {

    @Autowired
    private RebeldesService rebeldesService;

    @Autowired
    private TraicaoService traicaoService;

    private Rebelde r1, r2, r3, r4;
    private Traicao t1, t2, t3, t4, t5, t6, t7;

    @Before
    public void setUp() {
        r1 = new Rebelde("Gilvando", 26);
        r2 = new Rebelde("Maria", 34);
        r3 = new Rebelde("Joao", 28);
        r4 = new Rebelde("Leia", 31);

        rebeldesService.novo(r1);
        rebeldesService.novo(r2);
        rebeldesService.novo(r3);
        rebeldesService.novo(r4);

        t1 = new Traicao(r1.getId(), r2.getId());
        t2 = new Traicao(r1.getId(), r3.getId());
        t3 = new Traicao(r1.getId(), r4.getId());
        t4 = new Traicao(r2.getId(), r3.getId());
        t5 = new Traicao(r2.getId(), r4.getId());
        t6 = new Traicao(r3.getId(), r4.getId());
        t7 = new Traicao(r2.getId(), r1.getId());

        traicaoService.novo(t1);
        traicaoService.novo(t2);
        traicaoService.novo(t3);
        traicaoService.novo(t4);
        traicaoService.novo(t5);
        traicaoService.novo(t6);
        traicaoService.novo(t7);

    }


    @Test
    public void pegaListaDeTraidores_Test() {
        Long rebelde = traicaoService.todos().get(0).getTraido();

        List<Traicao> rebeldes = traicaoService.pegaListaDeTraidoresDoTraido(rebelde);

        assertThat(rebeldes.size()).isEqualTo(3);

    }

    @Test
    public void contaQuantasTraicoes_Test() {

        Long contado = traicaoService.countByTraido(r1.getId());

        assertThat(contado).isEqualTo(3l);

        contado = traicaoService.countByTraido(r2.getId());

        assertThat(contado).isEqualTo(3l);

    }

//    @Test
//    public void pegaTodasTraicoesPorTraido_Test() {
//        Set<Rebelde> traidores = traicaoRepository.getRebeldesComTraicoesMaiorQueTres();
//
//        assertThat(traidores.contains(r1)).isEqualTo(true);
//
//    }
}
