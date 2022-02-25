public class Matrix implements IMatrix
{
    protected int N;
    private boolean flag = false;
    private double determinant;
    protected double[] matrix;

    public Matrix(){}

    public Matrix(int N)
    {
        this.N = N;
        this.matrix = new double[N * N];
    }

    public Matrix(final Matrix matr)
    {
        N = matr.getN();
        matrix = new double[N];
        for (int i = 0; i < getN(); i++)
        {
            this.matrix[i] = matrix[i];
        }
    }

    public double getElement(int i, int j)
    {
        if(i < 0 || j < 0 || j > N || i > N)
        {
            throw new IllegalArgumentException("Введено неверное значение индекса элемента");
        }

        return matrix[i * N + j];
    }


    public void setElement(int i, int j, double elem)
    {
        if(i < 0 || j < 0 || j > N || i > N)
        {
            throw new IllegalArgumentException("Введено неверное значение индекса элемента");
        }

        matrix[i * N + j] = elem;
        flag = false;
    }

    public int getN()
    {
        return N;
    }

    public double calculateDeterminant()
    {
        if (flag) {
            return determinant;
        }

        double det = 1, max, c, M;
        int r, i, j, k;

        for (k = 0; k < N; k++)
        {
            max = getElement(k, k);

            r = k;
            for (i = k + 1; i < N; i++)
                if (getElement(i, k) > max)
                {
                    max = getElement(i, k);
                    r = i;
                }

            if (r != k) {
                det = -det;
            }
            for (j = 0; j < N; j++)
            {
                c = getElement(k, j);
                setElement(k, j, getElement(r, j));
                setElement(r, j, c);
            }

            for (i = k + 1; i < N; i++)
            {
                j = k;
                for (M = getElement(i, k) / getElement(k, k); j < N; j++) {
                    setElement(i, j, getElement(i, j) - M * getElement(k, j));
                }
            }
        }

        for (i = 0; i < N; i++)
        {
            det = det * getElement(i, i);
        }

        determinant = det;
        flag = true;

        return determinant;
    }
}
