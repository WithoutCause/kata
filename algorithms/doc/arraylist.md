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