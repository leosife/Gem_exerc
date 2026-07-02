public class Defensor extends Jogador{

    public Defensor(String nome, int numeroCamisa, int qualidade){
        super(nome, numeroCamisa, qualidade);



    }

    @Override
    public double calcularDesempenhoMatch() {
        return getQualidade();
    }
}
