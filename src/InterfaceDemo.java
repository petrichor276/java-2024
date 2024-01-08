interface IMessage {
    public void send();
}

// Wechat类"实现"了Imessage接口
class Wechat implements IMessage {
    public void send() {
        System.out.println("发送微信");
    }
}

class DingDing implements IMessage {
    public void send() {
        System.out.println("发送钉钉");
    }
}

class Sms implements IMessage {
    public void send() {
        System.out.println("发送短信");
    }
}

//IMessage v1 = new Wechat();

public class InterfaceDemo {
    public static void handler(IMessage v1){
        v1.send();
    }

    // 主函数
    public static void main(String[] args) {
        DingDing v1 = new DingDing();
        handler(v1);
    }
}