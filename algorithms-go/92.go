package main

func reverseBetween(left, right int, head *ListNode) *ListNode {
	dummyNode := &ListNode{0, head}
	prevNode := dummyNode
	for i := 0; i < left-1; i++ {
		prevNode = prevNode.Next
	}

	currNode := prevNode.Next
	for i := 0; i < right-left; i++ {
		nextNode := currNode.Next

		currNode.Next = nextNode.Next
		nextNode.Next = prevNode.Next
		prevNode.Next = nextNode
	}

	return dummyNode.Next
}

func main() {

}
