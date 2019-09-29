# ArrayList
需要使用到的工具类
```java
System.arraycopy(Object src,  int  srcPos,Object dest, int destPos,int length);
// src: 源数组
// srcPos: 源数组的开始位置
// dest: 目录数组
// destPos: 目标数据的开始位置
// length: 拷贝长度
// 示例:
public class Test{
    public static void main(String[] args) {
        Object[] o = {1};
        Object[] o1 = new Object[2];
        System.arraycopy(o, 0, o1, 0, o.length);
        o1[1] = 2;
        for (Object o2 : o1) {
            System.out.println(o2);
        }
    }
}
```

## ArrayList 实现要求
1. 实现下列接口,其中包含主要的 CRUD 的方法，不包括 `Iterator` 方法
```java
public interface SList<E> {
    int size();
    boolean isEmpty();
    boolean contains(Object o);
    boolean add(E e);
    boolean addAll(Collection<? extends E> c);
    boolean addAll(int index, Collection<? extends E> c);
    boolean removeAll(Collection<?> c);
    void sort(Comparator<? super E> c);
    void clear();
    E get(int index);
    E set(int index, E element);
    void add(int index, E element);
    E remove(int index);
    int indexOf(Object o);
    int lastIndexOf(Object o);
    boolean equals(Object o);
    int hashCode();
}
```
