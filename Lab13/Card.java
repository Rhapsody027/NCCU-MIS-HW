public abstract class Card {
    private String name;
    private int ID;

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