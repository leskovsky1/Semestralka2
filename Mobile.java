 

/**
 * Trieda slúži na spracovanie údajov o mobile
 */
public class Mobile extends Product implements InterfaceForProducts {
    private String displayResolution;
    private int ramMemory;
    private int internalMemory;

    /**
     * Konštruktor
     *
     * @param id                id tovaru
     * @param price             cena tovaru
     * @param weight            váha tovaru
     * @param name              meno tovaru
     * @param displayResolution rozlíšenie dipleja
     * @param ramMemory         množstvo ram pamäte
     * @param internalMemory    množstvo ram vnútornej pamäte
     */
    public Mobile(int id, int price, int weight, String name, String displayResolution, int ramMemory, int internalMemory) {
        super(id, price, weight, name);
        this.displayResolution = displayResolution;
        this.ramMemory = ramMemory;
        this.internalMemory = internalMemory;
    }

    /**
     * funkcia slúži na generovanie stringu pre zápis do súboru
     *
     * @return string pre zápis do súboru
     */
    public String getStringForWriteToFile() {
        return "mobile*" + id + "*" + price + "*" + weight + "*" + name + "*" + displayResolution + "*" + ramMemory + "*" + internalMemory;
    }

    /**
     * funkcia slúži na generovanie stringu pre výpis do konzoly
     *
     * @return string pre zápis do konzoly
     */
    public String getStringForPrintToConsole() {
        return "id-" + id +
                ", price-" + price +
                ", weight-" + weight +
                ", name-" + name +
                ", type-" + "Mobile" +
                ", displayResolution-" + displayResolution +
                ", ramMemory-" + ramMemory +
                ", internalMemory-" + internalMemory +
                ", id-" + id +
                ", price-" + price +
                ", weight-" + weight +
                ", name-" + name;
    }
}
