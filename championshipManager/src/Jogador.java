public class Jogador extends Pessoa {
    String posicao;
    private int habilidade;

    public Jogador(String nome, int idade, String posicao, int habilidade) {
        super(nome, idade);
        this.posicao = posicao;
        this.habilidade = habilidade;
    }

    public int setHabilidade(int hab){
        habilidade = hab;
        return hab;
    }

    public int getHabilidade() {
        return habilidade;
    }
}
