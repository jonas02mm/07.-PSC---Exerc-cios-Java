import java.util.Scanner;

public class JogoDaVelha {
    private char[][] tabuleiro;
    private char jogadorAtual;

    public JogoDaVelha() {
        tabuleiro = new char[3][3];
        jogadorAtual = 'X';
        inicializarTabuleiro();
    }

    public void jogar() {
        Scanner scanner = new Scanner(System.in);
        boolean jogoAtivo = true;

        while (jogoAtivo) {
            exibirTabuleiro();
            System.out.println("É a vez do jogador " + jogadorAtual);
            System.out.print("Informe a linha (0-2): ");
            int linha = scanner.nextInt();
            System.out.print("Informe a coluna (0-2): ");
            int coluna = scanner.nextInt();

            if (validarJogada(linha, coluna)) {
                tabuleiro[linha][coluna] = jogadorAtual;
                if (verificarVencedor()) {
                    exibirTabuleiro();
                    System.out.println("Parabéns! O jogador " + jogadorAtual + " venceu!");
                    jogoAtivo = false;
                } else if (verificarEmpate()) {
                    exibirTabuleiro();
                    System.out.println("O jogo terminou em empate!");
                    jogoAtivo = false;
                } else {
                    alternarJogador();
                }
            } else {
                System.out.println("Jogada inválida. Tente novamente.");
            }
        }

        scanner.close();
    }

    private void inicializarTabuleiro() {
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {
                tabuleiro[i][j] = '-';
            }
        }
    }

    private void exibirTabuleiro() {
        System.out.println("  0 1 2");
        for (int i = 0; i < tabuleiro.length; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < tabuleiro[i].length; j++) {
                System.out.print(tabuleiro[i][j] + " ");
            }
            System.out.println();
        }
    }

    private boolean validarJogada(int linha, int coluna) {
        if (linha < 0 || linha >= 3 || coluna < 0 || coluna >= 3) {
            return false;
        }
        return tabuleiro[linha][coluna] == '-';
    }

    private void alternarJogador() {
        jogadorAtual = (jogadorAtual == 'X') ? 'O' : 'X';
    }

    private boolean verificarVencedor() {
        return (verificarLinhas() || verificarColunas() || verificarDiagonais());
    }

    private boolean verificarLinhas() {
        for (int i = 0; i < 3; i++) {
            if (tabuleiro[i][0] != '-' && tabuleiro[i][0] == tabuleiro[i][1] && tabuleiro[i][1] == tabuleiro[i][2]) {
                return true;
            }
        }
        return false;
    }

    private boolean verificarColunas() {
        for (int j = 0; j < 3; j++) {
            if (tabuleiro[0][j] != '-' && tabuleiro[0][j] == tabuleiro[1][j] && tabuleiro[1][j] == tabuleiro[2][j]) {
                return true;
            }
        }
        return false;
    }

    private boolean verificarDiagonais() {
        return (tabuleiro[0][0] != '-' && tabuleiro[0][0] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][2]) ||
                (tabuleiro[0][2] != '-' && tabuleiro[0][2] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][0]);
    }

    private boolean verificarEmpate() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tabuleiro[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        JogoDaVelha jogo = new JogoDaVelha();
        jogo.jogar();
    }
}
