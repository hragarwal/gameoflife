package com.gameoflife;

import com.gameoflife.util.MatrixUtil;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MatrixTest {

    @Test
    public void shouldCreateAMatrix() {
        Matrix matrix = new Matrix(Collections.emptyList());
        assertNotNull(matrix);
        assertThat(matrix.getCells().size(), is(0));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void shouldNotAllowModifyingCellsInMatrix() {
        Matrix matrix = new Matrix(Collections.emptyList());
        matrix.getCells().add(new Cell(0,0));
    }

    @Test
    public void getNeigborsForCellPositionTwoAndTwo() {
        //given
        Matrix matrix = MatrixUtil.getMatrix();
        //when
        Set<Cell> neigbors = matrix.getNeigbours(new Cell(2,2));
        //then
        Set<Cell> expectedNeighbours = new HashSet<Cell>() {{
            add(new Cell(2,1));
            add(new Cell(1,2));
            add(new Cell(1,1));
        }};
        assertEquals(expectedNeighbours, neigbors);
    }

    @Test
    public void getNeigborsForCellPositionOneAndOne() {
        //given
        Matrix matrix = MatrixUtil.getMatrix();
        //when
        Set<Cell> neigbors = matrix.getNeigbours(new Cell(1,1));
        //then
        Set<Cell> expectedNeighbours = new HashSet<Cell>() {{
            add(new Cell(0,0));
            add(new Cell(0,1));
            add(new Cell(0,2));
            add(new Cell(1,0));
            add(new Cell(1,2));
            add(new Cell(2,0));
            add(new Cell(2,1));
            add(new Cell(2,2));
        }};
        assertEquals(expectedNeighbours, neigbors);
    }

    @Test
    public void getNeigborsForCellPositionZeroAndZero() {
        //given
        Matrix matrix = MatrixUtil.getMatrix();
        //when
        Set<Cell> neigbors = matrix.getNeigbours(new Cell(0,0));
        //then
        Set<Cell> expectedNeighbours = new HashSet<Cell>() {{
            add(new Cell(0,1));
            add(new Cell(1,0));
            add(new Cell(1,1));
        }};
        assertEquals(expectedNeighbours, neigbors);
    }

    @Test
    public void getNeigborsForCellPositionZeroAndOne() {
        //given
        Matrix matrix = MatrixUtil.getMatrix();
        //when
        Set<Cell> neigbors = matrix.getNeigbours(new Cell(0,1));
        //then
        Set<Cell> expectedNeighbours = new HashSet<Cell>() {{
            add(new Cell(0,0));
            add(new Cell(0,2));
            add(new Cell(1,1));
            add(new Cell(1,0));
            add(new Cell(1,2));
        }};
        assertEquals(expectedNeighbours, neigbors);
    }

    @Test
    public void shouldReturnCellFromMatrixIfPositionExists() {
        Matrix matrix = MatrixUtil.getMatrix();
        Cell cell = matrix.getCellAtPosition(2, 2);
        assertNotNull(cell);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldReturnFalseFromMatrixIfPositionDoesNotExists() {
        Matrix matrix = MatrixUtil.getMatrix();
        matrix.getCellAtPosition(3, 1);
    }

    @Test
    public void shouldReturnLiveNeigboursCountAsTwoForPosition0And1() {
        Matrix matrix = MatrixUtil.getMatrix();
        long actualLiveNeigbours = matrix.getLiveNeighboursCount(new Cell(0, 1));
        assertEquals(2,actualLiveNeigbours);
    }

    @Test
    public void shouldReturnLiveNeigboursCountAsFourForPosition1And1() {
        Matrix matrix = MatrixUtil.getMatrix();
        long actualLiveNeigbours = matrix.getLiveNeighboursCount(new Cell(1, 1));
        assertEquals(4,actualLiveNeigbours);
    }

}
