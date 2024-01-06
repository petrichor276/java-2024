import java.util.Scanner;

class MyTest{

    public void f1(){
        System.out.println("f1");
    }

    public static void f2(){
        System.out.println("f2");
    }
}


public class hello {
    public static void main(String[] args) {
        //入口
        String aa ="hello world!";
        System.out.print(aa);
        //1.实例化
        MyTest obj = new MyTest();
        // 2.对象调用
        obj.f1();

        MyTest.f2();

        String name = "夏洛";
        name = "xialuo";
        char c1 = 'a';
        double d1 = 3.14;
        float f1 = 3.14f; // f 后缀可以明确指定为 float 类型
        long l1 = 100000L;
        short s1 = 100;
        final int size = 18;  // 常量  不能被修改

        // 输出
//        System.out.print("请输入：");

        // 输入
//        Scanner input = new Scanner(System.in);
//        String text = input.nextLine();
//
//        // 输出
//        System.out.println(text);
        // System.out.print(text);

//        int a = 10;
//        int b = 20;
//        int c = 25;
//        int d = 25;
//        System.out.println("a + b = " + (a + b) );
//        System.out.println("a - b = " + (a - b) );
//        System.out.println("a * b = " + (a * b) );
//        System.out.println("b / a = " + (b / a) );
//        System.out.println("b % a = " + (b % a) );
//        System.out.println("c % a = " + (c % a) );
//        System.out.println("a++   = " +  (a++) );
//        System.out.println("a--   = " +  (a--) );
//        // 查看  d++ 与 ++d 的不同
//        System.out.println("d++   = " +  (d++) );
//        System.out.println("++d   = " +  (++d) );

//        int a = 10;
//        int b = 20;
//        System.out.println("a == b = " + (a == b) );
//        System.out.println("a != b = " + (a != b) );
//        System.out.println("a > b = " + (a > b) );
//        System.out.println("a < b = " + (a < b) );
//        System.out.println("b >= a = " + (b >= a) );
//        System.out.println("b <= a = " + (b <= a) );

        //逻辑运算
//        boolean a = true;
//        boolean b = false;
//        System.out.println("a && b = " + (a&&b));
//        System.out.println("a || b = " + (a||b) );
//        System.out.println("!(a && b) = " + !(a && b));

        //条件运算符
        int a , b;
        a = 10;
        // 如果 a 等于 1 成立，则设置 b 为 20，否则为 30
        b = (a == 1) ? 20 : 30;
        System.out.println( "Value of b is : " +  b );

        // 如果 a 等于 10 成立，则设置 b 为 20，否则为 30
        b = (a == 10) ? 20 : 30;
        System.out.println( "Value of b is : " + b );

        //条件语句
        int num = 10;

        if (num > 0) {
            System.out.println("这个数是正数");
        } else {
            System.out.println("这个数不是正数");
        }

        int score = 85;

        if (score >= 90) {
            System.out.println("优秀");
        } else if (score >= 80) {
            System.out.println("良好");
        } else if (score >= 60) {
            System.out.println("及格");
        } else {
            System.out.println("不及格");
        }

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
    }
}



