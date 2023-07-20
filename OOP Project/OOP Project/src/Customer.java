public class Customer {
    String id;
    String name;
    String surname;

    public Customer() {
        setId("");
        setName("");
        setSurname("");
    }

    public Customer(String id, String name, String surname) {
        setId(id);
        setName(name);
        setSurname(surname);
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String sur) {
        this.surname = sur;
    }

    public String getId() {
        return (this.id);
    }

    public String getName() {
        return (this.name);
    }

    public String getSurname() {
        return (this.surname);
    }

    public String toString() {
        return (getId() + "," + getName() + "," + getSurname());
    }
}
