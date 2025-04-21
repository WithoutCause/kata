package main

import "fmt"

/*
相邻两个元素比较
*/
func removeDuplicates(nums []int) (count int) {
	for i := 0; i < len(nums); i++ {
		if count == 0 || nums[i] != nums[i-1] {
			nums[count] = nums[i]
			count++
		}
	}
	return
}

func main() {
	nums := []int{1, 1, 2}
	count := removeDuplicates(nums)
	fmt.Println(count)
	fmt.Println(nums)
}
