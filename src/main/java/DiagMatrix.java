public class DiagMatrix extends Matrix
{
    private int N;
    private double [] matrix = new double[N*N];

    public DiagMatrix(int N)
    {
        this.N = N;
        matrix = new double[N];
    }


    public DiagMatrix(double[] diagElems)
    {
        this(diagElems.length);

        if (diagElems == null || diagElems.length == 0) throw new IllegalArgumentException("Данный массив не существует или его размер равен 0");

        for(int i = 0; i < N; i++)
        {
            matrix[i] = diagElems[i];
        }
    }

    //Проверка корректности i j и геттеры?
    public void setElement(int i, int j, double elem) throws IllegalArgumentException
    {
        if(i < 0 || j < 0 || j > N || i > N || (i != j && elem != 0))
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

    @Override
    public int getN() {
        return N;
    }

    public double[] getMatrix()
    {
        return matrix;
    }
}
