/**
 * Created by 路航 on 2017/7/23 0023.
 */
import java.util.Random;
import java.util.Scanner;
/*
 猜数字小游戏
*/

public class caishu {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = (int) (Math.random() * 101);
        // 产生随机数并强制转为int型号
        int user;// 用户猜的数字
        int sum = 0;// 猜测次数
        System.out.println("开始游戏吧！我有一个0到100的整数，看你几次能猜到？你可以输入“321”来中途退出游戏");
        // 用do while 和if else if嵌套猜测随机数
        do {
            user = input.nextInt();
            if (user==321){
                System.out.println("游戏退出");
                break;
            }
            else if (number < user) {
                System.out.println("大了，再来一次吧");
                sum++;
            }
            else if (number > user) {
                System.out.println("小了，再来一次吧");
                sum++;
            }
            else {
                sum++;
                break;
            }
        } while (true);
        System.out.println("这个数是"+number);
        System.out.println("你猜了"+sum+"次");
        // 由猜测次数给出评价
        if (sum == 1 && user!=321) {
            System.out.println("666牛逼");
        }
        else if (sum >= 2 && sum <= 4 && user!=321) {
            System.out.println("还是很厉害了");
        }
        else {
            System.out.println("要加油啊！");
        }
    }
}
