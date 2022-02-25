public interface IMatrix
{
    double getElement(int i, int j);
    void setElement(int i, int j, double elem) throws IllegalArgumentException;
    double calculateDeterminant();
}
