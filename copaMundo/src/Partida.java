import java.util.Random;

public class Partida {
    Selecao timeCasa;
    Selecao timeVisitante;
    double forcaCasa;
    double forcaVisitante;
    int golsVenc;
    int golsPerd;
    int saldoGols;
    Random rd = new Random();

    public Partida(Selecao timeCasa, Selecao timeVisitante) {
        this.timeCasa = timeCasa;
        this.timeVisitante = timeVisitante;
    }


    public void validarElenco(Selecao equipe) {
        boolean temGoleiro = false;
        if (equipe.elenco.size() < 11) {
            throw new ElencoInvalidoException("A equipe " + equipe.pais + " tem menos de 11 jogadores");
        }
        for (Jogador jogadorAtual : equipe.elenco) {
            if (jogadorAtual instanceof Goleiro) {
                temGoleiro = true;

            }
        }
        if (!temGoleiro) {
            throw new ElencoInvalidoException("A equipe " + equipe.pais + " precisa ter pelo menos um goleiro no time");
        }


    }

    public void jogar() {
        validarElenco(timeCasa);
        validarElenco(timeVisitante);


        for (Jogador player : timeCasa.elenco) {
            forcaCasa += player.calcularDesempenhoMatch();
        }

        for (Jogador player : timeVisitante.elenco) {
            forcaVisitante += player.calcularDesempenhoMatch();
        }



        if ((forcaCasa - forcaVisitante) >= -3 && (forcaCasa - forcaVisitante) <= 3) {
            System.out.println("Empate!!");
            calcularSaldo(0);
            System.out.println(timeCasa.pais+" "+ golsPerd + " x " + golsVenc + " " + timeVisitante.pais);
            timeCasa.pontos += 1;
            timeVisitante.pontos +=1;
            timeCasa.saldoGols += saldoGols;
            timeVisitante.saldoGols += saldoGols;

        } else if (forcaCasa > forcaVisitante) {
            System.out.println("A equipe " + timeCasa.pais + " vence !!!");
            timeCasa.pontos += 3;
            double result = forcaCasa - forcaVisitante;
            calcularSaldo(result);
            System.out.println(timeCasa.pais+" "+ golsVenc + " x " + golsPerd + " " + timeVisitante.pais);
            timeCasa.saldoGols += saldoGols;
            timeVisitante.saldoGols -= saldoGols;


        } else if (forcaCasa < forcaVisitante) {
            System.out.println("A equipe " + timeVisitante.pais + " vence !!!");
            timeVisitante.pontos += 3;
            double result = forcaVisitante - forcaCasa;
            calcularSaldo(result);
            System.out.println(timeCasa.pais+" "+ golsPerd + " x " + golsVenc + " " + timeVisitante.pais);
            timeVisitante.saldoGols += saldoGols;
            timeCasa.saldoGols -= saldoGols;

        }
        System.out.println("Força Casa: " + forcaCasa);
        System.out.println("Força Visitante: " + forcaVisitante);
    }

    public void calcularSaldo(double result) {
        golsPerd = rd.nextInt(0, 2);
        if (result >= -3 && result <= 3) {
            saldoGols = 0;


        } else if (result > 10) {
            saldoGols = 4;
        } else if (result > 8) {
            saldoGols = 3;
        } else if (result > 6) {
            saldoGols = 2;
        } else if (result > 3) {
            saldoGols = 1;
        }
        golsVenc = golsPerd + saldoGols;

    }
}
