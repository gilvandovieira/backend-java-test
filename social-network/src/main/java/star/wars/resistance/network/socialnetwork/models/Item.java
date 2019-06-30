package star.wars.resistance.network.socialnetwork.models;

public class Item {

    Long arma, municao, agua, comida;

    public static final Long ARMA_PTS = 4l;
    public static final Long MUNICAO_PTS = 3l;
    public static final Long AGUA_PTS = 2l;
    public static final Long COMIDA_PTS = 1l;


    public Item() {
    }

    public Item(Long agua, Long arma, Long comida, Long municao) {
        this.arma = arma;
        this.municao = municao;
        this.agua = agua;
        this.comida = comida;
    }

    public Long getArma() {
        return arma;
    }

    public void setArma(Long arma) {
        this.arma = arma;
    }

    public Long getMunicao() {
        return municao;
    }

    public void setMunicao(Long municao) {
        this.municao = municao;
    }

    public Long getAgua() {
        return agua;
    }

    public void setAgua(Long agua) {
        this.agua = agua;
    }

    public Long getComida() {
        return comida;
    }

    public void setComida(Long comida) {
        this.comida = comida;
    }
}
