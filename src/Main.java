/**
 * Método main
 */

public class Main {
    public static void main(String[] args) {

        ViewCal Vcalculator = new ViewCal();
        ModelCal Mcalculator = new ModelCal();
        ControllerCal Ccalculator = new ControllerCal(Vcalculator, Mcalculator);

    }
}