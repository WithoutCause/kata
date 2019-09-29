package array;

import java.util.Collection;
import java.util.Comparator;
import java.util.Objects;

public class SArrayList<E> implements SList<E> {

    private int size;

    private Object[] datas;

    private int defaultSize = 8;

    public SArrayList() {
        datas = new Object[defaultSize];
    }

    public SArrayList(int size) {
        datas = new Object[size];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (Objects.isNull(datas)) {
            return true;
        }
        return datas.length <= 0;
    }

    @Override
    public boolean contains(Object o) {
        if (Objects.isNull(o)) {
            throw  new IllegalArgumentException("参数错误");
        }
        for (Object data : datas) {
            if (data.equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean add(E e) {
        // 检查容量，如果容量不够的话，就要启动扩容。
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public void sort(Comparator<? super E> c) {
        // 实现比较器的接口，默认按照升序进行排列
    }

    @Override
    public void clear() {
        for (int i = 0; i < datas.length; i++) {
            datas[i] = null;
        }
    }

    @Override
    public E get(int index) {
        if (Objects.isNull(datas)) {
            throw new ArrayIndexOutOfBoundsException("必须指定要获取的位置");
        }
        if (index < 0) {
            throw new ArrayIndexOutOfBoundsException("下标不能为负数");
        }
        if (index > size) {
            throw new ArrayIndexOutOfBoundsException("下标大于数组长度");
        }
        return (E) datas[index];
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public void add(int index, E element) {

    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }
}
