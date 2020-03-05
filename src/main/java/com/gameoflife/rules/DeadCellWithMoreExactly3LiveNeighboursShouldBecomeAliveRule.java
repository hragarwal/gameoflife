package com.gameoflife.rules;


import com.gameoflife.Cell;
import com.gameoflife.Matrix;

import java.util.List;
import java.util.stream.Collectors;

public class DeadCellWithMoreExactly3LiveNeighboursShouldBecomeAliveRule implements Rule {

    private static final int EXACT_LIVE_NEIGHBOURS_TO_BECOME_ACTIVE = 3;

    @Override
    public Matrix apply(Matrix matrix) {
        List<Cell> cells = matrix.getCells()
                .stream()
                .map(cell -> getCellNextState(matrix.getLiveNeighboursCount(cell), cell))
                .collect(Collectors.toList());
        return new Matrix(cells);
    }

    private Cell getCellNextState(long liveNeighbours, Cell cell) {
        //FIXME
        if (liveNeighbours == EXACT_LIVE_NEIGHBOURS_TO_BECOME_ACTIVE) {
            return cell.alive();
        }
        return cell;
    }
}
