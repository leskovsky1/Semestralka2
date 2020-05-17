import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Trieda je používaná na komunikáciu medzi vśetkými budovami
 */
public class HQ {
    private Factory factory;
    private Stock stock;
    private Shop shop;

    /**
     * Konštruktor - inicializuje inštancie budov
     */
    public HQ() {
        factory = new Factory();
        stock = new Stock();
        shop = new Shop();
    }

    /**
     * Funkcia vypíše obsah budov podľa zvolených parametrov
     */
    public void printInventory() {
        Scanner scn = new Scanner(System.in);
        System.out.println("Vyber zoznam ktoreho zariadenia chces vypisat zoznam");
        System.out.println(" 1 ... Obchod");
        System.out.println(" 2 ... Sklad");
        System.out.println(" 3 ... Tovaren\n");
        int val = scn.nextInt();
        switch (val) {
            case 1: {
                shop.printInventory();

                break;
            }
            case 2: {
                stock.printInventory();
                break;
            }
            case 3: {
                factory.printInventory();
                break;
            }
        }
    }

    /**
     * Funkcia vráti inštanciu tovaren
     * @return inštancia typu tovaren
     */
    public Factory getFactory() {
        return factory;
    }
    /**
     * Funkcia vráti inštanciu skladu
     * @return inštancia typu skladu
     */
    public Stock getStock() {
        return stock;
    }
    /**
     * Funkcia vráti inštanciu obchod
     * @return inštancia typu obchod
     */
    public Shop getShop() {
        return shop;
    }

    /**
     * Funkcia premiestni produkt z továrne do skladu
     */
    public void moveFromFactoryToStock() {
        Scanner scn = new Scanner(System.in);
        System.out.print("Zadajte id tovaru: ");
        int id = scn.nextInt();
        Product prod = factory.removeById(id);
        if (prod == null) {
            System.out.println("Prenos sa neuskutocnil ...produkt nebol najdeny");
        } else {
            stock.add(prod);
            System.out.println(prod.getStringForPrintToConsole());
            System.out.println("Prenos sa uskutocnil");

        }
    }

    /**
     * Funkcia premiestni produkt zo skladu do obchodu
     */
    public void moveFromStockToShop() {
        Scanner scn = new Scanner(System.in);
        System.out.print("Zadajte id tovaru: ");
        int id = scn.nextInt();
        Product prod = stock.removeById(id);
        if (prod == null) {
            System.out.println("Prenos sa neuskutocnil ...produkt nebol najdeny");
        } else {
            shop.add(prod);
            System.out.println(prod.getStringForPrintToConsole());
            System.out.println("Prenos sa uskutocnil");

        }
    }

    /**
     * Funkcia vytvorí nový produkt v továrni podľa zadaných parametrov
     */
    public void create() {
        Scanner scn = new Scanner(System.in);
        System.out.println("Vyberte si tovar: ");
        System.out.println("1 ... Kamera ");
        System.out.println("2 ... Fotoaparat ");
        System.out.println("3 ... Mobil ");
        System.out.println("Vyberte si tovar: ");
        int type = scn.nextInt();
        Product product = null;
        switch (type) {
            case 1: {
                product = factory.createCamera();
                break;
            }
            case 2: {
                product = factory.createPhotoCamera();
                break;
            }
            case 3: {
                product = factory.createMobile();
                break;
            }
        }
        if (product == null) {
            System.out.println("Predmet nebol vyrobeny");
        } else {
            System.out.println(product.getStringForPrintToConsole());
            System.out.println("Predmet bol vyrobeny");
        }
    }

    /**
     * Funkcia nájde miesto uloženia produktu a vypíse informácie
     */
    public void find() {
        Scanner scn = new Scanner(System.in);
        System.out.println("Zadaj parameter vyhladavania");
        System.out.println("1 ... ID ");
        int val = scn.nextInt();

        switch (val) {
            case 1: {
                System.out.print("Zadaj hladane id:");
                val = scn.nextInt();
                Product product = shop.getProductById(val);
                if (product != null) {
                    System.out.println("Predmet som nasiel v obchode");
                    System.out.println(product.getStringForPrintToConsole());
                    return;
                }
                product = stock.getProductById(val);
                if (product != null) {
                    System.out.println("Predmet som nasiel v sklade");
                    System.out.println(product.getStringForPrintToConsole());
                    return;
                }
                product = factory.getProductById(val);
                if (product != null) {
                    System.out.println("Predmet som nasiel v tovarni");
                    System.out.println(product.getStringForPrintToConsole());
                    return;
                }
                if (product == null) {
                    System.out.println("Predmet som nasiel v ziadnej budove");
                    return;
                }
                break;
            }
        }
    }

    /**
     * Funkcia vyhladá produkty podla zadaných parametrov
     * @return list vyfiltrovaných produktov
     */
    public List<Product> filter() {
        Scanner scn = new Scanner(System.in);
        System.out.println("Zadaj kriteria filtrovania");
        System.out.println("1 ... Vaha");
        int val = scn.nextInt();

        System.out.println("Zadaj odkadial chces filtrovat");
        System.out.println("1 ... Obchod");
        System.out.println("2 ... Sklad");
        System.out.println("3 ... Tovaren");
        int build = scn.nextInt();
        List<Product> res = new ArrayList<Product>();

        switch (val) {
            case 1: {
                System.out.print("Zadaj min");
                int min = scn.nextInt();
                System.out.print("Zadaj max");
                int max = scn.nextInt();
                switch (build) {
                    case 1: {
                        res = shop.filterByWeight(min, max);
                        break;
                    }
                    case 2: {
                        res = stock.filterByWeight(min, max);
                        break;
                    }
                    case 3: {
                        res = factory.filterByWeight(min, max);
                        break;
                    }
                }
                break;
            }
        }
        if (res.size() == 0) {
            System.out.println("Nenajdene ziadne vysledky");
        } else {
            for (int i = 0; i < res.size(); i++) {
                System.out.println(res.get(i).getStringForPrintToConsole());
            }
        }
        return res;
    }
}
