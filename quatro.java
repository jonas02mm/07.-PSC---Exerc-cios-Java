import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Matriz matriz = new Matriz();

        System.out.println("Preencha a matriz 4x4:");
        matriz.preencherMatriz(scanner);

        System.out.println("\nValores da diagonal principal:");
        matriz.exibirDiagonalPrincipal();

        System.out.println("\nValores da diagonal secundária:");
        matriz.exibirDiagonalSecundaria();

        System.out.println("\nMatriz transposta:");
        matriz.exibirMatrizTransposta();

        scanner.close();
    }
}

class Matriz {
    private float[][] matriz;

    public Matriz() {
        matriz = new float[4][4];
    }

    public void preencherMatriz(Scanner scanner) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print("Digite o valor para a posição [" + i + "][" + j + "]: ");
                matriz[i][j] = scanner.nextFloat();
            }
        }
    }

    public void exibirDiagonalPrincipal() {
        for (int i = 0; i < matriz.length; i++) {
            System.out.println(matriz[i][i]);
        }
    }

    public void exibirDiagonalSecundaria() {
        for (int i = 0; i < matriz.length; i++) {
            System.out.println(matriz[i][matriz.length - 1 - i]);
        }
    }

    public void exibirMatrizTransposta() {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[j][i] + " ");
            }
            System.out.println();
        }
    }
}
