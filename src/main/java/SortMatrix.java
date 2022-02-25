import java.util.Comparator;

public class SortMatrix implements Comparator<Matrix>
    {

    public int compare(Matrix a, Matrix b)
    {
        if (Math.abs(a.calculateDeterminant() - b.calculateDeterminant()) < 1e-9)
        {
            return 0;
        }

        return a.calculateDeterminant() < b.calculateDeterminant() ? -1 : 1;
    }
}
