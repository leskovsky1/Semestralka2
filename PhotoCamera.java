 

/**
 * Trieda slúži na spracovanie údajov o fotoaparáte
 */
public class PhotoCamera extends Product implements InterfaceForProducts {
    private boolean externalFlash;
    private double cameraResolution;
    private boolean usb;

    /**
     * Konštruktor
     *
     * @param id               id tovaru
     * @param price            cena tovaru
     * @param weight           váha tovaru
     * @param name             meno tovaru
     * @param externalFlash    externý blesk
     * @param cameraResolution rozlíšenie kamery
     * @param usb              integrovaný USB port
     */
    public PhotoCamera(int id, int price, int weight, String name, boolean externalFlash, double cameraResolution, boolean usb) {
        super(id, price, weight, name);
        this.externalFlash = externalFlash;
        this.cameraResolution = cameraResolution;
        this.usb = usb;
    }

    /**
     * funkcia slúži na generovanie stringu pre zápis do súboru
     *
     * @return string pre zápis do súboru
     */
    public String getStringForWriteToFile() {
        return "photo*" + id + "*" + price + "*" + weight + "*" + name + "*" + externalFlash + "*" + cameraResolution + "*" + usb;
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
                ", PhotoCamera -" +
                ", externalFlash-" + externalFlash +
                ", cameraResolution-" + cameraResolution +
                ", usb-" + usb +
                ", id-" + id +
                ", price-" + price +
                ", weight-" + weight +
                ", name=" + name;
    }
}
