package FunctionLayer;

public class CakePart {

    private float price;
    private int cakeID;
    private String name;

    CakePart(float price, String name, int cakeID) {
        this.price = price;
        this.name = name;
        this.cakeID = cakeID;
    }

    public float getPrice() {
        return price;
    }
    public int getCakeID() {
        return cakeID;
    }
}
