public class Matrix implements IMatrix
{
    private int N;
    private boolean flag = false;
    private double determinant;
    double [] matrix;

    public Matrix(){}

    public Matrix(int N)
    {
        this.N = N;
        this.matrix = new double[N*N];
    }

    public Matrix(final Matrix matr)
    {
        N = matr.getN();
        matrix = new double[N];
        for(int i = 0; i < getN(); i++)
        {
            this.matrix[i] = matrix[i];
        }
    }

    public double getElement(int i, int j)
    {
        return matrix[i*N+j];
    }


    public void setElement(int i, int j, double elem)
    {
        matrix[i*N+j] = elem;
        flag = false;
    }

    public int getN()
    {
        return N;
    }

    public void calculateDeterminant()
    {
        double det = 1, max, c, M;
        int r, i, j, k;
        if(flag == false)
        {
            for(k = 0; k < N; k++)
            {
                max = getElement(k, k);
                r = k;
                for(i = k+1; i < N; i++)
                    if(getElement(i, k) > max)
                    {
                        max = getElement(i, k);
                        r = i;
                    }

                if(r != k)
                {
                    det = -det;
                }
                for(j = 0; j<N; j++)
                {
                    c = getElement(k, j);
                    setElement(k, j, getElement(r,j));
                    setElement(r, j, c);
                }
                for(i = k+1; i < N; i++)
                {
                    j = k;
                    for (M = getElement(i, k) / getElement(k, k); j < N; j++){
                        setElement(i, j, getElement(i, j)-M * getElement(k, j));}
                }
            }
            for(i = 0; i < N; i++){
                det = det*getElement(i,i);
            }
            this.determinant = det;
            this.flag = true;
        }

    }
    public double getDeterminant(){
        if(flag == true){
            return determinant;
        }
        else return 0;
    }
}