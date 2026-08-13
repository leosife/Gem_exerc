import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProcessadorEstoque {

    public List<Produto> carregarProdutos(String caminhoDoArquivo) {
        List<String> lista;
        Path caminho = Path.of(caminhoDoArquivo);
        try {
            lista = Files.readAllLines(caminho);
        } catch (IOException e) {
            System.out.println("Arquivo não encontrado. Iniciando com lista vazia.");
            lista = List.of(); // Blindagem! Se der erro, retorna uma lista vazia inofensiva.
        }

        List<Produto> produtos = new ArrayList<>();
        for (int i = 1; i < lista.size(); i++) {
            String[] colunas = lista.get(i).split(",");
            Produto product = new Produto(Integer.parseInt(colunas[0]), colunas[1], Categoria.valueOf(colunas[2].toUpperCase()), Double.parseDouble(colunas[3]), Boolean.parseBoolean(colunas[4]));

            produtos.add(product);
        }


        return produtos;
    }

    public Optional<String> buscarProdutoCampanha(List<Produto> produts) {
        return produts.stream()
                .filter(produto -> produto.categoria() == Categoria.ELETRONICOS)
                .filter(produto -> produto.emEstoque())
                .filter(produto -> produto.preco() < 2000)
                .map(Produto::nome)
                .findFirst();

    }
}
