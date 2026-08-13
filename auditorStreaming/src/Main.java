import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {


        AuditoriaStreaming ads = new AuditoriaStreaming();
        String caminho = "dados/assinaturas.csv";
        List<Assinatura> clientes = ads.carregarAssinaturas(caminho);

        long contasExpiradas = ads.contarAssinaturasExpiradas(clientes);
        System.out.println("No momente existe "+ contasExpiradas +" assinaturas expiradas");

        try {
            String emailBuscado = "hacker@email.com";
            Optional<String> caixaDoPlano = ads.buscarPlanoPorEmail(clientes, emailBuscado);

            String planoEncontrado = caixaDoPlano.orElseThrow(
                    () -> new RuntimeException("Erro: Assistente não encontrado no branco de dados")
            );

            System.out.println("O pano do email "+ emailBuscado + " é "+ planoEncontrado);





        } catch (RuntimeException e) {
            System.out.println("ALERTA: " +e.getMessage());
        }
    }
}