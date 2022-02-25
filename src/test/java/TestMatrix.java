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
        assertEquals(matr.calculateDeterminant(), 0);
    }

    @Test
    public void checkflag()
    {
        Matrix matr = new Matrix(2);
        matr.setElement(0,0, 1);
        matr.setElement(0,1, 1);
        matr.setElement(1,0, 1);
        matr.setElement(1,1, 1);
        matr.calculateDeterminant();
        matr.setElement(1,1, 0);
        matr.calculateDeterminant();
        assertEquals(matr.calculateDeterminant(), 0);
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

        assertEquals(matrix.compare(matr1,matr), 0);
    }

    @Test
    public void checkarraymatrix()
    {
        Matrix[] arrmatr = new Matrix[4];
        DiagMatrix matr4 = new DiagMatrix(1);
        Matrix matr1 = new Matrix(1);
        UpTriangleMatrix matr2 = new UpTriangleMatrix(1);
        UpTriangleMatrix matr3 = new UpTriangleMatrix(1);

        matr3.setElement(0,0, 15);
        matr1.setElement(0,0,6);
        matr2.setElement(0,0,28);
        matr4.setElement(0,0, 7);

        arrmatr[0] = matr2;
        arrmatr[1] = matr4;
        arrmatr[2] = matr1;
        arrmatr[3] = matr3;

        MatrixService matrixService = new MatrixService();
        matrixService.arrangeMatrices(arrmatr);

        assertEquals(arrmatr[3].calculateDeterminant(), 28);

    }
//геттеры и сеттеры, проверить работоспособность
}
