public class Rule {

    private Grid grid;

    private String connect4[][];

    public Rule(Grid _grid) {

        this.grid = _grid;

        this.connect4 = this.grid.getConnect4();
    }


    public boolean illegalColumnInput(int column) {

        int count = 0;

        for (int j = this.connect4.length - 1; j >= 0; j--) {

            if (!this.connect4[j][column - 1].equals("O")) {
                count = count + 1;
            }
        }

        if (count == this.connect4.length) {
            return true;
        }

        return false;


    }

    public void checkDraw() {

        int count = 0;

        int total = this.grid.getColumn() * this.grid.getRows();

        for (int i = 0; i < this.connect4.length; i++) {
            for (int j = 0; j < this.connect4.length; j++) {
                if (!this.connect4[i][j].equals("O")) {
                    count = count + 1;

                }
            }
        }

        if (count == total) {
            System.out.println("Draw!");
            System.out.println("GAME OVER!");
            System.exit(0);
        }

    }

    public void checkHorizontalAndVertical() {

        int total = 4;

        for (int i = 0; i < this.connect4.length; i++) {
            int count_p1_horizontal = 0;
            int count_p2_horizontal = 0;
            int count_p1_vertical = 0;
            int count_p2_vertical = 0;

            for (int j = 0; j < this.connect4.length; j++) {

                if (this.connect4[i][j].equals("P1")) {
                    count_p1_horizontal = count_p1_horizontal + 1;
                }

                if (this.connect4[i][j].equals("P2")) {
                    count_p2_horizontal = count_p2_horizontal + 1;
                }

                if (this.connect4[j][i].equals("P1")) {
                    count_p1_vertical = count_p1_vertical + 1;
                }

                if (this.connect4[j][i].equals("P2")) {
                    count_p2_vertical = count_p2_vertical + 1;
                }
            }
            if (count_p1_horizontal == total || count_p1_vertical == total) {
                System.out.println("Player 1 Win!");
                System.out.println("GAME OVER!");
                System.exit(0);
            }
            if (count_p2_horizontal == total || count_p2_vertical == total) {
                System.out.println("Player 2 Win!");
                System.out.println("GAME OVER!");
                System.exit(0);
            }

        }
    }
}
