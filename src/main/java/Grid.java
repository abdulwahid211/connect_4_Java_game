public class Grid {

    private String connect4[][];

    private int rows = 0;
    private int column = 0;

    Grid(int _rows, int _column) {
        this.rows = _rows;
        this.column = _column;
        this.connect4 = new String[rows][column];
    }

    public int getRows() {
        return rows;
    }

    public int getColumn() {
        return column;
    }

    public String[][] getConnect4() {
        return connect4;
    }

    public void initGrid() {

        for (int i = 0; i < this.connect4.length; i++) {
            for (int j = 0; j < this.connect4.length; j++) {

                this.connect4[i][j] = "O";

            }
        }
    }

    public void updateGrid(int column, String player) {


        for (int j = this.connect4.length - 1; j >= 0; j--) {

            if (this.connect4[j][column - 1].equals("O")) {
                this.connect4[j][column - 1] = player;
                break;
            }
        }
    }


    public void printGridResults() {


        for (int i = 0; i < this.connect4.length; i++) {
            for (int j = 0; j < this.connect4.length; j++) {
                System.out.print(this.connect4[i][j] + " ");
            }

            System.out.println("");
        }
        System.out.println("");
    }


}
