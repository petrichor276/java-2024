import org.jsoup.Jsoup;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class Doms {
    public static void text() {
        String html = "<head><title> hello world</title> </head>";
        Document doc = Jsoup.parse(html);
        System.out.println(doc);
        Elements title = doc.getElementsByTag("title");
        System.out.println(title.text());
    }

    public static void domTest(){
        try {
            File file = new File("D:\\java-2024\\src\\dom.html");
            Document doc = Jsoup.parse(file, "UTF-8");
            Elements li = doc.select("li");
//            System.out.println(li);
            // 缩小范围 附加类属性 .类 #ID
            Elements select = doc.select("li.thl");
//            System.out.println(select);
            Element head = doc.select("div#header").first();
//            System.out.println(head.text());
            Elements span = doc.select("span.state5");
            for (Element element : span) {
//                System.out.println(element.text());
            }
            System.out.println("==========属性(Attribute=============)");
            Elements select1 = doc.select("li.clear");
            Element element = select1.get(0);
            Element first = element.select("span.state3").first();
            Element a = first.select("a").first();
//            System.out.println(a.text());
            String href = a.attr("href");
//            System.out.println(href);
            Attributes attributes = a.attributes();
//            System.out.println(attributes);
            // 提取标签下 所有a标签里的href属性
            Elements select2 = doc.select("a[href^=/political]");
//            System.out.println(select2);
            Elements select3 = doc.select("span[class~=state]");
//            System.out.println(select3);
            System.out.println("==========遍历(Traversal)API=============");
            // 获取元素的父元素
            Element parentElement = element.parent();
//            System.out.println(parentElement);
            // 获取元素的下一个兄弟元素
            Element nextSiblingElement = element.nextElementSibling();
//            System.out.println(nextSiblingElement);

            // 获取元素的所有兄弟元素
            Elements siblingElements = element.siblingElements();
//            System.out.println(siblingElements);
            // 获取元素的所有子元素
            Elements childElements = element.children();
//            System.out.println(childElements);

            System.out.println("==========组合选择器=============");
            // 选择所有div元素内的p元素
            Elements paragraphs = doc.select("ul li");
//            System.out.println(paragraphs);
            // 选择所有直接子元素是div的p元素
            Elements directParagraphs = doc.select("li.clear > span.state1");
//            System.out.println(directParagraphs);


            System.out.println("==========综合练习=============");
            Elements select4 = doc.select("ul.title-state-ul li");
            for (Element li4: select4){
                String id = li4.select("span.state1").text();
                String title = li4.select("span.state3 > a").text();
                String text = li4.select("span.state4").text();
                String times = li4.select("span.state5").text();
                System.out.println(id + "," + title + "," + text + "," + times);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void dbSave(){
        String url = "jdbc:mysql://localhost:3306/db_java?serverTimezone=UTC";
        String username = "root";
        String password = "root";
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            String sql = "INSERT INTO thl (id, title, text, times) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "431179");
            preparedStatement.setString(2, "方便进还是不方便进");
            preparedStatement.setString(3, "等待回复：18天17小时14分");
            preparedStatement.setString(4, "2023-11-19 17:43:06");
            preparedStatement.executeUpdate();

            // 关闭数据库连接
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}


public class DomTest {
    public static void main(String[] args) {
//        Doms.domTest();
        Doms.dbSave();
    }
}
