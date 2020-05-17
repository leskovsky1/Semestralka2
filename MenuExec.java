import java.util.List;
import java.util.Scanner;

/**
 * Trieda je puožívaná na základné ovládanie programu
 */
public class MenuExec {
    private HQ hq = new HQ();
    private FileFactory ff = new FileFactory();

    /**
     * Konštruktor
     */
    public MenuExec() {
    }

    /**
     * Základná funkcia na ovládanie celého programu
     */
    public void start() {
        Scanner scn = new Scanner(System.in);
        while (1 == 1) {
            MenuPrinter.printMenu();
            String pom = scn.next();
            System.out.println("");
            switch (pom) {
                case "nacitaj": {
                    List<List<Product>> list = ff.readFile("Data.txt");
                    hq.getShop().setProductList(list.get(0));
                    System.out.println();
                    hq.getStock().setProductList(list.get(1));
                    hq.getFactory().setProductList(list.get(2));
                    break;
                }
                case "zapis": {
                    ff.writeFile("data.txt", hq.getFactory().getProductList(), hq.getStock().getProductList(), hq.getShop().getProductList());
                    break;
                }

                case "predaj": {
                    hq.getShop().sell();
                    break;
                }

                case "objednaj": {
                    hq.moveFromStockToShop();
                    break;
                }

                case "vyrob": {
                    hq.create();
                    break;
                }

                case "naskladni": {
                    hq.moveFromFactoryToStock();
                    break;
                }
                case "vypis": {
                    hq.printInventory();
                    break;
                }

                case "filtruj": {
                    hq.filter();
                    break;
                }

                case "hladaj": {
                    hq.find();
                    break;
                }

                case "koniec": {
                    System.out.println("Dakujeme za puzitie .... dovidenia");
                    System.exit(1);
                }
                case "sranda": {
                    Mobile mobile1 = new Mobile(1, 100, 150, "Mobil1", "1920x1080", 2, 160);
                    Camera camera1 = new Camera(2, 120, 800, "Camera1", true, true, 21.5);
                    PhotoCamera PhotoCamera1 = new PhotoCamera(2, 450, 555, "PhotoCamera1", true, 25.3, true);

                    Mobile mobile2 = new Mobile(3, 150, 150, "Mobil2", "1920x1080", 2, 160);
                    Camera camera2 = new Camera(4, 450, 800, "Camera2", true, false, 21.5);
                    PhotoCamera PhotoCamera2 = new PhotoCamera(2, 205, 555, "PhotoCamera2", true, 25.3, true);

                    Mobile mobile3 = new Mobile(5, 222, 150, "Mobil3", "1920x1080", 2, 160);
                    Camera camera3 = new Camera(6, 333, 800, "Camera3", false, true, 21.5);
                    PhotoCamera PhotoCamera3 = new PhotoCamera(2, 444, 888, "PhotoCamera3", true, 25.3, true);

                    hq.getShop().add(mobile1);
                    hq.getShop().add(camera1);
                    hq.getShop().add(PhotoCamera1);

                    hq.getStock().add(mobile2);
                    hq.getStock().add(camera2);
                    hq.getStock().add(PhotoCamera2);

                    hq.getFactory().add(mobile3);
                    hq.getFactory().add(camera3);
                    hq.getFactory().add(PhotoCamera3);
                    break;
                }
            }
        }
    }
}
