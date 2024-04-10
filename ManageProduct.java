import java.util.ArrayList;
import java.util.Scanner;
//class for manage product in inventory
public class ManageProduct extends Inventory{
    ArrayList<Inventory> products = new ArrayList<>();
    public ManageProduct(ArrayList<Inventory> products){
        this.products = products;
    }
    public ManageProduct(String name,int amount){
        super(name,amount);
    }
    //add product
    public void addProduct(String product,int amount) {
        boolean found = false; //found product
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductName().equalsIgnoreCase(product)) {
                //new amount + old amount
                int newAmount = products.get(i).getAmount() + amount;
                //set product
                products.set(i, new ManageProduct(product, newAmount));
                found = true;
                break;
            }
        }
        //if don't have product add product
        if (!found) {
            products.add(new ManageProduct(product, amount));
        }
    }
    //delete product
    public void deleteProduct(String productName) {
        Scanner kb = new Scanner(System.in);
        boolean found = false;
        if (products.size() != 0){
            //found product
            for (int i = 0; i < products.size(); i++) {
                if (products.get(i).getProductName().equalsIgnoreCase(productName)) {
                    found = true;
                    //ask user to delete all
                    System.out.print("Do you want to delete all? (Y/N) : ");
                    String deleteCF = kb.next();
                    if (deleteCF.equals("Y")) {
                        System.out.print("Confirm to delete product (Y/N) : ");
                        String confirm = kb.next();
                        //delete all product
                        if (confirm.equalsIgnoreCase("Y")) {
                            products.remove(i);
                            System.out.println("Already delete all product");
                            break;
                        } else {
                            System.out.println("Can't delete product"); //user not confirm to delete
                        }
                    } else {
                        //delete some amount
                        System.out.print("How much do you want to delete? : ");
                        int delete = kb.nextInt(); //amount to delete
                        int amountProduct; //attribute to get amount product
                        for (int j = 0; j < products.size(); j++) {
                            if (products.get(j).getProductName().equalsIgnoreCase(productName)) {
                                System.out.print("Confirm to delete (Y/N) : ");
                                String confirm = kb.next();
                                if (confirm.equalsIgnoreCase("Y")) {
                                    amountProduct = products.get(j).getAmount() - delete; //amount - delete amount
                                    if (amountProduct > 0) {
                                        System.out.println("Your product remaining : " + amountProduct);
                                        products.set(j, new ManageProduct(productName, amountProduct)); //set amountProduct in amount
                                    } else {
                                        products.remove(j);
                                        //if delete > amount in stock is delete all
                                        System.out.println("Already delete all product");
                                        break;
                                    }
                                    //show still amount
                                } else {
                                    System.out.println("Can't delete product"); //user not confirm to delete
                                }
                            }
                        }
                    }
                }
            }
        }
        kb.close();
        //not found product
        if (!found){
            System.out.println("Not found. please try again!");
        }
    }
    //search product in inventory
    public void searchProduct(String productName){
        int count = 0;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductName().equalsIgnoreCase(productName)){
                System.out.println(products.get(i));
                count++;
                break;
            }
        }
        if (count == 0){
            System.out.println("Not found");
        }
    }
    //show all product
    public void showAllProduct() {
        if (products.size() != 0){
            System.out.printf("%-15s | %s\n","Product","Total");
            for (Inventory product : products) {
                System.out.println("---------------------------------");
                System.out.printf("%-15s | %d \n",product.getProductName(),product.amount);
            }
        }
        //don't have product in inventory
        else {
            System.out.println("Don't have product");
        }
    }
}
