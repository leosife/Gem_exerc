import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double valor = 0;
        boolean valido = false;

        Hotel top = new Hotel("TOP");

        while (!valido) {
            try {
                System.out.println("Qual o valor base dos quartos?: ");
                valor = sc.nextDouble();

                valido = true;
            } catch (InputMismatchException e) {
                System.out.println("Digite um valor valido");
                sc.nextLine();
            }
        }

        for (int i = 1; i < 6; i++) {
            QuartoStandard x = new QuartoStandard(i, valor);
            SuiteLuxo y = new SuiteLuxo(i + 10, valor, 5);
            CabineCriogenica z = new CabineCriogenica(i + 15, valor);
            top.addRooms(x);
            top.addRooms(y);
            top.addRooms(z);
        }

        try {
            top.checkIn(7);
            top.checkIn(1);
            top.checkIn(7);
            top.checkIn(1);
            top.checkIn(7);



        } catch (QuartoOcupadoException e){
            System.out.println(e);
        }




        sc.close();
    }
}