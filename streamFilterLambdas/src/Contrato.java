import java.util.List;

public class Contrato {
    private String nomeAlvo;
    private double valorRecompensa;
    private boolean capturado = false;

    public Contrato(String nomeAlvo, double valorRecompensa){
        this.nomeAlvo = nomeAlvo;
        this.valorRecompensa = valorRecompensa;


    }

    public void setValorRecompensa(double newValor){
        this.valorRecompensa = newValor;
    }

    public double getValorRecompensa() {
        return valorRecompensa;
    }

    public String getNomeAlvo() {
        return nomeAlvo;
    }

    public void setNomeAlvo(String nomeAlvo) {
        this.nomeAlvo = nomeAlvo;
    }

    public boolean isCapturado() {
        return capturado;
    }

    public void setCapturado(boolean capturado) {
        this.capturado = capturado;
    }

    public List<Contrato> obterContratosValiososAtivos(List<Contrato> contratos){
        return
                contratos.stream()
                .filter(c -> c.isCapturado() == false)
                .filter(c -> c.getValorRecompensa() >= 50000)
                .toList();


    }

    public double calcularTotalPago(List<Contrato> contratos){
        double soma = contratos.stream()
                .filter(Contrato::isCapturado)
                .map(c -> c.getValorRecompensa())
                .reduce(0.0,(acumulador, numeroAtual) -> acumulador + numeroAtual);

        return soma;
    }
}
