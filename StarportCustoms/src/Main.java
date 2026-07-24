import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ControleAlfandega alfandega = new ControleAlfandega();

        Viajante jana = new Viajante("Jana", "Terra");
        Viajante nyvi = new Viajante("Nyvi", "Venus");
        Viajante july = new Viajante("July", "Pops");
        jana.setProcurado(true);

        alfandega.registrarViajante("123.123", july);
        alfandega.registrarViajante("754.123", jana);
        alfandega.registrarViajante("122.222", nyvi);

        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o passaporte para verificação: ");
        String passaporte = sc.nextLine();

        try {
            alfandega.verificarPassaporte(passaporte);

        } catch (PassporteFalsoException | AlertaPrisaoException e) {
            System.out.println(e.getMessage());
        }


        sc.close();
    }
}