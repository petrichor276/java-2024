import java.util.ArrayList;

public class ListDemo {
    public static void main(String[] args) {

        // ArrayList，默认内部存放的是混合数据类型。

        // ArrayList<String> data = new ArrayList<String>();
        // ArrayList<Object> data = new ArrayList<Object>();

        ArrayList data = new ArrayList();
        data.add("夏洛");
        data.add("aa");
        data.add(666);
        data.add("貂蝉");

        String value = (String) data.get(1);
//        value.length;

         String value1 = (String) data.get(1);
        Object temp = data.get(1);
        String value2 = (String) temp; // 转化可转换的数据

        System.out.println(value1);

        int xo = (int) data.get(2);
        System.out.println(xo);

        //修改或替换
        data.set(0, "哈哈哈哈");
        System.out.println(data);

        data.remove("eric");
        data.remove(0);
        System.out.println(data);

        int size = data.size();
        System.out.println(size);

        boolean exists = data.contains("莹莹");
        System.out.println(exists);

        //清空数组
        //data.clear();

        for (Object item : data) {
            System.out.println(item);
        }

        for (int i = 0; i < data.size(); i++) {
            Object item = data.get(i);
            System.out.println(item);
        }
    }
}
