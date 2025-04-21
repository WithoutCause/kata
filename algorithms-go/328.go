package main

func oddEvenList(head *ListNode) *ListNode {
	// 定义 奇数节点、偶数节点、head 就是奇数的头节点，所以还需要把偶数的头节点记录下来
	oddNode := head
	if oddNode == nil {
		return head
	}

	evenNode := head.Next
	if evenNode == nil {
		return head
	}
	evenHeadNode := head.Next

	for evenNode != nil && evenNode.Next != nil {
		// 处理奇数节点，奇数节点的 Next 指向偶数节点的下一个，奇数节点指针再指向下一个节点
		oddNode.Next = evenNode.Next
		oddNode = oddNode.Next

		// 处理偶数节点，逻辑同奇数节点
		evenNode.Next = oddNode.Next
		evenNode = evenNode.Next
	}

	// 遍历完以后，再拼接奇数节点与偶数节点
	oddNode.Next = evenHeadNode
	return head
}

func main() {

}
