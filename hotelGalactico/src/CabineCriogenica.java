public class CabineCriogenica extends Acomodacao{
    public CabineCriogenica(int numero, double valorBase) {
        super(numero, valorBase);
    }

    @Override
    public double calcularPrecoFinal() {
        return getValorBase()*0.9;
    }
}
