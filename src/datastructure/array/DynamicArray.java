package datastructure.array;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.stream.IntStream;

//动态数组
public class DynamicArray implements Iterable<Integer> {

    private int size = 0;//逻辑大小
    private int capacity = 8;//动态数组容量
    private int[] arr = {};
    /**
     * 向最后位置 [size] 添加元素
     *
     * @param element 待添加元素
     */
    public void addList(int element) {
//        arr[size] = element;
//        size++;
        add(size, element);

    }

    /**
     * 向 [0 .. size] 位置添加元素
     *
     * @param index   索引位置
     * @param element 待添加元素
     */
    public void add(int index, int element) {
        checkAndGrow();
        //添加逻辑
        if (index >= 0 && index < size) {
            System.arraycopy(arr, index, arr, index + 1, size - index);

        }
        arr[index] = element;
        size++;
    }

    private void checkAndGrow() {
        //容量检查
        if (size == 0) {
            arr = new int[capacity];
        } else if (size == capacity) {
            //进行扩容,1.5 1.618 2
            capacity += capacity >> 1;
            int[] newArr = new int[capacity];
            System.arraycopy(arr, 0, newArr, 0, size);
            arr = newArr;
        }
    }
    /**
     * 从 [0 .. size) 范围删除元素
     *
     * @param index 索引位置
     * @return 被删除元素
     */
    public int remove(int index) {
        int removed = arr[index];
        if (index < size - 1) {
            System.arraycopy(arr, index + 1, arr, index, size - index - 1);
        }
        size--;
        return removed;
    }

    public int get(int index) {
        return arr[index];
    }

    /**
     * 遍历方法1
     *
     * @param consumer 遍历要执行的操作, 入参: 每个元素
     */
    public void foreach(Consumer<Integer> consumer) {
        for (int i = 0; i < size; i++) {
//            System.out.println(arr[i]);
            consumer.accept(arr[i]);
        }
    }


    /**
     * 遍历方法2 - 迭代器遍历
     */
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int i = 0;

            @Override
            public boolean hasNext() {//有没有下一个元素
                return i < size;
            }

            @Override
            public Integer next() {//返回当前元素，并移动到下一个元素
                return arr[i++];
            }
        };
    }
    /**
     * 遍历方法3 - stream 遍历
     * @return stream 流
     */
    public IntStream stream() {
        return IntStream.of(Arrays.copyOfRange(arr, 0, size));
    }

    public static void main(String[] args) {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addList(1);
        dynamicArray.addList(2);
        dynamicArray.addList(3);
        dynamicArray.addList(4);
//        dynamicArray.addList(5);
        dynamicArray.add(2, 5);

        //foreach
        dynamicArray.foreach(System.out::println);
        //迭代器
        for (Integer element : dynamicArray) {
            System.out.println(element);
        }
        //stream流
        dynamicArray.stream().forEach(System.out::println);

        int removed = dynamicArray.remove(2);
        System.out.println(removed);
        dynamicArray.forEach(System.out::println);

    }
}
