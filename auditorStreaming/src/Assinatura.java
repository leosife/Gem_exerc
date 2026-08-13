import java.time.LocalDate;

public record Assinatura(int id, String email, Plano plano, LocalDate vencimento) {
}
