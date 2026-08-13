import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        CentroDeComando cc = new CentroDeComando();
        List<Missao> listaMissoes = cc.carregarMissoes("dados/missoes.csv");

        String cod = "M003";
        Optional<Missao> caixa = cc.buscarMissaoPorCodigo(listaMissoes, cod );
        try {
            Missao mBuscada = caixa.orElseThrow(() -> new MissaoNaoEncontradaException("Nenhuma missão encontrada"));

            System.out.println("Codigo "+ cod + " Encontrada\n" +
                    "Missão "+mBuscada.nome()+ " para "+ mBuscada.destino());
        } catch (MissaoNaoEncontradaException e){
            System.out.println("Alerta!: " + e.getMessage());
        }

        System.out.println(cc.listNomesPorDestino(listaMissoes,"Marte"));

        System.out.println(cc.calcularCustoTotalDeMissoes(listaMissoes,StatusMissao.PLANEJADA));

    }
}