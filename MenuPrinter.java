import java.util.Scanner;

/**
 * Trieda je používaná na výpis o možnostiach programu
 */
abstract public class MenuPrinter {

    /**
     * Funkcia na úvodný výpis pri štarte programu
     */
    public static void printWelcome() {
        System.out.println("Vitajte v logistickom systeme ");
    }

    /**
     * Funkcia slúži na výpis možností ktoré program používa
     */
    public static void printMenu() {
        System.out.println("*****************************************************");
        System.out.println("********************  MENU  *************************");
        System.out.println("*****************************************************");
        System.out.println("**   nacitaj   ... nacitanie udajov zo suboru      **");
        System.out.println("**   zapis     ... zapisanie udajov do suboru      **");
        System.out.println("**   predaj    ... predaj produktu                 **");
        System.out.println("**   objednaj  ... objednaj produkt do obchodu     **");
        System.out.println("**   vyrob     ... daj vyrobit produkt v tovarni   **");
        System.out.println("**   naskladni ... prenes produkt do skladu        **");
        System.out.println("**   vypis     ... vypisy pre jednotlive budovy    **");
        System.out.println("**   filtruj   ... filtrovanie dat podla kriterii  **");
        System.out.println("**   hladaj    ... vyhladaj produkt podla kriterii **");
        System.out.println("**   koniec    ... ukonci program                  **");
        System.out.println("*****************************************************");
        System.out.println("*****************************************************");
        System.out.print("Zvol akciu: ");

    }
}
