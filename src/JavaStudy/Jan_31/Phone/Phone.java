package JavaStudy.Jan_31.Phone;

public class Phone {
    String name;
    String address;
    String number;

    public Phone(String name, String address, String number) {
        this.name = name;
        this.address = address;
        this.number = number;
    }

    @Override
    public String toString() {
        return " " + this.name + " " + this.address + " " + this.number;
    }
}
