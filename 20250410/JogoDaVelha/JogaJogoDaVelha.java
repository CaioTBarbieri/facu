import java.util.Random;
import java.util.Scanner;
public class JogaJogoDaVelha {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String resposta;

        do {
            JogoDaVelha jogo = new JogoDaVelha();

            while (jogo.vencedor() == 0 && !empate(jogo)) {
                int linha, coluna;
                do {
                    linha = random.nextInt(3);
                    coluna = random.nextInt(3);
                } while (jogo.tabuleiro[linha][coluna] != JogoDaVelha.VAZIO);

                jogo.poePeca(linha, coluna);
                System.out.println(jogo);
                System.out.println();
            }

            System.out.println("Tabuleiro final:");
            System.out.println(jogo);

            int vencedor = jogo.vencedor();
            if (vencedor == 1) System.out.println("X venceu");
            else if (vencedor == 2) System.out.println("O venceu");
            else System.out.println("Empate");

            System.out.print("Deseja jogar novamente? (s/n): ");
            resposta = scanner.nextLine().toLowerCase();

        } while (resposta.equals("s"));

        scanner.close();
    }

    public static boolean empate(JogoDaVelha jogo) {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (jogo.tabuleiro[i][j] == JogoDaVelha.VAZIO)
                    return false;
        return jogo.vencedor() == 0;
    }
}
