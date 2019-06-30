package star.wars.resistance.network.socialnetwork.models;

public class Negocio {
    private Long id1 =0l, id2= 0l;
    private Item item;

    public Negocio(Long id1, Long id2, Item item) {
        this.id1 = id1;
        this.id2 = id2;
        this.item = item;
    }

    public Negocio() {
    }

    public Long getId1() {
        return id1;
    }

    public void setId1(Long id1) {
        this.id1 = id1;
    }

    public Long getId2() {
        return id2;
    }

    public void setId2(Long id2) {
        this.id2 = id2;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
