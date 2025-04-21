package main

import "fmt"

func removeElements(head *ListNode, val int) *ListNode {
	dumbNode := &ListNode{-1, head}
	for curNode := dumbNode; curNode.Next != nil; {
		if curNode.Next.Val == val {
			curNode.Next = curNode.Next.Next
		} else {
			curNode = curNode.Next
		}
	}
	return dumbNode.Next
}

func main() {
	var a int = 1
	fmt.Println(a)
}
