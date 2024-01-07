import java.io.UnsupportedEncodingException;
import java.util.Arrays;


public class demo {
    public static void main(String[] args) throws UnsupportedEncodingException {

        //while循环
        int count = 0;
        while (count < 3) {
            System.out.println("执行中...");
            count += 1;
        }

        int count1 = 0;
        do {
            System.out.println("执行中...");
            count1 += 1;
        } while (count1 < 3);

        //for循环
        // i++ 先赋值在运算
        //++i 先运算在赋值
        for (int i = 0; i < 10; i++) {
            System.out.println("哈哈哈");
        }

        String[] nameList = {"苏苏", "菲菲", "莹莹", "丽丽"};
        // nameList.length   4
        // nameList[0]
        //for (int idx = 0; idx < nameList.length; idx++){
        //            String ele = nameList[idx];
        //            System.out.println(ele);
        //        }
        for (String ele : nameList) {
            System.out.println(ele);
        }

        String[] nameList1 = {"莉莉", "菲菲", "莹莹", "丽丽"};
        for (int idx = 0; idx < nameList.length; idx++) {
            String ele = nameList1[idx];
            if (ele == "莹莹"){
                break;
            }
            System.out.println(ele);
        }


        byte[] dataList = {97, 105, 100, 61, 50, 52, 54, 51, 56, 55, 53, 55, 49, 38, 97, 117, 116, 111, 95, 112, 108, 97, 121, 61, 48, 38, 99, 105, 100, 61, 50, 56, 57, 48, 48, 56, 52, 52, 49, 38, 100, 105, 100, 61, 75, 82, 69, 104, 69, 83, 77, 85, 74, 104, 56, 116, 70, 67, 69, 86, 97, 82, 86, 112, 69, 50, 116, 97, 80, 81, 107, 55, 87, 67, 104, 67, 74, 103, 38, 101, 112, 105, 100, 61, 48, 38, 102, 116, 105, 109, 101, 61, 49, 54, 50, 55, 49, 48, 48, 57, 51, 55, 38, 108, 118, 61, 48, 38, 109, 105, 100, 61, 48, 38, 112, 97, 114, 116, 61, 49, 38, 115, 105, 100, 61, 48, 38, 115, 116, 105, 109, 101, 61, 49, 54, 50, 55, 49, 48, 52, 51, 55, 50, 38, 115, 117, 98, 95, 116, 121, 112, 101, 61, 48, 38, 116, 121, 112, 101, 61, 51};
        String dataString = new String(dataList);
        System.out.println("字符串是：" + dataString);

        // 2.字符串->字节数组
        try {
            /*
            Python中的  name.encode("gbk")
            string = "夏洛"
            byte_list = list(string.encode("gbk"))
            signed_byte_list = [byte if byte < 128 else byte - 256 for byte in byte_list]
            print(signed_byte_list)
            */

            String name = "夏洛";
            byte[] v1 = name.getBytes("GBK");
            System.out.println(Arrays.toString(v1)); //[-49, -60, -62, -27]

            // Python中的  name.encode("utf-8")
            byte[] v2 = name.getBytes("UTF-8");
            System.out.println(Arrays.toString(v2)); // [-27, -92, -113, -26, -76, -101]
        } catch (Exception e) {
        }

        String v1 = "夏洛";
        // 用构造函数创建字符串：
        String x2 = new String("夏洛");
        String x4 = new String(new byte[]{-27, -92, -113, -26, -76, -101});
        String x5 = new String(new byte[]{-49, -60, -62, -27}, "GBK");
        String x6 = new String(new char[]{'夏', '洛'}) ;
        System.out.println(x2);
        System.out.println(x4);
        System.out.println(x5);
        System.out.println(x6);

        String origin = "请叫我靓仔AA";

        int len = origin.length();  // 长度
        for (int i = 0; i < len; i++) {
            char item = origin.charAt(i);
        }

        String v2 = origin.trim(); // 去除空白
        String v3 = origin.toLowerCase(); // 小写
        String v4 = origin.toUpperCase(); // 大写
        String[] v5 = origin.split("我"); // 分割
        String v6 = origin.replace("叫", "喊"); // 替换

        String v7 = origin.substring(2, 6);  // 子字符串=切片 [2:6]
        // equals() 方法用于判断 Number 对象与方法的参数进是否相等
        boolean v8 = origin.equals("请叫我"); //
        // contains() 方法用于判断字符串中是否包含指定的字符或字符串。
        boolean v9 = origin.contains("el");
        // startsWith() 方法用于检测字符串是否以指定的前缀开始。
        boolean v10 = origin.startsWith("请");
        // concat() 方法用于将指定的字符串参数连接到字符串上。
        String v11 = origin.concat("哈哈哈");

        // "name=alex&age=18"
        StringBuilder sb = new StringBuilder();  // StringBuffer线程安全
        sb.append("name");
        sb.append("=");
        sb.append("xialuo");
        sb.append("&");
        sb.append("age");
        sb.append("=");
        sb.append("18");
        String dataStrings = sb.toString();
        System.out.println(dataStrings);

        // [123,1,999]
        int[] numArray = new int[3];
        numArray[0] = 123;
        numArray[1] = 1;
        numArray[2] = 99;
        System.out.println(Arrays.toString(numArray));

        // 同时定义和初始化数组
        String[] names = new String[]{"夏洛", "aa", "bb"};
        System.out.println(Arrays.toString(names));

        String[] nameArray = {"夏洛", "aa", "bb"};
        System.out.println(Arrays.toString(nameArray));

        // nameArray[0]
        // nameArray.length
        for (int idx = 0; idx < nameArray.length; idx++) {
            String item = nameArray[idx];
        }

        Object y1 = new String("xialuo");
        System.out.println(y1);
        System.out.println(y1.getClass());

        Object y2 = 123;
        System.out.println(y2);
        System.out.println(y2.getClass());

        // 声明数组，数组中元素必须int类型;
        int[] a1 = new int[3];

        // 声明数组，数组中元素必须String类型;
        String[] a2 = new String[3];

        // 声明数组，数组中可以是数组中存储任何类型的对象
        Object[] a3 = new Object[3];
        a3[0] = 123;
        a3[1] = "xialuo";
        System.out.println(Arrays.toString(a3));


    }
}
