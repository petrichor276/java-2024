public class ClallDemo {
    //成员变量
    String name;
    int age;
    //成员方法
    public void call() {
        System.out.println(name + "正在打电话");
    }
    public void message() {
        System.out.println(name + "今年" + age + "岁了");
    }

    public static void main(String[] args) {
        ClallDemo t = new ClallDemo();
        // 调用成员变量
        t.name = "小明";
        t.age = 18;
        // 调用成员方法
        t.call();
        t.message();
        // 若不需要对象名，也可以直接使用对象
        new ClallDemo().message();
    }

}