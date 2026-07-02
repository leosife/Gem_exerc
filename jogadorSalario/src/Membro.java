public class Membro {
    String nome;
    String nick;
    double salarioBase;
    public Membro(String nome, String nick, Double salarioBase) {
        this.nome = nome;
        this.nick = nick;
        this.salarioBase = salarioBase;

    }

    public double calcularSalarioFinal(double x){
        return this.salarioBase;
    }

}
