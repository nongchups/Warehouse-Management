import java.util.ArrayList;
import java.util.Scanner;
//class for manage warehouse
public class WarehouseManagement implements Product{
    String category;
    String productName;
    int amount;
    ArrayList<Inventory> inventory = new ArrayList<>(); //inventory
    ArrayList<Category> categories = new ArrayList<>();//category
    ArrayList<WarehouseManagement> warehouses = new ArrayList<>();//warehouse

    public WarehouseManagement(ArrayList<Inventory> inventory, ArrayList<Category> categories, ArrayList<WarehouseManagement> warehouses) {
        this.inventory = inventory;
        this.categories = categories;
        this.warehouses = warehouses;
    }


    public WarehouseManagement(String category, String productName, int amount) {
        this.productName = productName;
        this.amount = amount;
        this.category = category;
    }

    @Override
    public String getProductName() {
        return productName;
    }

    @Override
    public int getAmount() {
        return amount;
    }

    //add product in category
    public void addProductInCategory(String category,String productName){
        boolean foundCategory = false;
        boolean foundProduct = false;
        for (int i = 0; i < categories.size(); i++) {
            //found category
            if (categories.get(i).getCategory().equalsIgnoreCase(category)){
                foundCategory = true;
                for (int j = 0; j < inventory.size(); j++) {
                    //found product
                    if (inventory.get(j).getProductName().equalsIgnoreCase(productName)){
                        foundProduct = true;
                        //add product in category
                        warehouses.add(new WarehouseManagement(category,productName,inventory.get(j).getAmount()));
                        System.out.println("Product already add to category.");
                        break;
                    }
                }
            }
        }
        if (!foundCategory){
            System.out.println("Category not found.");
        }
        if (!foundProduct){
            System.out.println("Product not found.");
        }
    }
    //delete product from category
    public void deleteProductInCategory(String category,String productName){
        Scanner kb = new Scanner(System.in);
        boolean foundCategory = false;
        boolean foundProduct = false;
        for (int i = 0; i < warehouses.size(); i++) {
            if (warehouses.get(i).category.equalsIgnoreCase(category)){
                foundCategory = true;
                if (warehouses.get(i).productName.equalsIgnoreCase(productName)){
                    foundProduct = true;
                    System.out.print("Confirm to delete product from category (Y/N) : ");
                    String confirm = kb.next();
                    if (confirm.equalsIgnoreCase("Y")){
                        warehouses.remove(i);
                        System.out.println("Already delete product from category.");
                        break;
                    }
                }
            }
        }
        kb.close();
        if (!foundCategory){
                System.out.println("Category not found.");
        }
        if (!foundProduct){
                System.out.println("Product not found.");
        }
    }
    //change category
    public void changeCategory(String category,String productName){
        Scanner kb  = new Scanner(System.in);
        boolean foundCategory = false;
        boolean foundProduct = false;
        for (int i = 0; i < warehouses.size(); i++) {
            //found category
            if (warehouses.get(i).category.equalsIgnoreCase(category)){
                foundCategory = true;
                //found product
                for (int j = 0; j < warehouses.size(); j++) {
                    if (warehouses.get(j).productName.equalsIgnoreCase(productName)){
                        foundProduct = true;
                        //confirm to change category
                        System.out.print("Confirm to change (Y/N) : ");
                        String confirm = kb.next();
                        if (confirm.equalsIgnoreCase("Y")){
                            //remove old category
                            warehouses.remove(j);
                            //add new category
                            warehouses.add(new WarehouseManagement(category,productName,inventory.get(i).getAmount()));
                            System.out.println("Already change the category.");
                            break;
                        }else {
                            System.out.println("Can't not change category.");
                        }
                        break;
                    }
                }
            }
        }
        kb.close();
        if (!foundCategory){
            System.out.println("Category not found.");
        }
        if (!foundProduct){
            System.out.println("Product not found.");
        }
    }
    //show all
    public void showAllWarehouse(){
        if (warehouses.size() != 0){
        System.out.printf("%-15s | %-15s | %s\n","Category","Product","Total");
            for (WarehouseManagement warehouse : warehouses) {
                System.out.println("-------------------------------------------");
                System.out.printf("%-15s | %-15s | %d\n", warehouse.category, warehouse.productName, warehouse.amount);
            }
        }else {
            System.out.println("...Empty...");
        }
    }
    @Override
    public String toString() {
        return  String.format("\n%-15s | %-15s | %d\n",category,productName,amount);
    }
}
