package FunctionLayer;

import java.util.ArrayList;

/**
 * A class to hold orders from the database.
 */

public class Order {

    private float subtotal;

    private ArrayList<Cupcake> cakes;

    private int id;
    
    public Order(ArrayList<Cupcake> cakes){
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
        subtotal = 0.00f;
        for(Cupcake c : cakes) {
            subtotal += c.getPrice();
        }
    }

    public void addCake(Cupcake cupcake) {
        cakes.add(cupcake);
        subtotal += cupcake.getPrice();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getSubtotal() {
        return subtotal;
    }

    @Override
    public String toString() {
        int counter = 0;

        for(Cupcake c : cakes) {
            counter++;
        }

        return "ID: " + id + " | " + "Amount: " + counter + " | " + "Total: " + subtotal + "kr.";
    }
}
