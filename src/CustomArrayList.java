import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;


public class CustomArrayList<E> {
    private Object[] customArr = new Object[10];
    private int size;

    public void add(int index, E element) {

        if(customArr[index] != null) {
            Object[] customDestArrayList = new Object[customArr.length + 1];
            if (index < customArr.length && index > 0) {

                System.arraycopy(customArr, 0, customDestArrayList, 0, index);
                customDestArrayList[index] = element;
                System.arraycopy(customArr, index, customDestArrayList, index + 1, customArr.length - index);

                customArr = customDestArrayList;
                size++;

            } else {
                throw new RuntimeException("IndexOutOfBoundsException");
            }
        } else {
            customArr[index] = element;
            size++;
        }
    }

    @Override
    public String toString() {
        return "СustomArrayList{" +
                "customArr=" + Arrays.toString(customArr) +
                '}';
    }


    public void clear() {
        for(int i = 0; i < customArr.length; i++) {
            customArr[i] = null;
        }
        size = 0;
    }

    public E get(int index) {
        if(customArr[index] != null) {
           return (E)customArr[index];
        }
        return null;
    }

    public boolean isEmpty() {
        if(size == 0) {
            return true;
        }
        return false;
    }

    public boolean remove(int index) {
        Object[] customDestArrayList = new Object[customArr.length - 1];
            if(customArr[index] != null) {

                System.arraycopy(customArr, 0, customDestArrayList, 0, index);
                System.arraycopy(customArr, index + 1, customDestArrayList, index, customArr.length - 1 - index);

                customArr = customDestArrayList;
                --size;
                return true;
            }
        return false;
    }


    public boolean remove(Object o) {
        for(int i = 0; i < customArr.length; i++) {
            if(o == null) {
                return false;
            } else {
                if(o.equals(customArr[i])) {
                    remove(i);
                    --size;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean addAll(Collection<? extends E> c) {
        Object[] arrObjects = c.toArray();
        if (arrObjects.length == 0) {
            return false;
        }

        Object[] customArr = this.customArr;
        Object[] interArr = new Object[customArr.length + arrObjects.length];

        System.arraycopy(customArr, 0, interArr, 0, customArr.length);
        System.arraycopy(arrObjects, 0, interArr, size, arrObjects.length);
        this.customArr = interArr;

        return true;
    }


    public void sort(Comparator<? super E> c) {
        quickSort(c, customArr, 0, size - 1);
    }

    public void quickSort(Comparator<? super E> c, Object[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(c, arr, low, high);
            quickSort(c, arr, low, pi - 1);
            quickSort(c, arr, pi + 1, high);
        }
    }

    private int partition(Comparator<? super E> c, Object[] arr, int low, int high) {
        Object pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (c.compare((E)arr[j], (E)pivot) < 0 ) {
                i++;
                Object temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        Object temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}
