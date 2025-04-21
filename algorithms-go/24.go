package main

func SwapPairs(head *ListNode) *ListNode {
	dumbNode := &ListNode{0, head}
	tempNode := dumbNode
	for tempNode.Next != nil && tempNode.Next.Next != nil {
		node1 := tempNode.Next
		node2 := tempNode.Next.Next

		// 交换两个相领取节点
		tempNode.Next = node2
		node1.Next = node2.Next
		node2.Next = node1
		tempNode = node1
	}
	return dumbNode.Next
}

func main() {

}
