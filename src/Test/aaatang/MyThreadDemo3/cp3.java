package Test.aaatang.MyThreadDemo3;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * Created by Administrator on 2020/2/20 0020.
 */
public class cp3 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ArrayList<Integer> arr =new ArrayList<>();
//        arr.add(21);
//        arr.add(223);
//        arr.add(32);
        Class<? extends ArrayList> c = arr.getClass();
        Method add = c.getMethod("add", Object.class);
        add.invoke(arr,"Hello");
        add.invoke(arr,"World");
        add.invoke(arr,"Java");

        System.out.println(arr);

    }
}