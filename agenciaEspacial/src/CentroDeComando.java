import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CentroDeComando {


    public List<Missao> carregarMissoes(String caminhoArquivo){
        List<String> lista;
        Path caminho = Path.of(caminhoArquivo);

        try {
            lista = Files.readAllLines(caminho);
        } catch (IOException e) {
            System.out.println("Arquivo não encontrado. Iniciando com lista vazia.");
            lista = List.of();
        }

        List<Missao> missoes = new ArrayList<>();
        for (int i = 1; i < lista.size() ; i++) {
            String[] colunas = lista.get(i).split(",");
            Missao m1 = new Missao(colunas[0],colunas[1],colunas[2], LocalDate.parse(colunas[3]),StatusMissao.valueOf(colunas[4]),Double.parseDouble(colunas[5]));
            missoes.add(m1);
        }

        return missoes;

    }


    public Optional<Missao> buscarMissaoPorCodigo(List<Missao> missoes, String codigo){
        return missoes.stream()
                .filter(missao -> missao.codigo().equalsIgnoreCase(codigo))
                .findFirst();
    }

    public List<String>listNomesPorDestino(List<Missao> missoes, String destino){
        return missoes.stream()
                .filter(missao -> missao.destino().equalsIgnoreCase(destino))
                .map(Missao::nome)
                .toList();
    }

    public double calcularCustoTotalDeMissoes(List<Missao> missoes, StatusMissao statusBuscado){
        return missoes.stream()
                .filter(missao -> missao.status() == statusBuscado)
                .mapToDouble(Missao::custoBilhoes).sum();
    }
}
