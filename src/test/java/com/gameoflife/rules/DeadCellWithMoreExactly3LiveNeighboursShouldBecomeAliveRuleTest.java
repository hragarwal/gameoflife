package com.gameoflife.rules;

import com.gameoflife.Cell;
import com.gameoflife.Matrix;
import com.gameoflife.util.MatrixUtil;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class DeadCellWithMoreExactly3LiveNeighboursShouldBecomeAliveRuleTest {

    @Test
    public void shouldMakeDeadCellAliveIfItHasExactly3LiveNeighbours() {
        DeadCellWithMoreExactly3LiveNeighboursShouldBecomeAliveRule rule =
                new DeadCellWithMoreExactly3LiveNeighboursShouldBecomeAliveRule();
        Matrix matrix = MatrixUtil.getMatrixWithFirstRowCellsWithStateAs1();
        Matrix updatedMatrixState = rule.apply(matrix);
        assertThat(updatedMatrixState.getCells().stream().filter(Cell::isAlive).count(), is(4L));
        assertThat(updatedMatrixState.getCells().stream().filter(Cell::isDead).count(), is(5L));
    }

    @Test
    public void shouldNotMakeDeadCellAliveIfItDoesNotHaveExactly3LiveNeighbours() {
        DeadCellWithMoreExactly3LiveNeighboursShouldBecomeAliveRule rule =
                new DeadCellWithMoreExactly3LiveNeighboursShouldBecomeAliveRule();
        Matrix matrix = MatrixUtil.getMatrix();
        Matrix updatedMatrixState = rule.apply(matrix);
        assertThat(updatedMatrixState.getCells().stream().filter(Cell::isAlive).count(), is(4L));
        assertThat(updatedMatrixState.getCells().stream().filter(Cell::isDead).count(), is(5L));
    }

}