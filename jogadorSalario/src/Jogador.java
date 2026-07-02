public class Jogador extends Membro{
    public Jogador(String nome, String nick, double salarioBase) {
        super(nome, nick, salarioBase);
    }

    @Override
    public double calcularSalarioFinal(double pontos) {
        double salarioFinal = salarioBase + pontos;
        return  salarioFinal;
    }
}
