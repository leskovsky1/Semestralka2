import java.util.Scanner;

/**
 * Trieda slúži na spracovanie údajov o obchode
 */
public class Shop extends Building {
    /**
     * Konštruktor
     */
    public Shop() {
        super();
    }



    /**
     * Funkcia slúži na predanie produktu
     */
    public void sell() {
        Scanner scn = new Scanner(System.in);
        System.out.print("Zadaj id predavaneho tovaru: ");
        int id = scn.nextInt();
        Product prod = removeById(id);
        if (prod == null) {
            System.out.println("Predaj sa neuskutocnil ...produkt nebol najdeny");
        } else {
            System.out.println(prod.getStringForPrintToConsole());
            System.out.println("Predaj sa uskutocnil ... nezabudnite na pokladnicky blok");

        }
    }
}
