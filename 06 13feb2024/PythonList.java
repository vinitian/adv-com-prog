import java.util.NoSuchElementException;

interface FindMinMaxStrategy {
    public int findMin(int[] a);
    public int findMax(int[] a);
}

class FindMinMaxSortedStrategy implements FindMinMaxStrategy {

    @Override
    public int findMin(int[] a) {
        if(a.length == 0) {
            throw new NoSuchElementException();
        }
        return a[0];
    }

    @Override
    public int findMax(int[] a) {
        if(a.length == 0) {
            throw new NoSuchElementException();
        }
        return a[a.length-1];
    }
}

class FindMinMaxUnsortedStrategy implements FindMinMaxStrategy {

    @Override // means that the function below will override the parent class's. not required but it is good practice/convention to write this esp if you work in a team
    public int findMin(int[] a) {
        if(a.length == 0) {
            throw new NoSuchElementException();
        }

        int min = a[0];
        for(int i = 0;i<a.length;i++) {
            if(a[i] < min) {
                min = a[i];
            }
        }
        return min;
    }

    @Override
    public int findMax(int[] a) {
        if(a.length == 0) {
            throw new NoSuchElementException();
        }

        int max = a[0];
        for(int e:a) {
            if(e > max) {
                max = e;
            }
        }
        return max;
    }

}

public class PythonList {
    private int[] v;
    private FindMinMaxStrategy findMinMax;
    public PythonList(int[] v) {
        //this.v = v; //in setFastMode(), after we sort the array, v will be changed too..
        this.v = new int[v.length];
        for(int i=0; i<v.length; i++) {
            this.v[i] = v[i];
        }
        //⬆️this will point to a new v
        this.findMinMax = new FindMinMaxUnsortedStrategy();
    }
    public int findMax() {
        return findMinMax.findMax(v);
    }
    public int findMin() {
        return findMinMax.findMin(v);
    }
    public void setNormalMode() {
        this.findMinMax = new FindMinMaxUnsortedStrategy(); // takes longer to compute
    }
    public void setFastMode() {

        // Selection Sort (mai tong jum gor dai)
        for(int lastIndex = v.length-1;lastIndex>=1;lastIndex--) {
            int maxIndex = 0;
            for(int i = 0; i<=lastIndex; i++) {
                if(v[i] > v[maxIndex]) {
                    maxIndex = i;
                }
            }
            int temp = v[maxIndex];
            v[maxIndex] = v[lastIndex];
            v[lastIndex] = temp;
        }
        this.findMinMax = new FindMinMaxSortedStrategy(); // takes less time to compute
    }
}
