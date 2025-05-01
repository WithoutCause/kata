package main

import "fmt"

func containsNearbyDuplicate(nums []int, k int) bool {
	numMap := make(map[int]int)
	for i, v := range nums {
		if value, exist := numMap[v]; exist && i-value <= k {
			return true
		}
		numMap[v] = i
	}
	return false
}

func main() {
	nums := []int{1, 2, 3, 1, 2, 3}
	k := 2
	duplicate := containsNearbyDuplicate(nums, k)
	fmt.Println(duplicate)

}
