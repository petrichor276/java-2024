class Base {
    public String email;

    public Base(String email) {
        this.email = email;
    }

    public void getSubInfo() {
        System.out.println("111");
    }
}

// Person类继承Base类
class Person2 extends Base {

    public String name;

    public Person2(String name, Integer age, String email) {
        super(email);// 执行父类的构造方法
        this.name = name;
    }

    public void getSubInfo() {
        System.out.println("222");
    }
}

public class PersonExtend {

    public static void handler(Base v1){
        v1.getSubInfo();
    }

    // 主函数
    public static void main(String[] args) {
        Person2 obj1 = new Person2("xialuo",19,"xxx@live.com");
        handler(obj1); // 222

        Base obj2 = new Base("xialuo@live.com");
        handler(obj2); // 111

        Base obj3 = new Person2("xialuo",19,"xxx@live.com");
        handler(obj3); // 222
    }

}