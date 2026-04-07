public class Treinador extends Pessoa{
    String esquema;
    private double exp;
    public Treinador(String nome, int idade, String esquema, double exp) {
        super(nome, idade);
        this.esquema = esquema;
        this.exp = exp;
    }

    public double getExp() {
        return exp;
    }
}
