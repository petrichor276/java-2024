import java.util.LinkedList;

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<Integer> v1 = new LinkedList<Integer>();
        v1.add(11);
        v1.add(22);
        System.out.println(v1);


        LinkedList<Object> v2 = new LinkedList<Object>();
        v2.add("啦啦啦");
        v2.add("啊啊啊");
        v2.add(666);
        v2.add(123);
        System.out.println(v2);

        //v2.remove(1);
        //v2.remove("哈哈");

        v2.set(2, "略略略");
        v2.push("哈哈哈");
        v2.addFirst(11);


        for (int i = 0; i < v2.size(); i++) {
            Object item = v2.get(i);
            System.out.println(item);
        }

        for (Object item : v2) {
            System.out.println(item);
        }
    }
}
