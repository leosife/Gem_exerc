public class Treinador extends Membro{
    public Treinador(String nome, String nick, double salarioBase){
        super(nome,nick, salarioBase);
    }

    @Override
    public double calcularSalarioFinal(double estrategias) {
        double salarioFinal = salarioBase + (200*estrategias);
        return  salarioFinal;
    }


}
