import java.util.List;

public class Main {

    public static void main(String[] args) {
        // 1. Criando a nossa frota de teste
        List<Nave> frota = List.of(
                new Nave("Luke", "Combate"),
                new Nave("Han Solo", "Cargueiro"),
                new Nave("Wedge", "Combate")
        );

        // 2. Chamando o método que você vai criar
        List<String> relatorio = extrairPilotosDeCombate(frota);

        // 3. Imprimindo o resultado
        System.out.println(relatorio);
        // O esperado impresso na tela é: [LUKE, WEDGE]

    }

    // AQUI É ONDE VOCÊ VAI TRABALHAR 👇
    public static List<String> extrairPilotosDeCombate(List<Nave> frota) {

        // Crie o seu return usando frota.stream()...
        return frota.stream()
                .filter(a -> a.getClassificacao().equals("Combate"))
                .map(Nave::getPiloto)// ou nave -> nave.getPiloto()
                .map(b -> b.toUpperCase())
                .toList();


        // Sabe quando a nossa Lambda não faz nenhum cálculo complexo, ela apenas "chama um método" que já existe? Como em b -> b.toUpperCase()?
        //O Java nos permite encurtar isso usando os dois pontos duplos :: (chamado de Method Reference). É como dizer: "Java, apenas aplique esse método no que estiver passando aí"


    }


}