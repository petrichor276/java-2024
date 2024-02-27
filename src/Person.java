class Persons {

    // 实例变量
    public String name;
    public Integer age;
    public String email;
    private String count;

    // 构造方法1
    public Persons() {
        this.name = "xialuo";
        this.age = 99999;
    }

    // 构造方法2
    public Persons(String name, Integer age) {
        this.name = name;
        this.age = age;
        this.email = "xxx@live.com";
    }

    // 构造方法3
    public Persons(String name, String email) {
        this.name = name;
        this.age = 83;
        this.email = email;
    }

    // 定义方法（重载）
    public void doSomething() {
        System.out.println(this.name);
    }

    // 定义方法（重载）
    public void doSomething(String prev) {
        String text = String.format("%s-%s", prev, this.name);
        System.out.println(text);
    }

}
class Persons1 {

    // 静态变量
    public static String city = "北京";
    // 当一个变量被final修饰时，表示该变量的值不能被修改
    public final String color = "red";

    // 实例变量
    public String name;
    public Integer age;

    // 构造方法1
    public Persons1() {
        this.name = "xialuo";
        this.age = 99999;
    }

    // 绑定方法
    public void showInfo(){
        System.out.println("哈哈哈哈");
    }

    // 静态方法
    public static void showData(){
        System.out.println("哈哈哈哈");
    }
    // 实例方法
    public String showInfos(){
        return  "实例方法";
    }
    // 静态方法
    public static String showInfos1(){
        return  "hello world";
    }
}

public class Person {

//    public static void main(String[] args) {
//
//        // 实例化对象时，体现的主要是封装。
//        Persons p1 = new Persons();
//        Persons p2 = new Persons("xialuo", 73);
//        Persons p3 = new Persons("tony", "xialuo@xxx.com");
//
//        p1.doSomething();
//        p1.doSomething("你好呀，");
//
//        p2.doSomething();
//        p2.doSomething("你好呀，");
//
//        p3.doSomething();
//        p3.doSomething("你好呀，");
//    }
    public static void main(String[] args) {
        System.out.println(Persons1.city);
        Persons1.showData();
        Persons1 obj = new Persons1();
        System.out.println(obj.name);
        System.out.println(obj.age);
        obj.showInfo();
        obj.showInfos();
    }
}