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
        // 先检查容量是否够，如果够的话，直接添加。否则需要括容
        size++;
        if (!checkSize(size)) {
            ensure();
        }
        object[size] = e;

    }

    void remove(E e) {
        for (int i = 0; i < object.length; i++) {
            if (object[i].equals(e)) {
                // 将对应位置的元素置空
                object[i] = null;
                // 位置移动
                System.arraycopy(object, i+1, object, i, size - object.length + 1);
            }
        }
        size--;


    }

    private boolean checkSize(int size) {
        return object.length < size;
    }

    private void ensure() {
        // 括容， ArrayList 是  orignal + (orignal >> 1) 相当于是 1.5 倍。不过传入的是 size+1 , 所以应该是 1.5 倍 +1
        Object[] objects = new Object[size << 1];
        System.arraycopy(object,0, objects, 0, object.length);
    }

    public static void main(String[] args) {
        // 位置移动
        Object[] o1 = new Object[3];
        o1[1] = 1;
        o1[2] = 2;
        for (int i = 0; i < o1.length; i++) {
            if (o1[i] == null) {
                System.arraycopy(o1, i + 1, o1, i, o1.length - i - 1);
            }
        }
        o1[o1.length - 1] = null;
        for (Object o : o1) {
            System.out.println(o);
        }

    }

}
