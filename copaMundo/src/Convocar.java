import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Convocar {
    ListaNomes fabricaDeCraques = new ListaNomes();

        public void convocarAleatorio(Selecao selecao){
            for (int i = 0; i < 3; i++) {

                Jogador peDeRato = new Atacante(fabricaDeCraques.pegarJogadorAleatorio(),i+9,10);
                Jogador peDeRato1 = new Defensor(fabricaDeCraques.pegarJogadorAleatorio(),i+2,10);
                Jogador peDeRato2 = new MeioCampo(fabricaDeCraques.pegarJogadorAleatorio(),i+5,10);
                selecao.convocar(peDeRato);
                selecao.convocar(peDeRato1);
                selecao.convocar(peDeRato2);

            }

            Jogador peDeRato = new MeioCampo(fabricaDeCraques.pegarJogadorAleatorio(),8,10);
            Jogador peDeRato1 = new Goleiro(fabricaDeCraques.pegarJogadorAleatorio(),1,10,20);
            selecao.convocar(peDeRato);
            selecao.convocar(peDeRato1);
        }



}
