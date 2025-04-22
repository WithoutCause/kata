package main

func deleteDuplicates2(head *ListNode) *ListNode {
	if head == nil {
		return nil
	}
	curNode := head
	for curNode.Next != nil {
		if curNode.Val == curNode.Next.Val {
			curNode.Next = curNode.Next.Next
		} else {
			curNode = curNode.Next
		}
	}
	return head
}

func main() {

}
