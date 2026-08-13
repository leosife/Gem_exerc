import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AuditoriaStreaming {


    public List<Assinatura> carregarAssinaturas(String caminho) {
        List<String> lista;

        Path assinaturasCaminho = Path.of(caminho);

        try {
            lista = Files.readAllLines(assinaturasCaminho);
        } catch (IOException e) {
            lista = List.of();
        }

        List<Assinatura> assinaturas = new ArrayList<>();
        for (int i = 1; i < lista.size(); i++) {
            String[] colunas = lista.get(i).split(",");
            Assinatura cliente = new Assinatura(Integer.parseInt(colunas[0]), colunas[1], Plano.valueOf(colunas[2]), LocalDate.parse(colunas[3]));
            assinaturas.add(cliente);
        }


        return assinaturas;
    }

    public long contarAssinaturasExpiradas(List<Assinatura> assinaturas){
        LocalDate hoje = LocalDate.now();
        return assinaturas.stream()
                .filter(conta -> conta.vencimento().isBefore(hoje))
                .count();


    }

    public Optional<String> buscarPlanoPorEmail(List<Assinatura> assinaturas, String email){
        return assinaturas.stream()
                .filter(cliente -> cliente.email().equalsIgnoreCase(email))
                .map(cliente -> String.valueOf(cliente.plano()))
                .findFirst();
    }
}
