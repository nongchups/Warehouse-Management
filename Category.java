public class Category{
    String category;

    public Category() {
    }

    public Category(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    public String toString() {
        return "Category : " + getCategory();
    }
}
