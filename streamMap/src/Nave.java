public class Nave {
    private String piloto;
    private String classificacao; // Ex: "Combate", "Cargueiro", "Transporte"

    public Nave(String piloto, String classificacao) {
        this.piloto = piloto;
        this.classificacao = classificacao;
    }

    public String getPiloto() { return piloto; }
    public String getClassificacao() { return classificacao; }
}