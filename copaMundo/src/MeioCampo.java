public class MeioCampo extends Jogador{

    public MeioCampo(String nome, int numeroCamisa, int qualidade){
        super(nome, numeroCamisa, qualidade);



    }

    @Override
    public double calcularDesempenhoMatch() {
        return getQualidade();
    }
}
