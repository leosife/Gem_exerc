import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double racaoTotalAtual;
        Sobrevivente s1 = new Sobrevivente("Rick", false, 15.5);
        Sobrevivente s2 = new Sobrevivente("Shane", true, 50.0);
        Sobrevivente s3 = new Sobrevivente("Michonne", false, 20.0);
        Sobrevivente s4 = new Sobrevivente("James", false, 100.0);
        ControleAcampamento chinaTown = new ControleAcampamento();
        try {
            chinaTown.registrarSobrevivente("111", s1);
            chinaTown.registrarSobrevivente("222", s2);
            chinaTown.registrarSobrevivente("333", s3);
            chinaTown.registrarSobrevivente("444", s4);
        } catch (InfeccaoDetectadaException e) {
            System.out.println(e.getMessage());
        }


        Scanner sc = new Scanner(System.in);


        int choice;
        do {
            System.out.println("" +
                    " --- Seja bem vindo ao Controle do Acampamento ---\n" +
                    "1 - Cadastrar novo membro\n" +
                    "2 - Verificar um membro\n" +
                    "3 - Calcular total de comida\n" +
                    "4 - Testar um membro\n" +
                    "5 - Historia entradas\n" +

                    "0 - Sair");

            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Nome: ");
                    String nome = sc.nextLine();
                    System.out.println("Quantidade de ração?");
                    int racao = sc.nextInt();
                    sc.nextLine();
                    Sobrevivente sob = new Sobrevivente(nome, false, racao);
                    System.out.println("CPF: ");
                    try {
                        chinaTown.testeInfeccao(sob);
                        chinaTown.registrarSobrevivente(sc.nextLine(), sob);

                    } catch (InfeccaoDetectadaException e) {
                        System.out.println(e.getMessage());
                        System.out.println("Ativar medidas de segurança");
                    }
                    break;
                case 2:
                    System.out.println("Digite o CPF para buscar um membro");
                    try {
                        chinaTown.verificarStatus(sc.nextLine());
                    } catch (SobreviventeNaoEncontradoException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    racaoTotalAtual = chinaTown.somarRacoesTotais();
                    System.out.println("Ração total: " + racaoTotalAtual);
                    break;
                case 4:
                    break;
                case 5:
                    chinaTown.imprimirHistoricoEntradas();
                    break;
                case 0:
                    break;
            }

        } while (choice != 0);


        sc.close();
    }
}