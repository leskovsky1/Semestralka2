import java.util.Scanner;

/**
 * Trieda slúži na spracovanie údajov o továrni
 */
public class Factory extends Building {
    /**
     * Konštruktor
     */
    public Factory() {
        super();
    }

    /**
     * Funkcia slúži na vytvorenie insťancie typu mobile
     *
     * @return vytvorena inštancia typu mobile
     */
    public Product createMobile() {
        Scanner scn = new Scanner(System.in);

        int id = findNewId();
        System.out.println("ID noveho produktu: " + id);
        System.out.print("Zadaj cenu mobilu: ");
        int price = scn.nextInt();
        System.out.print("Zadaj vahu mobilu:");
        int weight = scn.nextInt();
        System.out.print("Zadaj meno mobilu: ");
        String name = scn.next();
        System.out.print("Zadaj rozlisenie obrazovky mobilu: ");
        String disRes = scn.next();
        System.out.println("Zadaj velkost ram: ");
        int ram = scn.nextInt();
        System.out.print("Zadaj velkost vnutornej pamate: ");
        int intMem = scn.nextInt();
        Product prod = (new Mobile(id, price, weight, name, disRes, ram, intMem));
        productList.add(prod);
        return prod;
    }

    /**
     * Funkcia slúži na vytvorenie insťancie typu camera
     *
     * @return vytvorena inštancia typu camera
     */
    public Product createCamera() {
        Scanner scn = new Scanner(System.in);
        int id = findNewId();
        System.out.println("ID noveho produktu: " + id);
        System.out.print("Zadaj cenu kamery: ");
        int price = scn.nextInt();
        System.out.print("Zadaj vahu kamery:");
        int weight = scn.nextInt();
        System.out.print("Zadaj meno kamery: ");
        String name = scn.next();
        System.out.print("Svetlo (true/false): ");
        boolean light = Boolean.parseBoolean(scn.next());
        System.out.print("Mikrofon (true/false): ");
        boolean mic = Boolean.parseBoolean(scn.next());
        System.out.print("Rozlisenie kamery (px): ");
        double camRes = Double.parseDouble(scn.next());
        Product prod = (new Camera(id, price, weight, name, light, mic, camRes));
        productList.add(prod);
        return prod;
    }

    /**
     * Funkcia slúži na vytvorenie insťancie typu photoCamera
     *
     * @return vytvorena inštancia typu photoCamera
     */
    public Product createPhotoCamera() {
        Scanner scn = new Scanner(System.in);
        int id = findNewId();
        System.out.println("ID noveho produktu: " + id);
        System.out.print("Zadaj cenu photoaparatu: ");
        int price = scn.nextInt();
        System.out.print("Zadaj vahu photoaparatu:");
        int weight = scn.nextInt();
        System.out.print("Zadaj meno photoaparatu: ");
        String name = scn.next();
        System.out.print("Svetlo (true/false): ");
        boolean flash = Boolean.parseBoolean(scn.next());
        System.out.print("Mikrofon (true/false): ");
        boolean usb = Boolean.parseBoolean(scn.next());
        System.out.print("Rozlisenie  (px): ");
        double camRes = Double.parseDouble(scn.next());
        Product prod = (new PhotoCamera(id, price, weight, name, flash, camRes, usb));
        productList.add(prod);
        return prod;
    }
}
