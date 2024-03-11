import java.util.ArrayList;

public class VendingMachine {
    private double credit;
    private ArrayList<Product> products;

    public VendingMachine(double credit, ArrayList<Product> products) {
        this.credit = credit;
        this.products = new ArrayList<Product>(products);
    }

    public double getCredit() {
        return credit;
    }

    public ArrayList<Product> getProducts() {
        return new ArrayList<Product>(this.products);
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = new ArrayList<Product>(products);
    }
}
