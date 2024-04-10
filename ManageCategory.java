import java.util.ArrayList;
import java.util.Scanner;
//class for manage category

public class ManageCategory extends Category{
    ArrayList<Category> categories = new ArrayList<>();

    public ManageCategory(String category) {
        super(category);
    }
    public ManageCategory(ArrayList<Category> categories) {
        super();
        this.categories = categories;
    }
    //add category
    public void addCategory(String category){
        boolean found = false; //check category in category inventory
        for (int i = 0; i < categories.size(); i++) {
            if (categories.get(i).getCategory().equalsIgnoreCase(category)) {
                System.out.println("Already have this category.");
                found = true;
                break;
            }
        }
        //if don't have category add category
        if (!found) {
            categories.add(new ManageCategory(category));
        }
    }
    //remove category
    public void deleteCategory(String category){
        Scanner kb = new Scanner(System.in);
        boolean foundCategory = false;
        for (int i = 0; i < categories.size(); i++) {
            if (categories.get(i).getCategory().equalsIgnoreCase(category)){
                foundCategory = true;
                System.out.print("Confirm to delete category (Y/N) : ");
                String confirm = kb.next();
                //delete category
                if (confirm.equalsIgnoreCase("Y")){
                    categories.remove(i);
                    System.out.println("Already delete category");
                    break;
                }else {
                    System.out.println("Please  try again");
                }
            }
        }
        kb.close();
        //not found category
        if (!foundCategory){
            System.out.println("Not found");
        }
    }
    //find category
    public void searchCategory(String category){
        boolean foundCategory = false;
        for (int i = 0; i < categories.size(); i++) {
            if (categories.get(i).getCategory().equalsIgnoreCase(category)){
                System.out.println(categories.get(i));
                foundCategory = true;
                break;
            }
        }
        if (!foundCategory){
            System.out.println("Not found");
        }
    }
    //show all category
    public void showAllCategory(){
        if (categories.size() != 0){
            for(Category ctg : categories){
                System.out.println("Category : " + ctg.getCategory());
            }
        }else {
            System.out.println("Don't have category.");
        }
    }
}
