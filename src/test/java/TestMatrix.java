import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class TestMatrix
{
    @Test
    public void checkdeterminate()
    {
        Matrix matr = new Matrix(2);
        matr.setElement(0,0, 1);
        matr.setElement(0,1, 1);
        matr.setElement(1,0, 1);
        matr.setElement(1,1, 1);
        assertEquals(matr.getDeterminant(), 0);
    }

    @Test
    public void checkflag()
    {
        Matrix matr = new Matrix(2);
        matr.setElement(0,0, 1);
        matr.setElement(0,1, 1);
        matr.setElement(1,0, 1);
        matr.setElement(1,1, 1);
        matr.getDeterminant();
        matr.setElement(1,1, 0);
        matr.getDeterminant();
        assertEquals(matr.getDeterminant(), 0);
    }

    @Test
    public void checkcomparator()
    {
        SortMatrix matrix = new SortMatrix();

        DiagMatrix matr = new DiagMatrix(2);
        matr.setElement(0,0, 2);
        matr.setElement(1,1, 2);
        matr.calculateDeterminant();

        DiagMatrix matr1 = new DiagMatrix(2);
        matr1.setElement(0,0, 1);
        matr1.setElement(1,1, 2);
        matr1.calculateDeterminant();

        assertEquals(matrix.compare(matr1,matr), -2);
    }

    @Test
    public void checkarraymatrix()
    {
        Matrix[] arrmatr = new Matrix[3];
        DiagMatrix matr = new DiagMatrix(1);
        Matrix matr1 = new Matrix(1);
        UpTriangleMatrix matr2 = new UpTriangleMatrix(1);

        matr.setElement(0,0, 2);
        matr1.setElement(0,0,4);
        matr2.setElement(0,0,5);

        matr.calculateDeterminant();
        matr1.calculateDeterminant();
        matr2.calculateDeterminant();

        arrmatr[0] = matr1;
        arrmatr[1] = matr;
        arrmatr[2] = matr2;

        MatrixService matrixService = new MatrixService();

        matrixService.arrangeMatrices(arrmatr);

        assertEquals(arrmatr[0].getDeterminant(), 2);


    }
}
