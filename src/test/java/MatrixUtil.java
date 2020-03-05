import com.gameoflife.Cell;
import com.gameoflife.Matrix;

import java.util.ArrayList;
import java.util.List;

class MatrixUtil {

    static Matrix getMatrix(){
        /*  0,1,0
            1,0,1
            0,1,0
         */
        List<Cell> cells = new ArrayList<>();
        for (int row = 0; row< 3; row++){
            for (int col = 0; col< 3; col++){
                cells.add(new Cell(row,col,(row+col)%2));
            }
        }
        return new Matrix(cells);
    }

    static Matrix getMatrixWithFirstRowCellsWithStateAs1(){
         /* 1,1,1
            0,0,0
            0,0,0
         */
        List<Cell> cells = new ArrayList<>();
        for (int row = 0; row< 3; row++){
            cells.add(new Cell(row, 0, row == 0 ? 1 : 0));
            cells.add(new Cell(row, 1, row == 0 ? 1 : 0));
            cells.add(new Cell(row, 2, row == 0 ? 1 : 0));
        }
        return new Matrix(cells);
    }

    static Matrix getMatrixWithWillAllCellStateAs1(){
         /* 1,1,1
            1,1,1
            1,1,1
         */
        List<Cell> cells = new ArrayList<>();
        for (int row = 0; row< 3; row++){
            cells.add(new Cell(row, 0, 1));
            cells.add(new Cell(row, 1, 1));
            cells.add(new Cell(row, 2, 1));
        }
        return new Matrix(cells);
    }
}
