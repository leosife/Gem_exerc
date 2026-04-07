import java.util.ArrayList;

public class Time {
    String nome;
    Treinador manager;
    ArrayList<Jogador> equipe = new ArrayList<>();

    public Time(String nome, Treinador manager) {
        this.nome = nome;
        this.manager = manager;
    }

    public void contratarJogador(Jogador jog) {
        equipe.add(jog);
    }

    public double calcForca() {
        double soma = 0, media;
        int pontoshab;
        for (int i = 0; i < equipe.size(); i++) {
            pontoshab = equipe.get(i).getHabilidade();
            soma += pontoshab;
        }
        media = soma / equipe.size();


        return media + manager.getExp();
    }
}

