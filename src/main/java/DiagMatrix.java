public class DiagMatrix extends Matrix
{
    private int N;
    private double [] matrix = new double[N*N];
    public DiagMatrix(int N)
    {
        super(N);
    }

    public DiagMatrix(double[] diagElems)
    {
        this.N = diagElems.length;
        for(int i = 0; i < N; i++){
            matrix[i+N+1] = diagElems[i];
        }
    }

    public void setElem(int i, int j, double elem) throws Exception
    {
        if(i*N+j != i*N+1){
            if(elem != 0){
                throw new Exception("Введено неверное значение");
            }
            else{
                matrix[i*N+j] = elem;
            }
        }
        else{
            matrix[i*N+j] = elem;
        }
    }
}