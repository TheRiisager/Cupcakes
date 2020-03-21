package FunctionLayer;

import java.util.ArrayList;

public class Order {

    private float subtotal;

    private ArrayList<Cupcake> cakes;

    private int id;

    Order(ArrayList<Cupcake> cakes){
        this.cakes = cakes;

        for(Cupcake c : cakes) {
            subtotal += c.getPrice();
        }
    }

    public ArrayList<Cupcake> getCakes() {
        return cakes;
    }

    public void setCakes(ArrayList<Cupcake> cakes) {
        this.cakes = cakes;
    }

    public void addCake(Cupcake cupcake) {
        cakes.add(cupcake);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
