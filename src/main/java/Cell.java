import java.util.Objects;

class Cell {
    private int row;
    private int col;
    private int state;
    private static int LIVE_CELL_STATE=1;
    private static int DEAD_CELL_STATE=0;

    Cell(int row, int col) {
        this.row = row;
        this.col = col;
    }

     Cell(int row, int col, int state) {
        this.row = row;
        this.col = col;
        this.state = state;
    }

    int getRow() {
        return row;
    }

    int getCol() {
        return col;
    }

    public int getState() {
        return state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cell)) return false;
        Cell cell = (Cell) o;
        return row == cell.row &&
                col == cell.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }

    @Override
    public String toString() {
        return "Cell{" +
                "row=" + row +
                ", col=" + col +
                '}';
    }

    boolean isAlive() {
        return this.state == LIVE_CELL_STATE;
    }

    boolean isDead() {
        return !isAlive();
    }

    Cell die() {
        return new Cell(row,col,DEAD_CELL_STATE);
    }
}
