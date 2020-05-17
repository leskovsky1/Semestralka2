public class main {

    /**
     * main funkcia
     *
     * @param args používa sa bez vstupných parametrov
     */
    public static void main(String[] args) {
        MenuExec exec = new MenuExec();
        MenuPrinter.printWelcome();
        exec.start();
    }
}
