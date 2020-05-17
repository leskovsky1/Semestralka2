import java.util.ArrayList;
import java.util.List;

/**
 * Trieda slúžiaca na ukladanie informácií o jednotlivých budovách
 */
public class Building {
    protected List<Product> productList;

    /**
     * Konštruktor
     */
    public Building() {
        this.productList = new ArrayList<Product>();
    }

    /**
     * Funkcia slúži na nájdenie nového id pre nový výrobok
     *
     * @return nove id pre produkt
     */
    public int findNewId() {
        int max = 0;
        for (int i = 0; i < productList.size(); i++) {
            int id = productList.get(i).getId();
            if (max < id) {
                max = id;
            }
        }
        max += 1;
        return max;
    }

    /**
     * funkcia slúži na získanie listu produktov
     *
     * @return list produktov
     */
    public List<Product> getProductList() {
        return productList;
    }

    /**
     * funkcia je používaná na nastavenie listu produktov danej budovy
     *
     * @param productList list ktorý má byť nastavený
     */
    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    /**
     * Funkcia je používaná na pridanie produktu do listu produktov
     *
     * @param product
     */
    public void add(Product product) {
        productList.add(product);
    }

    /**
     * funkcia je používaná na získanie indexu produktu v liste produktov
     *
     * @param id id hladaneho produktu
     * @return index v poli hladaneho produktu
     */
    private int getIndexOfProductByID(int id) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Funkcia je používaná na získanie inštancie typu produkt podla id
     *
     * @param id id hladaneho produktu
     * @return najdenú inštanciu typu produkt
     */
    public Product getProductById(int id) {
        int index = getIndexOfProductByID(id);
        if (index != -1) {
            return productList.get(index);
        }
        return null;
    }

    /**
     * Funkcia odstráni produkt definovany podla id produktu
     *
     * @param idOfProduct id produktu ktorý má byť odstránený
     * @return odstránený produkt
     */
   protected Product removeById(int idOfProduct) {
        int index = getIndexOfProductByID(idOfProduct);
        Product res = getProductById(idOfProduct);
        if(index == -1)
        {
            return null;
        }
        productList.remove(index);
        return res;
    }


    /**
     * Vypíše zoznam produktov
     */
    public void printInventory() {
        if (productList.size() == 0) {
            System.out.println("Ziadne produkty sa tu nenachadzaju");
        }
        for (int i = 0; i < productList.size(); i++) {
            System.out.println(productList.get(i).getStringForPrintToConsole());
        }
    }

    /**
     * Funkcia vyfiltruje produkty podla váhy
     *
     * @param min dolná hranica
     * @param max horná hranica
     * @return list nájdených produktov
     */
    public List<Product> filterByWeight(int min, int max) {
        List<Product> list = new ArrayList<Product>();
        for (int i = 0; i < productList.size(); i++) {
            Product prod = productList.get(i);
            if (prod.getWeight() >= min && prod.getWeight() <= max) {
                list.add(prod);
            }
        }
        return list;
    }
}
