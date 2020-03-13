package FunctionLayer;

public class Cupcake {
    private String bottom;
    private String top;
    private String name;

    private double price;

    Cupcake(String bottom, String top){
        this.bottom = bottom;
        this.top = top;
        this.name = bottom + " " + top;
    }

    public String getBottom() {
        return bottom;
    }

    public void setBottom(String bottom) {
        this.bottom = bottom;
    }

    public String getTop() {
        return top;
    }

    public void setTop(String top) {
        this.top = top;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
