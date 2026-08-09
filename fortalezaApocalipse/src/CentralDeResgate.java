import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

public class CentralDeResgate {

    // 1. Método que apenas busca e DEVOLVE os dados (Sem variável global)
    public List<String> carregarDados() {
        Path caminho = Path.of("dados", "lista_entradas.txt");

        try {
            return Files.readAllLines(caminho);
        } catch (IOException e) {
            System.out.println("Arquivo não encontrado. Iniciando com lista vazia.");
            return List.of(); // Blindagem! Se der erro, retorna uma lista vazia inofensiva.
        }
    }

    // 2. Método limpo que usa as Streams
    public long contarRegistros() {
        return carregarDados().stream().count();
    }

    // 3. O Investigador
    public Optional<String> buscarBatedorSeguro(String nomeProcurado) {
        return carregarDados().stream()
                .filter(linha -> linha.contains(nomeProcurado)) // Mudado para 'linha'
                .findFirst();
    }

    // 4. O General
    public void acionarResgate(String nome) {
        Optional<String> caixaDoInvestigador = buscarBatedorSeguro(nome);

        String batedorEncontrado = caixaDoInvestigador.orElseThrow(() ->
                new SobreviventeNaoEncontradoException("Alerta: Batedor " + nome + " não encontrado")
        );

        // Ação finalizada com sucesso!
        System.out.println("🚨 Resgate acionado para: " + batedorEncontrado);
    }
}