import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class ControleAcampamento {
    Map<String, Sobrevivente> bancoDados = new HashMap<>();
    Random rd = new Random();


    public void registrarSobrevivente(String cpf, Sobrevivente s) {

        if (s.isInfectado()) {
            throw new InfeccaoDetectadaException("ALERTA - Sobrevivente infectado!! -- " + s.getNome());
        } else {
            bancoDados.put(cpf, s);
            gerarLogEntrada(s);
            System.out.println("Sobrevivente registrado com sucesso");
        }

    }

    public void verificarStatus(String cpf) {

        Sobrevivente buscado = bancoDados.get(cpf);
        if (buscado == null) {
            throw new SobreviventeNaoEncontradoException("Alerta! - Sobrevivente não cadastrado");
        } else {
            System.out.println("Nome: " + buscado.getNome());
            System.out.println("Quantidade de ração: " + buscado.getQtdRacoes());

        }


    }

    public double somarRacoesTotais() {
        double total = bancoDados.values().stream()
                .filter(sobrevivente -> !sobrevivente.isInfectado())
                .map(c -> c.getQtdRacoes())
                .reduce(0.0, Double::sum);
        //ou tabm pode ser escrito .reduce(0.0,(acumulador,qtdAtual)-> acumulador+qtdAtual);

        return total;
    }

    public List<String> obterNomesDosSaudaveis() {
        return bancoDados.values().stream()
                .filter(s -> !s.isInfectado())
                .map(s -> s.getNome())
                .map(s -> s.toUpperCase())
                .toList();
    }

    public boolean testeInfeccao(Sobrevivente ze) {
        if (ze.isInfectado()) return true;

        if (rd.nextInt(1, 11) > 7) {
            ze.setInfectado(true);
            return true;
        }
        return false;
    }

    public void gerarLogEntrada(Sobrevivente s){
        Path caminho = Path.of("dados","lista_entradas.txt");
        String linha = "NOVO MEMBRO: "+s.getNome()+" | Racoes: "+s.getQtdRacoes()+ " \n";
        try {
            Files.writeString(caminho, linha, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void imprimirHistoricoEntradas(){
        Path caminho = Path.of("dados","lista_entradas.txt");

        try {
            List<String> historico = Files.readAllLines(caminho);

            for (String linha: historico){
                System.out.println(linha);
            }

        } catch (IOException e) {
            System.out.println("Arquivo não encontrado");
        }
    }


}
