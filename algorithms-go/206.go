package main

func reverseList(head *ListNode) *ListNode {
	var prevNode *ListNode = nil

	for curNode := head; curNode != nil; {
		nextNode := curNode.Next
		curNode.Next = prevNode
		prevNode, curNode = curNode, nextNode
	}

	return prevNode
}

func main() {

}
