/**
 * Trieda slúži na spracovanie údajov o kamere
 */
public class Camera extends Product implements InterfaceForProducts {
    private boolean light;
    private boolean mic;
    private double cameraResolution;

    /**
     * Konštruktor
     *
     * @param id               id tovaru
     * @param price            cena tovaru
     * @param weight           váha tovaru
     * @param name             meno tovaru
     * @param light            vstavané svetlo
     * @param mic              vstavený mikrofon
     * @param cameraResolution rozlíšenie kamery
     */
    public Camera(int id, int price, int weight, String name, boolean light, boolean mic, double cameraResolution) {
        super(id, price, weight, name);
        this.light = light;
        this.mic = mic;
        this.cameraResolution = cameraResolution;
    }

    /**
     * funkcia slúži na generovanie stringu pre zápis do súboru
     *
     * @return string pre zápis do súboru
     */
    public String getStringForWriteToFile() {
        return "camera*" + id + "*" + price + "*" + weight + "*" + name + "*" + light + "*" + mic + "*" + cameraResolution;
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
                ", type-" + "Kamera" +
                ", light-" + light +
                ", mic-" + mic +
                ", cameraResolution-" + cameraResolution +
                ", id-" + id +
                ", price-" + price +
                ", weight-" + weight +
                ", name-" + name;
    }
}
