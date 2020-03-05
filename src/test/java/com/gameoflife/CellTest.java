package com.gameoflife;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CellTest {

    @Test
    public void shouldReturnIsAliveTrueIfCellIsLive() {
        Cell cell = new Cell(1,1,1);
        assertTrue(cell.isAlive());
    }

    @Test
    public void shouldReturnIsAliveFalseIfCellIsDead() {
        Cell cell = new Cell(1,1,0);
        assertFalse(cell.isAlive());
    }

    @Test
    public void shouldReturnADeadCell() {
        Cell cell = new Cell(1,1,1);
        Cell nextCellState = cell.die();
        assertFalse(nextCellState.isAlive());
    }

    @Test
    public void shouldReturnALiveCell() {
        Cell cell = new Cell(1,1,0);
        Cell nextCellState = cell.alive();
        assertTrue(nextCellState.isAlive());
    }
}