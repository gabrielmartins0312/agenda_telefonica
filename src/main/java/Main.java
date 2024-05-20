import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Agenda agenda = new Agenda();

        System.out.println("Bem-vindo à Agenda Telefônica!");
        agenda.exibirContatos();

        boolean continuar = true;
        while (continuar) {
            System.out.println("1. Adicionar Contato");
            System.out.println("2. Exibir Contatos");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();  // Consume newline left-over

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do contato: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite o telefone do contato: ");
                    String telefone = scanner.nextLine();
                    agenda.adicionarContato(nome, telefone);
                    break;
                case 2:
                    agenda.exibirContatos();
                    break;
                case 3:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close();
        System.out.println("Programa encerrado.");
    }
}
