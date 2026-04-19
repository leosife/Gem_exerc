public abstract class Produto {
    private String nome;
    private double precoBase;
    private double peso;
        public Produto(String nome, double preco, double peso){
            this.nome = nome;
            this.precoBase = preco;
            this.peso = peso;
        }

    public String getNome() {
        return nome;
    }

    public double getPrecoBase(){
            return precoBase;
    }

    public  double getPeso(){
            return peso;
    }

    public void setPrecoBase(double valor){
            this.precoBase = valor;
    }

    public void setPeso(double valor){
            this.peso = valor;
    }

    public abstract double calcularPrecoFinal();
}
