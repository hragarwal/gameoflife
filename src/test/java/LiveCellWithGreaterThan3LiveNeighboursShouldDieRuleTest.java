import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LiveCellWithGreaterThan3LiveNeighboursShouldDieRuleTest {

    @Test
    public void liveCellShouldSurviveIfItHas2or3LiveNeighbours() {
        LiveCellWithGreaterThan3LiveNeighboursShouldDieRule rule =
                new LiveCellWithGreaterThan3LiveNeighboursShouldDieRule();
        Matrix matrix = MatrixUtil.getMatrix();
        Matrix updatedMatrixState = rule.apply(matrix);
        assertThat(updatedMatrixState.getCells().stream().filter(Cell::isAlive).count(), is(4L));
        assertThat(updatedMatrixState.getCells().stream().filter(Cell::isDead).count(), is(5L));
    }

    @Test
    public void liveShouldDieIfNeighboursAreLessThan2() {
        LiveCellWithGreaterThan3LiveNeighboursShouldDieRule rule =
                new LiveCellWithGreaterThan3LiveNeighboursShouldDieRule();
        Matrix matrix = MatrixUtil.getMatrixWithFirstRowCellsWithStateAs1();
        Matrix updatedMatrixState = rule.apply(matrix);
        assertThat(updatedMatrixState.getCells().stream().filter(Cell::isAlive).count(), is(3L));
        assertThat(updatedMatrixState.getCells().stream().filter(Cell::isDead).count(), is(6L));
    }

    @Test
    public void liveShouldDieIfNeighboursAreMoreThan3() {
        LiveCellWithGreaterThan3LiveNeighboursShouldDieRule rule =
                new LiveCellWithGreaterThan3LiveNeighboursShouldDieRule();
        Matrix matrix = MatrixUtil.getMatrixWithWillAllCellStateAs1();
        Matrix updatedMatrixState = rule.apply(matrix);
        assertThat(updatedMatrixState.getCells().stream().filter(Cell::isAlive).count(), is(4L));
        assertThat(updatedMatrixState.getCells().stream().filter(Cell::isDead).count(), is(5L));
    }
}