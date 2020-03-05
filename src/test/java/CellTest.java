import com.gameoflife.Cell;
import org.junit.Test;

import static org.junit.Assert.*;

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
}