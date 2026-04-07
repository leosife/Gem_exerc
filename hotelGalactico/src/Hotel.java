import java.util.ArrayList;

public class Hotel {
    String nome;
    ArrayList<Acomodacao> quartos = new ArrayList<>();

    public Hotel(String nome) {
        this.nome = nome;
    }

    public void addRooms(Acomodacao x) {
        quartos.add(x);
    }

    public void checkIn(int numeroQuarto) {
        boolean encontrado = false;
        for (Acomodacao quartox : quartos) {
            if (quartox.getNumero() == numeroQuarto) {
                System.out.println("Quarto encontrado!");
                encontrado = true;
                if (quartox.isOcupada()) {
                    throw new QuartoOcupadoException("Quarto esta ocupado");
                } else {
                    System.out.println("Checkin foi um sucesso");
                    quartox.setOcupada(true);

                }
            }
        }

        if (!encontrado){
            System.out.println("O quarto indicado não existe");
        }

    }
}
