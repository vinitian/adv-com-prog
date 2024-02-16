package Task1;
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
    protected int[] v;
    protected FindMinMaxStrategy findMinMax;
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

    public boolean contains(int v) {
        for(int x: this.v) {
            if(x==v) return true;
        }
        return false;
    }
}

class SortedList extends PythonList {
    public SortedList(int[] v) {
        super(v);
        setFastMode();
    }

    public void append(int v) {
        int[] x = new int[this.v.length+1];
        int i = 0;
        while(v > this.v[i]) {
            x[i] = this.v[i];
            i++;
        }
        x[i++] = v;
        for(int j=i-1;j<this.v.length;j++) {
            x[i++] = this.v[j];
        }
        this.v=x;
    } 

    @Override
    public boolean contains(int v) {
        int left = 0;
        int right = this.v.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
   
            // If the middle element is equal to v, return true
            if (this.v[mid] == v) {
                return true;
            }
   
            // If v is less than the middle element, search in the left half
            if (this.v[mid] > v) {
                right = mid - 1;
            }
            // If v is greater than the middle element, search in the right half
            else {
                left = mid + 1;
            }
        }
   
        // If the loop finishes without finding v, return false
        return false;
    }

    public String toString() {
        if(this.v.length == 0) return "[]";
        String out = "[";
        for(int x:this.v) {
            out += x+", ";
        }
        out = out.substring(0,out.length()-2)+"]";
        return out;
    }

}

class UnsortedList extends PythonList {
    public UnsortedList(int[] v) {
        super(v);
    }

    public void append(int v) {
        int[] x = new int[this.v.length+1];
        for(int i=0;i<this.v.length;i++) {
            x[i] = this.v[i];
        }
        x[this.v.length]=v;
        this.v=x;
    }

    public String toString() {
        if(this.v.length == 0) return "[]";
        String out = "[";
        for(int x:this.v) {
            out += x+", ";
        }
        out = out.substring(0,out.length()-2)+"]";
        return out;
    }
}