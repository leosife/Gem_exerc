public abstract class  Acomodacao {
    private int numero;
    private double valorBase;
    private boolean ocupada = false;

    public Acomodacao(int numero, double valorBase){
        this.numero = numero;
        this.valorBase = valorBase;
    }

    public double getValorBase() {
        return valorBase;
    }

    public void setValorBase(double valorBase) {
        this.valorBase = valorBase;
    }


    public int getNumero() {
        return numero;
    }

    public void setOcupada(boolean ocp){
        this.ocupada = ocp;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public abstract double calcularPrecoFinal();
}
