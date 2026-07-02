import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Selecao brasil = new Selecao("Brasil", GrupoFifa.GRUPO_A);
        brasil.convocarAle(brasil);

        Selecao argentina = new Selecao("Argentina", GrupoFifa.GRUPO_A);
        argentina.convocarAle(argentina);

        Selecao alemanha = new Selecao("Alemanha", GrupoFifa.GRUPO_A);
        alemanha.convocarAle(alemanha);

        Selecao espanha = new Selecao("Espanha", GrupoFifa.GRUPO_A);
        espanha.convocarAle(espanha);

        List<Selecao> grupoA = new ArrayList<>();
        grupoA.add(brasil);
        grupoA.add(argentina);
        grupoA.add(alemanha);
        grupoA.add(espanha);

        List<Selecao> timesRodada = new ArrayList<>(grupoA);

        for (int rodada = 0; rodada < 3; rodada++) {
            System.out.println("\n------- RODADA " + (rodada + 1) + " -------");


            for (int i = 0; i < 2; i++) {
                Selecao casa = timesRodada.get(i);
                Selecao visitante = timesRodada.get(timesRodada.size() - 1 - i);
                Partida jogoUm = new Partida(casa, visitante);
                jogoUm.jogar();
                System.out.println("------------------------");

            }
            // 🔄 A MÁGICA DA ROTAÇÃO (O Método do Círculo)
            // Pegamos o último time da lista...
            Selecao ultimoTime = timesRodada.remove(timesRodada.size() - 1);
            // ...e colocamos ele na posição 1 (logo após o primeiro time, que fica fixo na posição 0)
            timesRodada.add(1, ultimoTime);

            Collections.sort(grupoA);


            System.out.println("\n🏆 --- CLASSIFICAÇÃO FINAL DO GRUPO --- 🏆");
            int posicao = 1;
            for (Selecao time : grupoA) {
                System.out.println(posicao + "º Lugar | " + time.pais + " | Pontos: " + time.pontos + " | Saldo de Gols: " + time.saldoGols);
                posicao++;
        }


        }

    }

}