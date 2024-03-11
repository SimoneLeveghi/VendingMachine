import java.util.ArrayList;
import java.util.Arrays;

public class VendingMachine {
    private double credit;
    private ArrayList<Product> products;

    public VendingMachine(double credit, Product[] products) {
        setCredit(credit);
        setProducts(products);
    }

    public double getCredit() {
        return credit;
    }

    public Product[] getProducts() {
        return this.products.toArray(new Product[0]);
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public void setProducts(Product[] products) {
        this.products = new ArrayList<Product>(Arrays.asList(products));
    }

    public void editCredit(double additionalCredit) throws Exception {
        double amountEdited;
        if(
                additionalCredit <= 0 &&
                Math.abs(additionalCredit) > this.credit
        ) throw new Exception("Invalid amount");

        this.credit += additionalCredit;
    }

    public void buyProduct(int index) throws Exception {
        if(index < 0) throw new ArrayIndexOutOfBoundsException("Invalid index");

        double cost;
        if((cost = products.get(index).getPrice()) > credit) throw new Exception("Not enough credit");
        editCredit(-cost);
    }
}
