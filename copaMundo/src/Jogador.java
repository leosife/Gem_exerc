public abstract class Jogador {
    private String nome;
    private int numeroCamisa;
    private int qualidade;
    public Jogador(String nome, int numeroCamisa, int qualidade){
        this.nome = nome;
        this.numeroCamisa = numeroCamisa;
        setQualidade(qualidade);
    }


    public int getNumeroCamisa(){
        return numeroCamisa;
    }
    public int getQualidade(){
        return qualidade;
    }
    public String getNome(){
        return nome;
    }

    public void setNumeroCamisa(int numeroCamisa) {
        this.numeroCamisa = numeroCamisa;
    }

    public void setQualidade(int quali){
        if (quali < 0) {
            this.qualidade = 0;
        } else if (quali > 100) {
            this.qualidade = 100;
        } else {
            this.qualidade = quali;
        }
    }

    public abstract double calcularDesempenhoMatch();

}
