package main

import (
	"fmt"
	"strconv"
	"strings"
)

type ListNode1 struct {
	Val  int
	Next *ListNode1
}

func (l *ListNode1) String() string {
	cur := l
	var result []string
	for cur != nil {
		result = append(result, strconv.Itoa(l.Val))
		cur = cur.Next
	}
	return strings.Join(result, " -> ")
}

func deleteDuplicates(head *ListNode1) *ListNode1 {
	var (
		dummyNode = &ListNode1{Val: 0, Next: head}
		curNode   = dummyNode
	)
	for curNode.Next != nil && curNode.Next.Next != nil {
		val := curNode.Next.Val
		if val == curNode.Next.Next.Val {
			for curNode.Next != nil && curNode.Next.Val == val {
				curNode.Next = curNode.Next.Next
			}
		} else {
			curNode = curNode.Next
		}
	}

	return dummyNode.Next
}

func main() {
	arrays := []int{1, 2, 3, 3, 3, 4, 4, 5}
	head := &ListNode1{}
	curNode := head
	for _, value := range arrays {
		curNode.Next = &ListNode1{Val: value}
		curNode = curNode.Next
	}

	duplicates := deleteDuplicates(head.Next)
	fmt.Println(duplicates)

}
