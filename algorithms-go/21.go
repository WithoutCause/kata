package main

func mergeTwoLists(list1, list2 *ListNode) *ListNode {
	dummyNode := &ListNode{}
	curNode := dummyNode
	for list1 != nil && list2 != nil {
		if list1.Val <= list2.Val {
			curNode.Next = list1
			list1 = list1.Next
		} else {
			curNode.Next = list2
			list2 = list2.Next
		}
		curNode = curNode.Next
	}
	if list1 == nil {
		curNode.Next = list2
	} else {
		curNode.Next = list1
	}
	return dummyNode.Next
}

func main() {

}
