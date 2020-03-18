package FunctionLayer;

import java.util.ArrayList;

public class Order {

    private float subtotal;

    private ArrayList<Cupcake> cakes;

    Order(ArrayList<Cupcake> cakes){
        this.cakes = cakes;

        for(Cupcake c : cakes) {
            subtotal += c.getPrice();
        }
    }
}
