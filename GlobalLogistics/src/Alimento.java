public class Alimento extends Produto{
    String dataValidade;
    public Alimento(String nome, double preco, double peso) {
        super(nome, preco, peso);
    }

    @Override
    public double calcularPrecoFinal() {
        return 0;
    }
}
