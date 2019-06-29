package star.wars.resistance.network.socialnetwork.models;

import javax.persistence.*;
import java.io.Serializable;

import java.util.LinkedList;
import java.util.List;


@Entity
@Table(name = "rebeldes")
public class Rebelde implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;
    private Integer idade;
    private String genero;
    private Integer longitude, latitude;
    private String local;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "marcados", joinColumns = {@JoinColumn(name = "marcado_id")}, inverseJoinColumns = {@JoinColumn(name = "marcador_id")})
    private List<Rebelde> marcadores = new LinkedList<>();

    public Rebelde() {

    }

    public Rebelde(String nome, Integer idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public Rebelde(Long id, String nome, Integer idade, String genero, Integer longitude, Integer latitude, String local) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.genero = genero;
        this.longitude = longitude;
        this.latitude = latitude;
        this.local = local;
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

    public Integer getLongitude() {
        return longitude;
    }

    public Integer getLatitude() {
        return latitude;
    }

    public String getLocal() {
        return local;
    }

    public void novaLocalizacao(Integer longitude, Integer latitude, String local) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.local = local;
    }

    public boolean isTraidor() {
        return marcadores.size() >= 3;
    }

    public void adicionarMarcador(Rebelde r) {
        this.marcadores.add(r);
    }
}