package star.wars.resistance.network.socialnetwork.models;

import javax.persistence.*;
import javax.transaction.Transactional;


@Entity
@Table(name = "rebeldes")
@Transactional
public class Rebelde {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;
    private Integer idade;
    private String genero;

    private Boolean traidor = false;

    @Embedded
    private Localizacao localizacao;

    @Embedded
    Item items;

    public Rebelde() {

    }

    public Rebelde(String nome, Integer idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public Rebelde(Long id, String nome, Integer idade, String genero, Localizacao localizacao) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.genero = genero;
        this.localizacao = localizacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Localizacao getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(Localizacao localizacao) {
        this.localizacao = localizacao;
    }


    public boolean isTraidor() {
        return traidor.booleanValue();
    }

    public void setTraidor(boolean traidor) {
        this.traidor = traidor;
    }

    public void toggleTraidor() {
        this.traidor = !this.traidor;
    }

    public Item getItems() {
        //if (this.traidor)
        return items != null ? items : new Item();
        //else
        //  return items != null ? this.items = new Item(-this.getItems().getAgua(), -this.getItems().getArma(), -this.items.getComida(), -this.getItems().getMunicao()) : new Item();
    }

    public void setItems(Item items) {
        this.items = items;
    }
}