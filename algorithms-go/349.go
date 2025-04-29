package main

import "fmt"

type none = struct{}
type set = map[int]none

func intersection(nums1 []int, nums2 []int) []int {
	s1 := make(set, len(nums1))
	for _, val := range nums1 {
		s1[val] = none{}
	}

	s2 := make(set, len(nums2))
	for _, val := range nums2 {
		s2[val] = none{}
	}

	var iterS1, iterS2 set = nil, nil
	if len(s1) > len(s2) {
		iterS1, iterS2 = s1, s2
	} else {
		iterS1, iterS2 = s2, s1
	}

	res := make([]int, 0)
	for key := range iterS1 {
		if _, exist := iterS2[key]; exist {
			res = append(res, key)
		}
	}

	return res
}

func main() {
	//nums1 := []int{1, 2, 2, 1}
	//nums2 := []int{2, 2}
	nums1 := []int{4, 9, 5}
	nums2 := []int{9, 4, 9, 8, 4}
	res := intersection(nums1, nums2)
	fmt.Println(res)
}
