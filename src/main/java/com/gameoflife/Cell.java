package com.gameoflife;

import java.util.Objects;

public class Cell {
    private int row;
    private int col;
    private int state;
    //FIXME: extract to an enum
    private static int LIVE_CELL_STATE=1;
    private static int DEAD_CELL_STATE=0;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
    }

     public Cell(int row, int col, int state) {
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

    public boolean isAlive() {
        return this.state == LIVE_CELL_STATE;
    }

    public boolean isDead() {
        return !isAlive();
    }

    public Cell die() {
        return new Cell(row,col,DEAD_CELL_STATE);
    }

    public Cell alive() {
        return new Cell(row,col,LIVE_CELL_STATE);
    }
}
