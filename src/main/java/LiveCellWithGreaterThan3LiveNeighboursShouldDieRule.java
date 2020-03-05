import java.util.ArrayList;
import java.util.List;

class LiveCellWithGreaterThan3LiveNeighboursShouldDieRule implements Rule {

    private static final int MAX_LIVE_NEIGHBOURS_FOR_ACTIVE = 3;

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
        if (liveNeighbours > MAX_LIVE_NEIGHBOURS_FOR_ACTIVE) {
            return cell.die();
        }
        return cell;
    }
}
