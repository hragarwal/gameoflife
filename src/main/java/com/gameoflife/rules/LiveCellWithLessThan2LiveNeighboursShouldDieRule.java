package com.gameoflife.rules;


import com.gameoflife.Cell;
import com.gameoflife.Matrix;

import java.util.List;
import java.util.stream.Collectors;

public class LiveCellWithLessThan2LiveNeighboursShouldDieRule implements Rule {

    private static final int MIN_LIVE_NEIGHBOURS_FOR_ACTIVE = 2;

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
        if (liveNeighbours < MIN_LIVE_NEIGHBOURS_FOR_ACTIVE) {
            return cell.die();
        }
        return cell;
    }
}
