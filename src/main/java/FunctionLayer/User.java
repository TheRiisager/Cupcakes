package FunctionLayer;

import DBAccess.OrderMapper;

/**
 * The purpose of User is to...
 * @author kasper
 */
public class User {

    public User( String email, String password, String role ) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    private int id; // just used to demo retrieval of autogen keys in UserMapper
    private String email;
    private String password; // Should be hashed and secured
    private String role;

    private Order userOrder;

    public Order getUserOrder() {
        return userOrder;
    }

    public void setUserOrder() {
        this.userOrder = new Order( OrderMapper.cartLoader( this.id ) );
    }

    public void setUserOrder(Order o) {
        this.userOrder = o;
    }

    public void addToOrder(Cupcake cupcake) {
        this.userOrder.addCake(cupcake);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail( String email ) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword( String password ) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole( String role ) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId( int id ) {
        this.id = id;
    }

}
