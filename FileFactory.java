import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Trieda sa používa na prácu so súbormi
 */
public class FileFactory {

    /**
     * Konštruktor
     */
    public FileFactory() {
    }

    /**
     * funkcia je pužívaná na zapisovanie do súboru
     *
     * @param nameOfFile  názov súboru do ktorého bude zapisované
     * @param factoryList list produktov uložených v tovarni
     * @param stockList   list produktov uložených v sklade
     * @param shopList    list produktov uložených v obchode
     */
    public void writeFile(String nameOfFile, List<Product> factoryList, List<Product> stockList, List<Product> shopList) {
        try {
            FileWriter writer = new FileWriter(nameOfFile);
            for (int i = 0; i < factoryList.size(); i++) {
                writer.write("factory*" + factoryList.get(i).getStringForWriteToFile() + "\n");
            }
            for (int i = 0; i < stockList.size(); i++) {
                writer.write("stock*" + stockList.get(i).getStringForWriteToFile() + "\n");
            }
            for (int i = 0; i < shopList.size(); i++) {
                writer.write("shop*" + shopList.get(i).getStringForWriteToFile() + "\n");
            }
            writer.close();
            System.out.println("Zapisane do suboru");

        } catch (IOException e) {
            System.out.println("CHYBA");
            e.printStackTrace();
        }
    }

    /**
     * funkcia je používaná na čítanie zo súboru
     *
     * @param nameOfFile názov súboru z ktorého budú čítané údaje
     * @return list kde na indexe 0 je list produktov pre obchod, 1 list produktov pre sklad, 2 list produktov pre tovaren
     */
    public List<List<Product>> readFile(String nameOfFile) {
        List<Product> shopList = new ArrayList<Product>();
        List<Product> stockList = new ArrayList<Product>();
        List<Product> factoryList = new ArrayList<Product>();
        File file = new File(nameOfFile);
        try {
            Scanner scn = new Scanner(file);

            while (scn.hasNextLine()) {
                Product pom = null;
                String riadok = scn.nextLine();
                String parsedLine[] = riadok.split("\\*");

                String building = parsedLine[0];
                String product = parsedLine[1];
                int id = Integer.parseInt(parsedLine[2]);
                int price = Integer.parseInt(parsedLine[3]);
                int weight = Integer.parseInt(parsedLine[4]);
                String name = parsedLine[5];

                if (product.equals("mobile")) {
                    String disRes = parsedLine[6];
                    int ram = Integer.parseInt(parsedLine[7]);
                    int intMem = Integer.parseInt(parsedLine[8]);

                    pom = new Mobile(id, price, weight, name, disRes, ram, intMem);
                }
                if (product.equals("camera")) {

                    boolean light = Boolean.parseBoolean(parsedLine[6]);
                    boolean mic = Boolean.parseBoolean(parsedLine[7]);
                    double camRes = Double.parseDouble(parsedLine[8]);
                    pom = new Camera(id, price, weight, name, light, mic, camRes);
                }
                if (product.equals("photo")) {

                    boolean flash = Boolean.parseBoolean(parsedLine[6]);
                    double camRes = Double.parseDouble(parsedLine[7]);
                    boolean usb = Boolean.parseBoolean(parsedLine[8]);
                    pom = new PhotoCamera(id, price, weight, name, flash, camRes, usb);
                }
                if (building.equals("stock")) {
                    stockList.add(pom);
                }
                if (building.equals("shop")) {
                    shopList.add(pom);
                }
                if (building.equals("factory")) {
                    factoryList.add(pom);
                }
            }
            scn.close();
            System.out.println("Nacitanie uspesne");
        } catch (FileNotFoundException e) {
            System.out.println("Subor nenajdeny");
            return null;
        }
        List<List<Product>> res = new ArrayList<>();
        res.add(shopList);
        res.add(stockList);
        res.add(factoryList);

        return res;

    }
}
