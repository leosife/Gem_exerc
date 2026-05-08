import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.format.DateTimeFormatter;


public class Alimento extends Produto{
    private String dataValidade;
    private int diasVencer;
    private DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public Alimento(String nome, double preco, double peso, String dataValidade ) {
        super(nome, preco, peso);
        this.dataValidade = dataValidade;
        LocalDate dataVencimento = LocalDate.parse(dataValidade, formato);
        LocalDate hoje = LocalDate.now();
        diasVencer = (int) ChronoUnit.DAYS.between(hoje,dataVencimento);
    }

    public int getDiasVencer() {
        return diasVencer;
    }

    @Override
    public double calcularPrecoFinal() {
        if (diasVencer<=5){
            return getPrecoBase()*0.8;
        }
        return getPrecoBase();
    }
}
