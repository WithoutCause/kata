package main

import "fmt"

func twoSum(nums []int, target int) []int {
	sumMap := make(map[int]int) // k -> nums 切片的值, value -> nums切片的索引
	for i, v := range nums {
		if _, exist := sumMap[target-v]; exist {
			return []int{sumMap[target-v], i}
		}
		sumMap[v] = i
	}
	return nil
}

func main() {

	nums := []int{2, 7, 11, 15}
	target := 9
	res := twoSum(nums, target)
	fmt.Println(res)

}
