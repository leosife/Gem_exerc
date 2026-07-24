import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class ControleAcampamento {
    Map<String, Sobrevivente> bancoDados = new HashMap<>();
    Random rd = new Random();


    public void registrarSobrevivente(String cpf, Sobrevivente s) {

        if (s.isInfectado()) {
            throw new InfeccaoDetectadaException("ALERTA - Sobrevivente infectado!! -- " + s.getNome());
        } else {
            bancoDados.put(cpf, s);
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


}
