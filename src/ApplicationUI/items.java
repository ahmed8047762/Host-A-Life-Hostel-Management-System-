package ApplicationUI;

public class items {
    private String itemname;
    private Integer itemprice;



    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public Integer getItemprice() {
        return itemprice;
    }

    public void setItemprice(Integer itemprice) {
        this.itemprice = itemprice;
    }

    items(String in, Integer ip)
    {
        this.itemname = in;
        this.itemprice = ip;
    }
}
