import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        //Scanner scan = new Scanner(System.in);
        //int n;
//        System.out.println("请输入您想要得到的题目个数：\n");
        //n = scan.nextInt();
        int n = Integer.parseInt(args[0]);
        GetExpression bTree;
        System.out.println("\n");
        File file = new File("result.txt");
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
            bw.write("2016012016" + "\r\n");
            for (int i = 0; i < n; i++) {
                bTree = new GetExpression(5);
                bTree.buildBTree();
                String result = bTree.CalAndVal();
                bw.write(bTree.toString() + "=" + result + "\r\n");
            }
            bw.close();
            System.out.println("文件创建成功！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

