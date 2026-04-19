public class Eletronico extends Produto {

    public Eletronico(String nome, double preco, double peso) {
        super(nome, preco, peso);
    }

    @Override
    public double calcularPrecoFinal() {
        return getPrecoBase()*1.15;
    }
}
