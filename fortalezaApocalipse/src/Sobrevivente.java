public class Sobrevivente {
    private String nome;
    private boolean infectado;
    private double qtdRacoes; // Quantidade de suprimentos que ele trouxe

    public Sobrevivente(String nome, boolean infectado, double qtdRacoes) {
        this.nome = nome;
        this.infectado = infectado;
        this.qtdRacoes = qtdRacoes;
    }

    public String getNome() { return nome; }
    public boolean isInfectado() { return infectado; }
    public double getQtdRacoes() { return qtdRacoes; }

    public void setInfectado(boolean infectado) {
        this.infectado = infectado;
    }
}