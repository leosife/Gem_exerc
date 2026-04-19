public class Vestuario extends Produto{
    String tamanho;
    public Vestuario(String nome, double preco, double peso) {
        super(nome, preco, peso);
    }

    @Override
    public double calcularPrecoFinal() {
        return 0;
    }
}
