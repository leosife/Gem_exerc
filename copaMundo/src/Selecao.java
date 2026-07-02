import java.util.ArrayList;
import java.util.List;

public class Selecao implements Comparable<Selecao> {
    String pais;
    GrupoFifa grupo;
    List<Jogador> elenco;
    int pontos;
    int saldoGols;


    public Selecao(String pais, GrupoFifa grupo){
        this.pais = pais;
        this.grupo = grupo;
        pontos = 0;
        saldoGols = 0;
        elenco = new ArrayList<Jogador>();
    }

    public void convocar(Jogador j) {
        elenco.add(j);
    }

    public void convocarAle(Selecao Sele) {
        Convocar Ale = new Convocar();
        Ale.convocarAleatorio(Sele);
    }


    @Override
    public int compareTo(Selecao outra) {
        // compara pontos
        int comparacaoPontos = Integer.compare(outra.pontos, this.pontos);

        if(comparacaoPontos != 0){
            return comparacaoPontos;
        }

        return Integer.compare(outra.saldoGols, this.saldoGols);
    }
}
