public class Product {
    String id;
    String name;
    float price;

    public Product() {
        setId("");
        setName("");
        setPrice(0.0f);
    }

    public Product(String id, String name, float price) {
        setId(id);
        setName(name);
        setPrice(price);
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getId() {
        return (this.id);
    }

    public String getName() {
        return (this.name);
    }

    public float getPrice() {
        return (this.price);
    }

    public String toString() {
        return (getId() + "," + getName() + "," + getPrice());
    }
}