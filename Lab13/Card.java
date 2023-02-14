public abstract class Card {
    protected String name;
    protected int ID;

    public Card(String name) {
        this.name = name;
    }

    public Card(String name, int ID) {
        this.name = name;
        this.ID = ID;
    }

    public void changeName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }

    public abstract void getInfo();
}