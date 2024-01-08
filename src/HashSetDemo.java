import java.util.*;

public class HashSetDemo {

    public static void main(String[] args) {
        /*方式一："HashSet s1 = new HashSet();" 使用具体的HashSet类作为声明类型，创建一个HashSet对象。这种方式限定了变量s1的类型为HashSet，只能调用HashSet类特有的方法。
        方式二："Set s1 = new HashSet();" 使用Set接口作为声明类型，创建一个HashSet对象。这种方式使用了接口类型Set，可以调用Set接口中定义的所有方法，但无法直接调用HashSet类特有的方法。这种方式更加灵活，便于后续切换到其他实现Set接口的类，如TreeSet或LinkedHashSet。
        方式三："HashSet<String> s1 = new HashSet<String>();" 使用泛型来指定集合中元素的类型。这种方式将HashSet限定为存储String类型的元素，可以确保在编译时期进行类型检查，避免插入不合法的元素类型到集合中。
        */
        // HashSet s1 = new HashSet();
        // Set s1 = new HashSet();
        // HashSet<String> s1 = new HashSet<String>();
        HashSet s1 = new HashSet();
        s1.add("P站");
        s1.add("B站");
        s1.add("A站");
        s1.add("P站");
        s1.add(666);
        System.out.println(s1); // [B站, A站, P站,666]

        // s2 = {"东京热","东北热","南京热"}
        HashSet s2 = new HashSet() {
            {
                add("东京热");
                add("东北热");
                add("南京热");
            }
        };
        System.out.println(s2); // [B站, A站, P站]


        // Set s2 = new TreeSet();
        //TreeSet<String> s2 = new TreeSet<String>();
        TreeSet s3 = new TreeSet();
        s3.add("P站");
        s3.add("B站");
        s3.add("A站");
        s3.add("P站");
        // s3.add(666); //不可以

        System.out.println(s3); // [B站, A站, P站]

        TreeSet s4 = new TreeSet() {
            {
                add("P站");
                add("B站");
                add("A站");
                add("P站");
            }
        };
        System.out.println(s4); // [B站, A站, P站]

        boolean exists = s1.contains("B站");
        System.out.println(exists);

        HashSet v1 = new HashSet(); // 空
        v1.addAll(s1);
        v1.retainAll(s2); // 交集 &
        System.out.println(v1);


        HashSet v2 = new HashSet();
        v2.addAll(s1);
        v2.addAll(s2); // 并集 |
        System.out.println(v2);

        HashSet v3 = new HashSet();
        v3.addAll(s1);
        v3.removeAll(s2); // 差集 s1 - s2
        System.out.println(v3);


        HashSet v4 = new HashSet();
        v4.addAll(s2);
        v4.removeAll(s1); // 差集 s2 - s1
        System.out.println(v4);

    }
}