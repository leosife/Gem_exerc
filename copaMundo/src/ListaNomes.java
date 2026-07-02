import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ListaNomes {

    // Atributo que vai guardar a lista de 500 nomes
    private List<String> jogadores;

    // Construtor: sempre que você criar um "Gerador", ele já gera os 500 nomes automaticamente
    public ListaNomes() {
        this.jogadores = new ArrayList<>();
        gerarListaOculta();
    }

    // Método privado que faz a mágica de combinar os nomes
    private void gerarListaOculta() {
        List<String> primeirosNomes = Arrays.asList(
                "Kleber", "Ronaldo", "Valdívia", "Edilson", "Fabrício", "Thiago", "Leandro", "Renan",
                "Wellington", "Maicon", "Jandrei", "Murilo", "Diego", "Alexandre", "Everton", "Marcelo",
                "Reinaldo", "Maycon", "Douglas", "Rony", "Wanderson", "Vagner", "Marcos", "Lucas",
                "Gabriel", "Rodrigo", "Bruno", "Rafael", "Felipe", "Gustavo", "André", "Ricardo"
        );

        List<String> sobrenomesEApelidos = Arrays.asList(
                "Silva", "Souza", "Ribeiro", "Santos", "Oliveira", "Junior", "Menezes", "Batista",
                "Cardoso", "Costa", "Chaves", "Pinto", "Gaucho", "Carioca", "Nunes", "Vieira",
                "Barbosa", "Teixeira", "Almeida", "Rocha", "Cavalcante", "Neto", "Melo", "Assis"
        );

        int contador = 0;
        for (String nome : primeirosNomes) {
            for (String sobrenome : sobrenomesEApelidos) {
                if (contador < 500) {
                    jogadores.add(nome + " " + sobrenome);
                    contador++;
                }
            }
        }
    }

    // Método público para pegar um nome aleatório de fora desta classe
    public String pegarJogadorAleatorio() {
        Random gerador = new Random();
        int indiceAleatorio = gerador.nextInt(jogadores.size());
        return jogadores.get(indiceAleatorio);
    }

    // Método caso você queira saber o tamanho atual da lista
    public int getQuantidade() {
        return jogadores.size();
    }
}