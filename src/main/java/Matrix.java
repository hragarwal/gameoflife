import java.util.*;

import static java.lang.Math.abs;
import static java.lang.Math.max;
import static java.lang.Math.min;

class Matrix {

    private List<Cell> cells;

    Matrix(List<Cell> cells) {
        this.cells = cells;
    }

    List<Cell> getCells() {
        return Collections.unmodifiableList(cells);
    }

    Set<Cell> getNeigbours(Cell cell) {
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

    long getLiveNeighboursCount(Cell cell) {
        return this.getNeigbours(cell)
                .stream()
                .filter(Cell::isAlive)
                .count();
    }

    Cell getCellAtPosition(int row, int col) {
        return cells.stream()
                .filter(cell -> row==cell.getRow() && col==cell.getCol())
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
