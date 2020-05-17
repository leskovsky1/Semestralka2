
/**
 * Trieda slúži na spracovanie údajov o produkte
 */
public class Product implements InterfaceForProducts {
    protected int id;
    protected int price;
    protected int weight;
    protected String name;

    /**
     * Konštruktor
     *
     * @param id     id tovaru
     * @param price  cena tovaru
     * @param weight váha tovaru
     * @param name   meno tovaru
     */
    public Product(int id, int price, int weight, String name) {
        this.id = id;
        this.price = price;
        this.weight = weight;
        this.name = name;
    }

    /**
     * Funkcia vráti id tovaru
     *
     * @return id tovaru
     */
    public int getId() {
        return id;
    }

    /**
     * funkcia slúži na generovanie stringu pre zápis do súboru
     *
     * @return string pre zápis do súboru
     */
    public String getStringForWriteToFile() {
        return null;
    }

    /**
     * funkcia slúži na generovanie stringu pre výpis do konzoly
     *
     * @return string pre zápis do konzoly
     */
    public String getStringForPrintToConsole() {
        return null;
    }

    /**
     * Funkcia vráti váhu tovaru
     *
     * @return váhu tovaru
     */
    public int getWeight() {
        return weight;
    }
}
