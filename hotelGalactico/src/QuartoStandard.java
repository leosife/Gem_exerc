public class QuartoStandard extends Acomodacao{
    public QuartoStandard(int numero, double valorBase) {
        super(numero, valorBase);
    }

    @Override
    public double calcularPrecoFinal() {
        return getValorBase();
    }
}
