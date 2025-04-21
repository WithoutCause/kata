package main

import "fmt"

func getIntersectionNode(headA, headB *ListNode) *ListNode {
	if headA == nil || headB == nil {
		return nil
	}
	pointA, pointB := headA, headB
	for pointA != pointB {
		if pointA != nil {
			pointA = pointA.Next
		} else {
			pointA = headB
		}

		if pointB != nil {
			pointB = pointB.Next
		} else {
			pointB = headA
		}
	}
	return pointA
}

func main() {
	commonNode1 := &ListNode{5, nil}
	commonNode2 := &ListNode{4, commonNode1}
	commonNode3 := &ListNode{8, commonNode2}

	headA4 := &ListNode{1, commonNode3}
	headA5 := &ListNode{4, headA4}

	headB4 := &ListNode{1, commonNode3}
	headB5 := &ListNode{6, headB4}
	headB6 := &ListNode{5, headB5}

	pairs := getIntersectionNode(headA5, headB6)
	fmt.Print(pairs)
}
