public class demo {
    public static void main(String[] args) {

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

    }
}
