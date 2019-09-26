package array;

//链表的数据结构
public class SLinkedList<E> {
    Node<E> node;
    public SLinkedList() {
        node = new Node<>(null, null);
    }

    // 链表提供的操作， CRUD

    /**
     * 在链表的尾部插入
     * @param element
     */
    void add(E element) {
        // 前面进行参数校验
        Node<E> eNode = new Node<>(element, null);
        this.node.next = eNode;
    }

    /**
     * 在指定位置插入
     * @param index 指定位置
     * @param element 插入元素
     */
    void insert(int index, E element) {
        int i = 0;
        Node next;
        for (; ; ) {
            i++;
            next = node.next;
            if (i == index) {
                next = new Node(element, node.next.next);
            }
        }
    }

    void remove(E element) {

    }

    class Node<E> {
        // 指针，指向下一个
        private Node next;
        E node;

        public Node(E node, Node next) {
            this.node = node;
        }
    }

}
