import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String nome = "";
        String posicao = "";
        String nick = "";
        String rating = "";
        int pontos = 0;
        ArrayList<Jogador> lista = new ArrayList<>();
        Scanner sc = new Scanner(System.in);v


        for (int i = 0; i < 3; i++) {
            sc = new Scanner(System.in);
            System.out.println("Nome:");
            nome = sc.nextLine();
            System.out.println("Nick:");
            nick = sc.nextLine();
            System.out.println("Posição:");
            posicao = sc.nextLine();
            ;
            System.out.println("Pontuação: ");
            pontos = sc.nextInt();
            sc.nextLine();
            Jogador jog = new Jogador(nome, nick, posicao, pontos);
            lista.add(jog);

        }

        for (int i = 0; i < lista.size(); i++) {
            Jogador jog = lista.get(i);
            System.out.println("O jogador " + jog.getNick() + " (" + jog.getNome() + ") é nível " + jog.calcularRating() + " e joga na posição " + jog.getPosicao()+ ".");

        }


        sc.close();

    }
}