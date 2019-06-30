package star.wars.resistance.network.socialnetwork.models;

import com.fasterxml.jackson.annotation.JsonCreator;

import javax.persistence.*;

@Entity
@Table(name = "traicoes")
public class Traicao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //Um rebelde e traido por varios traidores
    //@OneToOne(targetEntity = Rebelde.class, fetch = FetchType.LAZY)
    private Long traido;

    //Um traidor trai um traido
    //@OneToOne(targetEntity = Rebelde.class, fetch = FetchType.LAZY)
    private Long traidor;

    public Traicao() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTraido() {
        return traido;
    }

    public void setTraido(Long traido) {
        this.traido = traido;
    }

    public Long getTraidor() {
        return traidor;
    }

    public void setTraidor(Long traidor) {
        this.traidor = traidor;
    }

    public Traicao(Long traido, Long traidor) {
        this.traido = traido;
        this.traidor = traidor;
    }
}
