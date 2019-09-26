package array;

public class SArrayList<E> {

    private Object[] object;

    private int DEFAULT_SIZE = 8;

    /**
     * 计数
     */
    private int size;

    public SArrayList(){
        object = new Object[DEFAULT_SIZE];
    }

    public SArrayList(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("size 必须大于 0");
        }
        object = new Object[size];
    }

    /**
     * 添加元素前要先检查数组的容量是否足够
     * 够的话，直接在 size 的位置放置元素
     * 如果不够的话，需要进行括容。每个括容为原来的 1.5 倍 + 1(此处参考 ArrayList 的原理)
     * @param e
     */
    void add(E e) {

    }

}
