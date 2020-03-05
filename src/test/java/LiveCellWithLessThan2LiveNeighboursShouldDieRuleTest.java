import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class LiveCellWithLessThan2LiveNeighboursShouldDieRuleTest {

    @Test
    public void shouldKillCellsInMatrixIfLiveNeighboursAreLessThan2() {
        LiveCellWithLessThan2LiveNeighboursShouldDieRule rule =
                new LiveCellWithLessThan2LiveNeighboursShouldDieRule();
        Matrix matrix = MatrixUtil.getMatrixWithFirstRowCellsWithStateAs1();
        Matrix updatedMatrixState = rule.apply(matrix);
        assertThat(updatedMatrixState.getCells().stream().filter(Cell::isAlive).count(), is(1L));
        assertThat(updatedMatrixState.getCells().stream().filter(Cell::isDead).count(), is(8L));
    }
}