import java.util.ArrayList;
import java.util.Scanner;

public class Lab13 {
    private static ArrayList<Card> cards = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Choose the service.");
            char service = scanner.next().charAt(0);

            if (service == 'A') {
                System.out.println("Choose the card.");
                char kind = scanner.next().charAt(0);
                Card newCard = null;

                if (kind == 'a') {
                    System.out.println("Input name and ID:");
                    newCard = new IDCard(scanner.next(), scanner.nextInt());

                } else if (kind == 'b') {
                    System.out.println("Input name and expire year:");
                    newCard = new BankCard(scanner.next(), scanner.nextInt());

                } else if (kind == 'c') {
                    System.out.println("Input name, ID and country:");
                    newCard = new Passport(scanner.next(), scanner.nextInt(), scanner.next());
                }

                cards.add(newCard);
                cards.get(cards.size() - 1).getInfo();

            } else if (service == 'B') {
                System.out.println("Input your name: ");
                Card card = getCard(scanner.next());

                if (card == null) {
                    System.out.println("No corresponding card.");
                } else {
                    System.out.println("Input your new name: ");
                    card.changeName(scanner.next());
                    card.getInfo();
                }
            } else if (service == 'C') {
                System.out.println("Input your name: ");
                Card card = getCard(scanner.next());

                if (card == null) {
                    System.out.println("No corresponding card.");

                } else {
                    if (card instanceof Passport) {
                        System.out.println("Input new country: ");
                        Passport c = (Passport) card;
                        c.replace(scanner.next());

                    } else if (card instanceof IDCard) {
                        IDCard c = (IDCard) card;
                        c.replace();

                    } else if (card instanceof BankCard) {
                        System.out.println("Input this year: ");
                        BankCard c = (BankCard) card;
                        c.replace(scanner.nextInt());
                    }

                    card.getInfo();
                }

            } else if (service == 'D') {
                break;
            }
        }
        scanner.close();
    }

    public static Card getCard(String name) {
        Card card = null;
        for (Card c : cards) {
            if (c.getName().equals(name)) {
                card = c;
                break;
            }
        }
        return card;
    }
}
