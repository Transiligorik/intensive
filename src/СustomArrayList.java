import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collection;

public class СustomArrayList<E> {
    Object[] customArr = new Object[10];

    public void add(int index, E element) {

        if(customArr[index] != null) {
            Object[] customDestArrayList = new Object[customArr.length + 1];
            if (index < customArr.length && index > 0) {
                System.arraycopy(customArr, 0, customDestArrayList, 0, index);
                customDestArrayList[index] = element;
                System.arraycopy(customArr, index, customDestArrayList, index + 1, customArr.length - index);
                customArr = customDestArrayList;
            } else {
                throw new RuntimeException("IndexOutOfBoundsException");
            }
        } else {
            customArr[index] = element;
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
    }

    public E get(int index) {
        if(customArr[index] != null) {
           return (E)customArr[index];
        }
        return null;
    }

    public boolean isEmpty() {
        int count = 0;
        for(int i = 0; i < customArr.length; i++) {
            if(customArr[i] != null) {
                count++;
            }
        }
        if(count > 0) {
            return false;
        }
        return true;
    }

    public boolean remove(int index) {
        Object[] customDestArrayList = new Object[customArr.length - 1];
            if(customArr[index] != null) {
                System.arraycopy(customArr, 0, customDestArrayList, 0, index);

                System.arraycopy(customArr, index + 1, customDestArrayList, index, customArr.length - 1 - index);
                System.out.println(customDestArrayList);
                System.out.println("true");
                customArr = customDestArrayList;
                return true;
            }

        System.out.println("false");
        return false;
    }


    public boolean remove(Object o) {
        Object[] customDestArrayList = new Object[customArr.length - 1];
        for(int i = 0; i < customArr.length; i++) {
            if(o == null) {
                System.out.println("false");
                return false;
            } else {
                if(o.equals(customArr[i])) {
                    remove(i);
                    return true;
                }
            }
        }
        System.out.println("false");
        return false;
    }

    public boolean addAll(Collection<? extends E> c) {
        Object[] arrObj = c.toArray();
        if(arrObj.length == 0) {
            return false;
        }
        Object[] newArr = new Object[customArr.length + arrObj.length];

    }
}
