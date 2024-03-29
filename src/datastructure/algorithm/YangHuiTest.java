package datastructure.algorithm;


import java.text.MessageFormat;

/**
 * Created by Administrator on 2021/3/30 0030.
 */
public class YangHuiTest {
    public static void main(String[] args) {
        //1.声明并初始化二维数组
        int[][] yanghui = new int[10][];
        //2.给数组的元素赋值
        for (int i = 0; i < yanghui.length; i++) {

            yanghui[i] = new int[i + 1];

            yanghui[i][0] = 1;
            yanghui[i][i] = 1;

            if (i > 1) {
                for (int j = 1; j < yanghui[i].length - 1; j++) {
                    yanghui[i][j] = yanghui[i - 1][j - 1] + yanghui[i - 1][j];
                }
            }

        }
        //3.遍历二位数组
        for (int[] ints : yanghui) {
            for (int anInt : ints) {
                System.out.print(MessageFormat.format("{0}", anInt));
            }
            System.out.println();
        }

    }
}
