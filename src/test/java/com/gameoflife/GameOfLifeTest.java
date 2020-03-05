package com.gameoflife;

import com.gameoflife.util.MatrixUtil;
import org.junit.Test;
import com.gameoflife.rules.LiveCellWithMoreThan3LiveNeighboursShouldDieRule;
import com.gameoflife.rules.LiveCellWithLessThan2LiveNeighboursShouldDieRule;
import com.gameoflife.rules.Rule;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GameOfLifeTest {

    private GameOfLife gameOfLife;


    @Test
    public void noCellShouldDie() {
        //given
        List<Rule> rules = new ArrayList<Rule>(){{
            add(new LiveCellWithLessThan2LiveNeighboursShouldDieRule());
        }};
        gameOfLife = new GameOfLife(rules);
        Matrix matrix = MatrixUtil.getMatrix();
        //when
        Matrix nextSate = gameOfLife.nextGeneration(matrix);
        //then
        assertThat(nextSate.getCells().stream().filter(Cell::isAlive).count(), is(4L));
        assertThat(nextSate.getCells().stream().filter(Cell::isDead).count(), is(5L));
    }

    @Test
    public void anyCellWithLessThanTwoActiveLiveNeighboursShouldDie() {
        //given
        List<Rule> rules = new ArrayList<Rule>(){{
            add(new LiveCellWithLessThan2LiveNeighboursShouldDieRule());
        }};
        gameOfLife = new GameOfLife(rules);
        Matrix matrix = MatrixUtil.getMatrixWithFirstRowCellsWithStateAs1();
        //when
        Matrix nextSate = gameOfLife.nextGeneration(matrix);
        //then
        assertThat(nextSate.getCells().stream().filter(Cell::isAlive).count(), is(1L));
        assertThat(nextSate.getCells().stream().filter(Cell::isDead).count(), is(8L));
    }

    @Test
    public void anyCellWith2or3LiveNeighboursShouldSurvive() {
        //given
        List<Rule> rules = new ArrayList<Rule>(){{
            add(new LiveCellWithLessThan2LiveNeighboursShouldDieRule());
            add(new LiveCellWithMoreThan3LiveNeighboursShouldDieRule());
        }};
        gameOfLife = new GameOfLife(rules);
        Matrix matrix = MatrixUtil.getMatrixWithWillAllCellStateAs1();
        //when
        Matrix nextSate = gameOfLife.nextGeneration(matrix);
        //then
        assertThat(nextSate.getCells().stream().filter(Cell::isAlive).count(), is(4L));
        assertThat(nextSate.getCells().stream().filter(Cell::isDead).count(), is(5L));
    }
}
