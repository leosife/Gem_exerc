import java.time.LocalDate;

public record Missao(String codigo, String nome, String destino, LocalDate dataLancamento, StatusMissao status, double custoBilhoes) {
}
