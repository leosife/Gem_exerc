import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {


        ProcessadorEstoque xx = new ProcessadorEstoque();
        String caminhoArquivo = "dados/estoque.csv";
        System.out.println("Carregando arquivo: " + caminhoArquivo + "...");

        List<Produto> minhaLista = xx.carregarProdutos(caminhoArquivo);

        Optional<String> caixaDoProduto = xx.buscarProdutoCampanha(minhaLista);

        try {
            // Se tiver produto, extrai. Se estiver vazio, joga a Exceção na mesma hora!
            String vencedor = caixaDoProduto.orElseThrow(() ->
                    new RuntimeException("Nenhum produto atende aos rígidos critérios da promoção!")
            );

            // Se passou da linha de cima, temos um vencedor.
            System.out.println("🎉 Produto selecionado para a capa da Amazon: " + vencedor);

        } catch (RuntimeException e) {
            // Se o orElseThrow estourou o erro, nós o capturamos aqui para avisar a equipe
            System.out.println("🚨 ALERTA DO MARKETING: " + e.getMessage());
        }

    }
}