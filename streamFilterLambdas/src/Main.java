import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Contrato c1 = new Contrato("Boba",5000);
        Contrato c2 = new Contrato("Greedo",1000);
        Contrato c3 = new Contrato("Chewie",10000);

        List<Contrato> procurados = new ArrayList<>();
        procurados.add(c1);
        procurados.add(c2);
        procurados.add(c3);

        c3.setCapturado(true);

        double valorPagar = c1.calcularTotalPago(procurados);
        System.out.println("Total a ser pago :"+ valorPagar);
    }
}