public class Goleiro extends Jogador{
    private int reflexo;
    public Goleiro(String nome, int numeroCamisa, int qualidade, int reflexo){
        super(nome, numeroCamisa, qualidade);
        this.reflexo = reflexo;


    }

    public int getReflexo() {
        return reflexo;
    }

    public void setReflexo(int reflexo) {
        this.reflexo = reflexo;
    }

    @Override
    public double calcularDesempenhoMatch() {


        return (getQualidade() + reflexo) /2.0;
    }
}
