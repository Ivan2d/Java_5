public class UpTriangleMatrix extends Matrix
{

    public UpTriangleMatrix(int N)
    {
        this.N = N;
        matrix = new double[N];
    }

    public UpTriangleMatrix(double[] matrix)
    {

        this.N = matrix.length;

        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                if (i <= j)
                {
                    matrix[i*N+j] = matrix[i];
                }
            }

        }
    }

    public void setElement(int i, int j, double elem) throws IllegalArgumentException
    {
        if(i < 0 || j < 0 || j > N || i > N || (i > j && elem != 0))
        {
            throw new IllegalArgumentException("Введено неверное значение");
        }

        matrix[i] = elem;
    }

    public double getElement(int i, int j)
    {
        if(i < 0 || j < 0 || j > N || i > N)
        {
            throw new IllegalArgumentException("Введено неверное значение");
        }

        return matrix[i * N + j];
    }
}
