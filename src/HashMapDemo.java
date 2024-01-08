import java.util.*;

public class HashMapDemo {

    public static void main(String[] args) {
        HashMap h1 = new HashMap();
        h1.put("name","xialuo");
        h1.put("age",18);
        h1.put("hobby","男");
        System.out.println(h1);

        // 特定数据类型  字符串
        HashMap<String,String> h2 = new HashMap<String,String>();
        h2.put("name","xialuo");
        h2.put("age","18");
        h2.put("hobby","男");
        System.out.println(h2);

        // 声明 初始化值 
        HashMap<String,String> h3 = new HashMap<String,String>(){
            {
                put("name","xialuo");
                put("age","18");
                put("hobby","男");
            }
        };
        System.out.println(h3);
    }
}