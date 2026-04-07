public class Partida {
    Time equipe1;
    Time equipe2;
    public Partida(Time equipe1, Time equipe2){
        this.equipe1 = equipe1;
        this.equipe2 = equipe2;

    }

    public void simular(){
        double dif = equipe1.calcForca() / equipe2.calcForca();
        if (dif > 1.12){
            System.out.println(equipe1.nome +" vence a partida");
        } else if (dif < 0.9) {
            System.out.println(equipe2.nome +" vence a partida");
        } else {
            System.out.println("EMPATE");
        }
    }
}
