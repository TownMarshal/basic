package ItHeiMa.DuoTai.duotai2;

/**
 * Created by Administrator on 2020/2/14 0014.
 */
public class Cat extends Animal {
    @Override
    public void eat() {
        System.out.println("猫吃鱼");
    }

    public void playGame() {
        System.out.println("猫捉迷藏");
    }
}
