package JingDianSuanFa;

import java.util.HashMap;
import java.util.Map;


/**
 * 腾讯 1.1-20的两个数把和告诉A，积告诉B，A说不知道是多少......
 * https://www.it610.com/article/1296129818278043648.htm
 */

public class AaddBandAmutiplyB1 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Map SumDatas = new HashMap<>();
        Map MulDatas = new HashMap<>();
        int tempsum;
        //和个数
        for (int i = 2; i <=100; i++) {
            for (int j = i ; j <=100; j++) {
                tempsum = i + j;
                if (SumDatas.containsKey(tempsum)) {
                    int parseInt = Integer.parseInt(String.valueOf(SumDatas.get(tempsum)));
                    SumDatas.put(tempsum, parseInt + 1);
                } else {
                    SumDatas.put(tempsum, 1);
                }
            }
        }
        //乘积个数
        for (int i = 2; i <=100; i++) {
            for (int j = i ; j <=100; j++) {
                tempsum = i * j;
                if (MulDatas.containsKey(tempsum)) {
                    int parseInt = Integer.parseInt(String.valueOf(MulDatas.get(tempsum)));
                    MulDatas.put(tempsum, parseInt + 1);
                } else {
                    MulDatas.put(tempsum, 1);
                }
            }
        }

        //B->A
        /*
         * A明白手中数的组合中当且仅有一对组合的积有多个组合
         * */
        int count1 = 0;
        for (Object key : SumDatas.keySet()) {
            int target = Integer.parseInt(String.valueOf(SumDatas.get(key)));
            int k = Integer.parseInt(String.valueOf(key));
            //A不知道
            if (target > 1) {
                for (int i = 2; i < k / 2 + 1; i++) {
                    if (k - i > i && k - i <= 100) {
                        int mul = (k - i) * i;
                        int m = Integer.parseInt(String.valueOf(MulDatas.get(mul)));
                        if (m > 1) {
                            count1++;
                        }
                    }
                }
                //因为A知道了，所以在A手中的数下面应当当且仅有一对组合数的积有多个组合
                if (count1 == 1) {
                    //找出为一对，他们的积有多个组合的那个
                    for (int i = 2; i < k / 2 + 1; i++) {
                        if (k - i > i && k - i <=100) {
                            int mul = (k - i) * i;
                            int m = Integer.parseInt(String.valueOf(MulDatas.get(mul)));
                            if (m > 1) {
                                System.out.println(i + "和" + (k - i));
                            }
                        }
                    }
                }
            }
            count1 = 0;
        }
    }
}

