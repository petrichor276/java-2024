class Persons {

    // 实例变量
    public String name;
    public Integer age;
    public String email;

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

public class Person {

    public static void main(String[] args) {

        // 实例化对象时，体现的主要是封装。
        Persons p1 = new Persons();
        Persons p2 = new Persons("xialuo", 73);
        Persons p3 = new Persons("tony", "xialuo@xxx.com");

        p1.doSomething();
        p1.doSomething("你好呀，");

        p2.doSomething();
        p2.doSomething("你好呀，");

        p3.doSomething();
        p3.doSomething("你好呀，");
    }
}