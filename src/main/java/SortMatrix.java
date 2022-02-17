import java.util.Comparator;

public class SortMatrix implements Comparator<Matrix>

{
    public int compare(Matrix a, Matrix b)
    {
        return (int) (a.getDeterminant() - b.getDeterminant());
    }
}