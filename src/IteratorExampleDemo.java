import java.util.ArrayList;
import java.util.Iterator;

public class IteratorExampleDemo {
    public static void main(String[] args) {
        // 创建一个ArrayList集合
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");

        // 获取集合的迭代器
        Iterator<String> iterator = list.iterator();

        // 使用迭代器遍历集合元素
        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println(element);
        }
    }
}
