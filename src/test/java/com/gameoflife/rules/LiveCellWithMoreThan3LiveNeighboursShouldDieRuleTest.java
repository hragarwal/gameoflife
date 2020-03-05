package com.gameoflife.rules;

import com.gameoflife.Cell;
import com.gameoflife.Matrix;
import com.gameoflife.util.MatrixUtil;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LiveCellWithMoreThan3LiveNeighboursShouldDieRuleTest {

    @Test
    public void liveCellShouldSurviveIfItHas2or3LiveNeighbours() {
        LiveCellWithMoreThan3LiveNeighboursShouldDieRule rule =
                new LiveCellWithMoreThan3LiveNeighboursShouldDieRule();
        Matrix matrix = MatrixUtil.getMatrix();
        Matrix updatedMatrixState = rule.apply(matrix);
        assertThat(updatedMatrixState.getCells().stream().filter(Cell::isAlive).count(), is(4L));
        assertThat(updatedMatrixState.getCells().stream().filter(Cell::isDead).count(), is(5L));
    }

    @Test
    public void liveShouldDieIfNeighboursAreLessThan2() {
        LiveCellWithMoreThan3LiveNeighboursShouldDieRule rule =
                new LiveCellWithMoreThan3LiveNeighboursShouldDieRule();
        Matrix matrix = MatrixUtil.getMatrixWithFirstRowCellsWithStateAs1();
        Matrix updatedMatrixState = rule.apply(matrix);
        assertThat(updatedMatrixState.getCells().stream().filter(Cell::isAlive).count(), is(3L));
        assertThat(updatedMatrixState.getCells().stream().filter(Cell::isDead).count(), is(6L));
    }

    @Test
    public void liveShouldDieIfNeighboursAreMoreThan3() {
        LiveCellWithMoreThan3LiveNeighboursShouldDieRule rule =
                new LiveCellWithMoreThan3LiveNeighboursShouldDieRule();
        Matrix matrix = MatrixUtil.getMatrixWithWillAllCellStateAs1();
        Matrix updatedMatrixState = rule.apply(matrix);
        assertThat(updatedMatrixState.getCells().stream().filter(Cell::isAlive).count(), is(4L));
        assertThat(updatedMatrixState.getCells().stream().filter(Cell::isDead).count(), is(5L));
    }
}