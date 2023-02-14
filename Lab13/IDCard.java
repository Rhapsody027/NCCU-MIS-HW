public class IDCard extends Card {
    protected int version = 1;

    public IDCard(String name, int ID) {
        super(name, ID);
    }

    public void replace() {
        version++;
    }

    public int getID() {
        return ID;
    }

    public void getInfo() {
        String info;
        info = String.format("<ID CARD INFO>\n" + "Name: %s\n" + "ID: %d\n" + "Card version: %d\n", name, ID, version);
        System.out.println(info);
    }
}