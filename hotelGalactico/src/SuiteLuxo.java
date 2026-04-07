public class SuiteLuxo extends Acomodacao implements ServicioQuarto, AlimentacaoEspecial{
    double capacidadeHidro;

    public SuiteLuxo(int numero, double valorBase, double capacidadeHidro) {
        super(numero, valorBase);
        this.capacidadeHidro = capacidadeHidro;
    }

    @Override
    public double calcularPrecoFinal() {
        return getValorBase()*1.2;
    }

    @Override
    public void servirRefeicaoIntergalactica() {

    }

    @Override
    public void solicitarLimpeza() {

    }
}
