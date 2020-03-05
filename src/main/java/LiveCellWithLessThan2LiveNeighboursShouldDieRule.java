import java.util.ArrayList;
import java.util.List;

class LiveCellWithLessThan2LiveNeighboursShouldDieRule implements Rule {

    private static final int MIN_LIVE_NEIGHBOURS_FOR_ACTIVE = 2;

    @Override
    public Matrix apply(Matrix matrix) {
        List<Cell> cells = new ArrayList<>();
        for (Cell cell : matrix.getCells()) {
            long liveNeighbours = matrix.getLiveNeighboursCount(cell);
            cells.add(getCellNextState(liveNeighbours, cell));
        }
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
