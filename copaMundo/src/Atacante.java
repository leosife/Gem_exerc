import java.util.Random;

public class Atacante extends Jogador {



    public Atacante(String nome, int numeroCamisa, int qualidade){
        super(nome, numeroCamisa, qualidade);
    }


    @Override
    public double calcularDesempenhoMatch() {
        Random random = new Random();
        int faroGol = random.nextInt(11);
        return getQualidade() + faroGol;
    }
}
