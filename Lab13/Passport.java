public class Passport extends IDCard {
    protected String country;

    public Passport(String name, int ID, String country) {
        super(name, ID);
        this.country = country;
    }

    public void replace(String country) {
        this.country = country;
    }

    public void getInfo() {
        String info;
        info = String.format("<PASSPORT INFO>\n" + "Name: %s\n" + "ID: %d\n" + "Country: %s\n", name, ID, country);
        System.out.println(info);
    }
}