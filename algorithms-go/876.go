package main

func middleNode(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}
	fastPoint, slowPoint := head, head
	for fastPoint != nil && fastPoint.Next != nil {
		slowPoint = slowPoint.Next
		fastPoint = fastPoint.Next.Next
	}
	return slowPoint
}

func main() {

}
