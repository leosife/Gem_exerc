public class Jogador {
    private String nome;
    private String nick;
    private String posicao;
    private int pontos;

    public Jogador(String nome, String nick, String posicao, int pontos) {
        this.nick = nick;
        this.nome = nome;
        this.posicao = posicao;
        this.pontos = pontos;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        if (pontos > 0) {
            this.pontos = pontos;
        }
    }

    public String getNick() {
        return nick;
    }

    public String getNome() {
        return nome;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public String calcularRating() {
        if (pontos>1000){
            return  "Elite";
        } else if (pontos> 500) {
            return  "Pro";
        }
        return  "Amador";

    }
}
