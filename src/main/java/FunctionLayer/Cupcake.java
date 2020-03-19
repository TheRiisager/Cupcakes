package FunctionLayer;
import java.util.ArrayList;
import java.util.HashMap;

public class Cupcake {
    private String bottom;
    private String top;
    private String name;

    private float price;

    private static HashMap<String, Top> tops;
    private static HashMap<String, Bottom> bottoms;

    public Cupcake(String bottom, String top){

        if(tops == null || bottoms == null) {
            //TODO Load items from DB
        }

        this.bottom = bottom;
        this.top = top;
        this.name = bottom + " " + top;

        this.price = tops.get(top).getPrice() + bottoms.get(bottom).getPrice();

    }

    public float getPrice() {
        return price;
    }

    public static void addTop(String string, Top top){
        tops.put(string,top);
    }

    public static void addBottom(String string, Bottom bottom){
        bottoms.put(string,bottom);
    }
}
