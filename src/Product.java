public class Product {
    private String name;
    private double price;

    public Product(String name, double price) throws Exception {
        setName(name);
        setPrice(price);
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
        this.name = this.name.trim();
        while(this.name.contains("  ")) {
            this.name = this.name.replaceAll("  ", " ");
        }
        this.name = this.name.toLowerCase();
        this.name = Character.toUpperCase(this.name.charAt(0)) + this.name.substring(1);
    }

    public void setPrice(double price) throws Exception {
        if(price <= 0) throw new Exception("Invalid price");
        this.price = price;
    }
}
