import java.util.Arrays;

public class MatrixService
{
    public static Matrix[] arrangeMatrices(Matrix[] matrices)
    {
        Arrays.sort(matrices, new SortMatrix());
        return matrices;
    }
}
