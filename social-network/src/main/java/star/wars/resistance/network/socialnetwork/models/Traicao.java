package star.wars.resistance.network.socialnetwork.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "traicoes")
public class Traicao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //Um rebelde e traido por varios traidores
    @OneToOne(targetEntity = Rebelde.class, fetch = FetchType.LAZY)
    private Rebelde traido;

    //Um traidor trai um traido
    @OneToOne(targetEntity = Rebelde.class, fetch = FetchType.LAZY)
    private Rebelde traidor;


    @JsonCreator
    public Traicao() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Rebelde getTraido() {
        return traido;
    }

    public void setTraido(Rebelde traido) {
        this.traido = traido;
    }

    public Rebelde getTraidor() {
        return traidor;
    }

    public void setTraidor(Rebelde traidor) {
        this.traidor = traidor;
    }

    @JsonCreator
    public Traicao(@JsonProperty("traido") Rebelde traido,@JsonProperty("traidor") Rebelde traidor) {
        this.traido = traido;
        this.traidor = traidor;
    }

}
