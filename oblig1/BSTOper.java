public interface BSTOper{
    public void add(int value);
    public boolean remove(int value);
    public int size();
    public boolean existsInTree(int value);
    public int findNearestSmallerThan(int value);
    public void addAll(int[] integers);
    public int[] sortedArray();
    public int[] findInRange(int low, int high);

}