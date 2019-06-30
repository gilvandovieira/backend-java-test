package star.wars.resistance.network.socialnetwork.models;

public class Localizacao {
    private Integer longitude, latitude;
    private String local;

    public Localizacao() {
    }

    public Localizacao(Integer longitude, Integer latitude, String local) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.local = local;
    }

    public Integer getLongitude() {
        return longitude;
    }

    public void setLongitude(Integer longitude) {
        this.longitude = longitude;
    }

    public Integer getLatitude() {
        return latitude;
    }

    public void setLatitude(Integer latitude) {
        this.latitude = latitude;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }
}
