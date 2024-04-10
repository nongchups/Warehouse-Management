import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

//Main Program
public class Main {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        ArrayList<Inventory> arrListProduct = new ArrayList<>();
        ArrayList<Category> arrListCategory = new ArrayList<>();
        ArrayList<WarehouseManagement> arrListWarehouse = new ArrayList<>();
        //loop program
        for (;;) {
                //choose program
                System.out.println("\n###########################################");
                System.out.println("#       Warehouse Management System       #");
                System.out.println("###########################################");
                System.out.println("    1. Manage product");
                System.out.println("    2. Manage category");
                System.out.println("    3. Manage warehouse");
                System.out.println("    q. Quit");
                System.out.println("-------------------------------------------");
                System.out.print("Enter your choice : ");
                try {
                String choose = kb.next();
                //manage product
                if (choose.equalsIgnoreCase("1")) {
                    for (;;) {
                        System.out.println("********************************************");
                        System.out.println("*           -Product Management-           *");
                        System.out.println("*            select the program            *");
                        System.out.println("********************************************");
                        System.out.println("     a. Add product");
                        System.out.println("     b. Remove product");
                        System.out.println("     c. Search product");
                        System.out.println("     d. Show all product");
                        System.out.println("     h. Back to home page \n---------------------------------");
                        System.out.print("Enter your choice : ");
                        String choice = kb.next(); //input choice
                        System.out.println("---------------------------------");

                        ManageProduct product = new ManageProduct(arrListProduct);

                        //add product in inventory
                        if (choice.equalsIgnoreCase("a")) {
                            System.out.print("Enter the quantity of product : ");
                            int n = kb.nextInt();
                            for (int i = 0; i < n; i++) {
                                System.out.print("Enter your product : ");
                                String name = kb.next();
                                product.setProductName(name);
                                System.out.print("Enter amount product : ");
                                int amount = kb.nextInt();
                                product.setAmount(amount);
                                product.addProduct(name, amount);
                                System.out.println("----------------Add Product----------------");
                                System.out.printf("%-15s | %s\n","Product","Total");
                                System.out.println("-------------------------------------------");
                                System.out.printf("%-15s | %d\n",product.getProductName(), product.getAmount());
                                System.out.println("-------------------------------------------");
                            }
                        }
                        //remove product in inventory
                        else if (choice.equalsIgnoreCase("b")) {
                            if (arrListProduct.size() != 0) {
                                System.out.printf("%-15s | %s\n", "Product", "Total");
                                for (Inventory products : arrListProduct) {
                                    System.out.println("---------------------------------");
                                    System.out.printf("%-15s | %d \n", products.getProductName(), products.amount);
                                }
                                System.out.print("Enter your product : ");
                                String name = kb.next();
                                product.setProductName(name);
                                product.deleteProduct(name);
                            }else {
                                System.out.println("Don't have product");
                            }
                        }
                        //find product in inventory
                        else if (choice.equalsIgnoreCase("c")) {
                            System.out.print("Enter your product : ");
                            String name = kb.next();
                            product.setProductName(name);
                            product.searchProduct(name);
                        }
                        //show all product in inventory
                        else if (choice.equalsIgnoreCase("d")) {
                            product.showAllProduct();
                        }
                        //exit menu
                        else if (choice.equalsIgnoreCase("h")) {
                            break;
                        }
                    }
                }
                //manage category
                else if (choose.equalsIgnoreCase("2")) {
                    for (;;){
                        System.out.println("********************************************");
                        System.out.println("*           -Category Management-          *");
                        System.out.println("*            select the program            *");
                        System.out.println("********************************************");
                        System.out.println("     a. Add category");
                        System.out.println("     b. Remove category");
                        System.out.println("     c. Search category");
                        System.out.println("     d. Show all category");
                        System.out.println("     h. Back to home page \n-------------------------------------------");
                        System.out.print("Enter your choice : ");
                        String choice = kb.next(); //input choice
                        System.out.println("-------------------------------------------");

                        ManageCategory category = new ManageCategory(arrListCategory);
                        //add category
                        if (choice.equalsIgnoreCase("a")) {
                            //amount product to add
                            System.out.print("Enter the quantity of category : ");
                            int n = kb.nextInt();
                            for (int i = 0; i < n; i++) {
                                System.out.print("Enter your category : ");
                                String categoryName = kb.next();
                                category.setCategory(categoryName);
                                category.addCategory(categoryName);
                                System.out.println("---------------Add Category----------------");
                                System.out.println(category);
                                System.out.println("-------------------------------------------");
                            }
                        }
                        //remove category
                        else if (choice.equalsIgnoreCase("b")) {
                            if (arrListCategory.size() != 0){
                                for(Category ctg : arrListCategory){
                                    System.out.println("Category : " + ctg.getCategory());
                                }
                                System.out.print("Enter your category : ");
                                String categoryName = kb.next();
                                category.setCategory(categoryName);
                                category.deleteCategory(categoryName);
                            }else {
                                System.out.println("Don't have category");
                            }
                        }
                        //search category
                        else if (choice.equalsIgnoreCase("c")) {
                            System.out.print("Enter your category : ");
                            String categoryName = kb.next();
                            category.setCategory(categoryName);
                            category.searchCategory(categoryName);
                        }
                        //show all category
                        else if (choice.equalsIgnoreCase("d")) {
                            category.showAllCategory();
                        }
                        //exit menu
                        else if (choice.equalsIgnoreCase("h")) {
                            break;
                        }
                    }
                } else if (choose.equalsIgnoreCase("3")) {
                    for(;;){
                        System.out.println("********************************************");
                        System.out.println("*           -Warehouse Management-         *");
                        System.out.println("*             select the program           *");
                        System.out.println("********************************************");
                        System.out.println("    a. Add product in category");
                        System.out.println("    b. Remove product in category");
                        System.out.println("    c. Change product in other category");
                        System.out.println("    d. Show all warehouse");
                        System.out.println("    h. Back to home page \n-------------------------------------------");
                        System.out.print("Enter your choice : ");
                        String choice = kb.next(); //input choice
                        System.out.println("-------------------------------------------");

                        WarehouseManagement warehouse = new WarehouseManagement(arrListProduct, arrListCategory, arrListWarehouse);
                        //add product in category
                        if (choice.equalsIgnoreCase("a")) {
                            System.out.println(arrListCategory);
                            System.out.println(arrListProduct);
                            System.out.print("Enter the category : ");
                            String category = kb.next(); //input category
                            System.out.print("Enter the product to add in category : ");
                            String name = kb.next(); //input product user want to add in  category
                            warehouse.addProductInCategory(category,name);
                        }
                        //delete product from category
                        else if (choice.equalsIgnoreCase("b")) {
                            if (arrListWarehouse.size() != 0) {
                                System.out.printf("%-15s | %-15s | %s\n", "Category", "Product", "Total");
                                for (WarehouseManagement warehouses : arrListWarehouse) {
                                    System.out.println("-------------------------------------------");
                                    System.out.printf("%-15s | %-15s | %d\n", warehouses.category, warehouses.productName, warehouses.amount);
                                }
                                System.out.print("Enter the category : ");
                                String category = kb.next();
                                System.out.print("Enter the product your want to delete : ");
                                String name = kb.next();
                                warehouse.deleteProductInCategory(category, name);
                            }else {
                                System.out.println("...Empty...");
                            }
                        }
                        //change category
                        else if (choice.equalsIgnoreCase("c")) {
                            if (arrListWarehouse.size() != 0) {
                                System.out.printf("%-15s | %-15s | %s\n", "Category", "Product", "Total");
                                for (WarehouseManagement warehouses : arrListWarehouse) {
                                    System.out.println("-------------------------------------------");
                                    System.out.printf("%-15s | %-15s | %d\n", warehouses.category, warehouses.productName, warehouses.amount);
                                }
                                System.out.print("Enter a new category : ");
                                String newCtgName = kb.next(); //input new category to add product
                                System.out.print("Enter the product you want to change : ");
                                String pdName = kb.next(); //input product user want to change category
                                warehouse.changeCategory(newCtgName, pdName);
                            }else {
                                    System.out.println("...Empty...");
                                }
                        }
                        //show
                        else if (choice.equalsIgnoreCase("d")) {
                            warehouse.showAllWarehouse();
                        }
                        //exit menu
                        else if (choice.equalsIgnoreCase("h")) {
                            break;
                        }
                    }
                }
                //exit program
                else if (choose.equalsIgnoreCase("q")) {
                    System.out.println("Exiting the program...");
                    break;
                }
            }catch (InputMismatchException ip){
                System.out.println("Enter only number. Please try again!");
            }
            kb.close();
        }
    }
}
