import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matriz = new int[3][3];

        System.out.println("Preencha a matriz 3x3:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("Digite o elemento [" + (i + 1) + "][" + (j + 1) + "]: ");
                matriz[i][j] = scanner.nextInt();
            }
        }

        boolean quadradoMagico = verificarQuadradoMagico(matriz);

        if (quadradoMagico) {
            System.out.println("A matriz é um quadrado mágico.");
        } else {
            System.out.println("A matriz NÃO é um quadrado mágico.");
        }

        scanner.close();
    }

    public static boolean verificarQuadradoMagico(int[][] matriz) {
        int somaReferencia = somaLinha(matriz, 0);


        for (int i = 1; i < matriz.length; i++) {
            if (somaLinha(matriz, i) != somaReferencia) {
                return false;
            }
        }

        for (int j = 0; j < matriz[0].length; j++) {
            if (somaColuna(matriz, j) != somaReferencia) {
                return false;
            }
        }

        if (somaDiagonalPrincipal(matriz) != somaReferencia) {
            return false;
        }

        if (somaDiagonalSecundaria(matriz) != somaReferencia) {
            return false;
        }

        return true;
    }

    public static int somaLinha(int[][] matriz, int linha) {
        int soma = 0;
        for (int j = 0; j < matriz[0].length; j++) {
            soma += matriz[linha][j];
        }
        return soma;
    }

    public static int somaColuna(int[][] matriz, int coluna) {
        int soma = 0;
        for (int i = 0; i < matriz.length; i++) {
            soma += matriz[i][coluna];
        }
        return soma;
    }

    public static int somaDiagonalPrincipal(int[][] matriz) {
        int soma = 0;
        for (int i = 0; i < matriz.length; i++) {
            soma += matriz[i][i];
        }
        return soma;
    }

    public static int somaDiagonalSecundaria(int[][] matriz) {
        int soma = 0;
        for (int i = 0; i < matriz.length; i++) {
            soma += matriz[i][matriz.length - 1 - i];
        }
        return soma;
    }
}
