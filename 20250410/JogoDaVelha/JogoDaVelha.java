public class JogoDaVelha {
    protected static final int X = 1, O = -1;
    protected static final int VAZIO = 0;
    protected int tabuleiro[][] = new int[3][3];
    protected int jogador;

    public JogoDaVelha() {
        limpaTabuleiro();
    }


    public void limpaTabuleiro() {
        for(int i = 0;i<3;i++) {
            for (int j=0; j<3; j++) {
                tabuleiro[i][j]=VAZIO;
            }
        }
        jogador = X;
    }

    public void poePeca(int i, int j) {
        if (i<0||i>2||j<0||j>2){
            throw new IllegalArgumentException("Posição Inválida");
        }
        if (tabuleiro[i][j]!=VAZIO) throw new IllegalArgumentException("Posição Ocupada");
        tabuleiro[i][j]=jogador;
        jogador = -jogador;
    }

    public boolean eVencedor(int marca) {
        return ((tabuleiro[0][0] + tabuleiro[0][1] + tabuleiro[0][2] == marca*3) 	// linha 0 
|| (tabuleiro[1][0] + tabuleiro[1][1] + tabuleiro[1][2] == marca*3) 			// linha 1 
|| (tabuleiro[2][0] + tabuleiro[2][1] + tabuleiro[2][2] == marca*3) 			// linha 2 
|| (tabuleiro[0][0] + tabuleiro[1][0] + tabuleiro[2][0] == marca*3) 			// coluna 0 
|| (tabuleiro[0][1] + tabuleiro[1][1] + tabuleiro[2][1] == marca*3) 			// coluna 1 
|| (tabuleiro[0][2] + tabuleiro[1][2] + tabuleiro[2][2] == marca*3) 			// coluna 2 
|| (tabuleiro[0][0] + tabuleiro[1][1] + tabuleiro[2][2] == marca*3) 			// diagonal 
|| (tabuleiro[2][0] + tabuleiro[1][1] + tabuleiro[0][2] == marca*3)); 		// diagonal
    }

    public int vencedor() {
        for (int i = 0; i < 3; i++) {
            int somaLinha = 0;
            int somaColuna = 0;
            
            for (int j = 0; j < 3; j++) {
                somaLinha += tabuleiro[i][j];
                somaColuna += tabuleiro[j][i];
            }       
            if (somaLinha == 3 || somaColuna == 3) {
                return 1; 
            }
            if (somaLinha == -3 || somaColuna == -3) {
                return 2; 
            }
        }
        int diagonalPrincipal = tabuleiro[0][0] + tabuleiro[1][1] + tabuleiro[2][2];
        int diagonalSecundaria = tabuleiro[0][2] + tabuleiro[1][1] + tabuleiro[2][0];
        
        if (diagonalPrincipal == 3 || diagonalSecundaria == 3) {
            return 1;
        }
        if (diagonalPrincipal == -3 || diagonalSecundaria == -3) {
            return 2;
        }
        
        return 0;
    }

    
    public String toString() {
        StringBuilder retorno = new StringBuilder(); // Usando StringBuilder porque é melhor para concatenação de strings
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                switch (tabuleiro[i][j]) {
                    case X:
                        retorno.append(" X ");
                        break;
                    case O:
                        retorno.append(" O ");
                        break;
                    default:
                        retorno.append("   ");
                        break;
                }
                if (j < 2) retorno.append("|"); 
            }
            retorno.append("\n");
            if (i < 2) retorno.append("---+---+---\n");
        }
        return retorno.toString();
    }
}