import implementations.ArrayListImplementation;
import implementations.HashSetImplementation;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        ArrayListImplementation<Integer> list = new ArrayListImplementation<>();
        for (int i = 0; i < 15; i++) {
            list.put(i);
        }
        list.delete(5);
        System.out.println(list);
        System.out.println(list.get(5));

        HashSetImplementation<Integer> set = new HashSetImplementation<>();
        for (int i = 0; i < 5; i++) {
            set.put(i);
        }
        set.iterate();
        System.out.println(set.contains(2));
        set.delete(2);
        System.out.println(set.contains(2));
        set.put(4);
        set.iterate();
        System.out.println(set);
    }
}