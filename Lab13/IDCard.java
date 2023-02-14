public class IDCard extends Card {
    private int version = 1;

    public IDCard(String name, int ID) {
        super(name, ID);
    }

    public void replace() {
        version++;
    }

    public int getID() {
        return super.getID();
    }

    public void getInfo() {
        String info;
        info = String.format("<ID CARD INFO>\n" + "Name: %s\n" + "ID: %d\n" + "Card version: %d\n", this.getName(),
                this.getID(), version);
        System.out.println(info);
    }
}