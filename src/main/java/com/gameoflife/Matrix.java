package com.gameoflife;

import java.util.*;

import static java.lang.Math.abs;
import static java.lang.Math.max;
import static java.lang.Math.min;

public class Matrix {

    private List<Cell> cells;

    public Matrix(List<Cell> cells) {
        this.cells = cells;
    }

    public List<Cell> getCells() {
        return Collections.unmodifiableList(cells);
    }

    public Set<Cell> getNeigbours(Cell cell) {
        Set<Cell> neighbors = new HashSet<>();
        int row = cell.getRow();
        int col = cell.getCol();
        neighbors.add(getCellAtPosition(min((abs(row - 1)) % 3, row), min((abs(col - 1)) % 3, col)));
        neighbors.add(getCellAtPosition(min((abs(row - 1)) % 3, row), col));
        neighbors.add(getCellAtPosition(min((abs(row - 1)) % 3, row), max((abs(col + 1)) % 3, col)));
        neighbors.add(getCellAtPosition(row, min((abs(col - 1)) % 3, col)));
        neighbors.add(getCellAtPosition(row, max((abs(col + 1)) % 3, col)));
        neighbors.add(getCellAtPosition(max((abs(row + 1)) % 3, row), min((abs(col - 1)) % 3, col)));
        neighbors.add(getCellAtPosition(max((abs(row + 1)) % 3, row), col));
        neighbors.add(getCellAtPosition(max((abs(row + 1)) % 3, row), max((abs(col + 1)) % 3, col)));
        neighbors.remove(getCellAtPosition(row, col));
        return neighbors;
    }

    public long getLiveNeighboursCount(Cell cell) {
        return this.getNeigbours(cell)
                .stream()
                .filter(Cell::isAlive)
                .count();
    }

    public Cell getCellAtPosition(int row, int col) {
        return cells.stream()
                .filter(cell -> row==cell.getRow() && col==cell.getCol())
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
