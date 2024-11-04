import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        СustomArrayList<String> arr = new СustomArrayList<>();
        arr.add(4,"4");
        arr.add(5,"5");
        arr.add(3,"in");

        System.out.println(arr);
        arr.remove("in");
//        System.out.println(arr);
//        arr.clear();
        System.out.println(arr);

//       arr.get(5);
//        System.out.println(arr.isEmpty());
    }
}