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

        if (count == total){
            System.out.println("Draw!");
            System.out.println("GAME OVER!");
            System.exit(0);
        }

    }


}
