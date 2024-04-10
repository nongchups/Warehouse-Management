//class for stock product
public class Inventory implements Product{
    public String productName;
    public int amount;

    Inventory(){
    }

    public Inventory(String productName, int amount) {
        this.productName = productName;
        this.amount = amount;
    }

    @Override
    public String getProductName() {
        return productName;
    }

    @Override
    public int getAmount() {
        return amount;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    //show product
    public String toString(){
        return "Product : " + productName + " | Total : " + amount;
    }
}
