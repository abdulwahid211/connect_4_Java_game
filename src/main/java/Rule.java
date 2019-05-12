public class Rule {

    private Board board;

    private String matrix[][];

    public Rule(Board _board) {

        this.board = _board;

        this.matrix = this.board.getConnect4();
    }


    public boolean illegalColumnInput(int column) {

        int count = 0;

        for (int j = this.matrix.length - 1; j >= 0; j--) {

            if (!this.matrix[j][column - 1].equals("O")) {
                count = count + 1;
            }
        }

        if (count == this.matrix.length) {
            return true;
        }

        return false;


    }

    public void checkDraw(int totalMoves) {

        int total = this.board.getColumn() * this.board.getRows();

        if (totalMoves == total) {
            System.out.println("Draw!");
            System.out.println("GAME OVER!");
            System.exit(0);
        }

    }

    public void isConnected(int y, String player) {

        for (int x = 0; x < this.matrix.length; x++) {

            int count = 0;
            int i = y;

            //HORIZONTAL.
            while (i < board.getRows() && matrix[x][i].equals(player)) {
                count++;
                i++;
            }
            i = y - 1;

            while (i >= 0 && matrix[x][i].equals(player)) {
                count++;
                i--;
            }

            verifyResult(count,player);

            //VERTICAL.
            count = 0;
            int j = x;
            while (j < board.getColumn() && this.matrix[j][y - 1].equals(player)) {
                count++;
                j++;
            }

            verifyResult(count,player);

            //SECONDARY DIAGONAL.
            count = 0;
            i = x;
            j = y;
            while (i < board.getRows() && j < board.getColumn() && this.matrix[i][j].equals(player)) {
                count++;
                i++;
                j++;
            }
            i = x - 1;
            j = y - 1;
            while (i >= 0 && j >= 0 && this.matrix[i][j].equals(player)) {
                count++;
                i--;
                j--;
            }

            verifyResult(count,player);

            //LEADING DIAGONAL.
            count = 0;
            i = x;
            j = y - 1;
            while (i < board.getRows() && j >= 0 && this.matrix[i][j].equals(player)) {
                count++;
                i++;
                j--;
            }
            i = x - 1;
            j = (y - 1) + 1;
            while (i >= 0 && j < board.getColumn() && this.matrix[i][j].equals(player)) {
                count++;
                i--;
                j++;
            }

            verifyResult(count,player);

        } // end loop
    }

    public void verifyResult(int count, String player) {

        int total = 4;

        if (count == total) {
            System.out.println("Player: "+player+" Win!");
            System.out.println("GAME OVER!");
            board.printBoardResults();
            System.exit(0);
        }


    }
}
