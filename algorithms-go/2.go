package main

func addTwoNumbers(list1, list2 *ListNode) *ListNode {
	var result, curNode *ListNode = nil, nil
	carry := 0
	for list1 != nil || list2 != nil {
		num1 := getVal(list1)
		num2 := getVal(list2)
		sum := num1 + num2 + carry
		carry = sum / 10
		if result == nil {
			result = &ListNode{Val: sum % 10}
			curNode = result
		} else {
			curNode.Next = &ListNode{Val: sum % 10}
			curNode = curNode.Next
		}

		if list1 != nil {
			list1 = list1.Next
		}

		if list2 != nil {
			list2 = list2.Next
		}
	}

	if carry > 0 {
		curNode.Next = &ListNode{Val: carry}
	}

	return result
}

func getVal(list *ListNode) (val int) {
	if list != nil {
		val = list.Val
	} else {
		val = 0
	}
	return
}

func main() {

}
