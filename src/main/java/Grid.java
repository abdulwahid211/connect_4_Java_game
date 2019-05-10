public class Grid {

    protected String connect4[][];

    Grid() {
        this.connect4 = new String[6][7];
    }

    public String[][] getConnect4() {
        return connect4;
    }

    public void initGrid() {

        int count = 10;

        for (int i = 0; i < this.connect4.length; i++) {
            for (int j = 0; j < this.connect4.length; j++) {

                this.connect4[i][j] = "O";

            }
        }
    }

    public void updateGrid(int column, String player) {


            for (int j  = this.connect4.length-1; j >=0 ; j--) {

                if (this.connect4[column-1][j].equals("O")) {
                    this.connect4[column-1][j] = player;
                    break;
                }
            }
        }



    public void printResults() {


        for (int i = 0; i < this.connect4.length; i++) {
            for (int j = 0; j < this.connect4.length; j++) {
                System.out.print(this.connect4[i][j] + " ");
            }

            System.out.println("");
        }
        System.out.println("");
    }


}
