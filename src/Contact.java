
public class Contact implements Comparable<Contact> {

    private String name;
    private String number;

    public Contact(String name, String number) {
        this.name = name;
        this.number = number;
    }

    @Override
    public String toString() {
        return "Имя: " + name + ", Телефон: " + "(" + number + ")";
    }

    @Override
    public int compareTo(Contact o) {
        return this.number.compareTo(o.number);
    }
}
