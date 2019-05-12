public class Board {

    private String matrix[][];

    private int rows = 0;
    private int column = 0;

    Board(int _rows, int _column) {
        this.rows = _rows;
        this.column = _column;
        this.matrix = new String[rows][column];
    }

    public int getRows() {
        return rows;
    }

    public int getColumn() {
        return column;
    }

    public String[][] getConnect4() {
        return matrix;
    }

    public void initBoard() {

        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[i].length; j++) {

                this.matrix[i][j] = "O";

            }
        }
    }

    public void updateBoard(int column, String player) {


        for (int j = this.matrix.length - 1; j >= 0; j--) {

            if (this.matrix[j][column - 1].equals("O")) {
                this.matrix[j][column - 1] = player;
                break;
            }
        }
    }


    public void printBoardResults() {

        for (int i = 1; i <= this.matrix.length; i++) {

            System.out.print(i+"* ");
        }
        System.out.println("");


        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[i].length; j++) {
                System.out.print(this.matrix[i][j] + "  ");
            }

            System.out.println("");
        }



    }


}
