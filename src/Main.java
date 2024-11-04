import java.util.List;

public class Main {
    public static void main(String[] args) {
        CustomArrayList<String> arr = new CustomArrayList<>();
        List<String> arr1 = List.of("ko", "le", "bi");

        arr.add(0,"an");
        arr.add(1,"pn");
        arr.add(2,"in");
        arr.add(2,"en");
        arr.add(2,"qn");


        arr.remove("in");
        System.out.println(arr);

        arr.remove(3);
        System.out.println(arr);

        System.out.println(arr.get(1));

        System.out.println(arr.isEmpty());
        arr.clear();
        System.out.println(arr.isEmpty());

        arr.addAll(arr1);
        System.out.println(arr);

        arr.sort(String::compareTo);
        System.out.println(arr);

    }
}