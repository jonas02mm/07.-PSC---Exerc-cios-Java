import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] agenda = new String[31][24];

        int opcao;
        do {
            System.out.println("\nMenu:");
            System.out.println("1 - Agendar compromisso");
            System.out.println("2 - Consultar compromisso");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    agendarCompromisso(agenda, scanner);
                    break;
                case 2:
                    consultarCompromisso(agenda, scanner);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }

    public static void agendarCompromisso(String[][] agenda, Scanner scanner) {
        System.out.print("Digite o dia do mês (1-31): ");
        int dia = scanner.nextInt();
        if (dia < 1 || dia > 31) {
            System.out.println("Dia inválido.");
            return;
        }

        System.out.print("Digite a hora (0-23): ");
        int hora = scanner.nextInt();
        if (hora < 0 || hora > 23) {
            System.out.println("Hora inválida.");
            return;
        }

        scanner.nextLine(); 
        System.out.print("Digite o compromisso: ");
        String compromisso = scanner.nextLine();

        agenda[dia - 1][hora] = compromisso;
        System.out.println("Compromisso agendado com sucesso para o dia " + dia + " às " + hora + " horas.");
    }

    public static void consultarCompromisso(String[][] agenda, Scanner scanner) {
        System.out.print("Digite o dia do mês (1-31): ");
        int dia = scanner.nextInt();
        if (dia < 1 || dia > 31) {
            System.out.println("Dia inválido.");
            return;
        }

        System.out.print("Digite a hora (0-23): ");
        int hora = scanner.nextInt();
        if (hora < 0 || hora > 23) {
            System.out.println("Hora inválida.");
            return;
        }

        String compromisso = agenda[dia - 1][hora];
        if (compromisso != null && !compromisso.isEmpty()) {
            System.out.println("Compromisso para o dia " + dia + " às " + hora + " horas: " + compromisso);
        } else {
            System.out.println("Nenhum compromisso agendado para o dia " + dia + " às " + hora + " horas.");
        }
    }
}
