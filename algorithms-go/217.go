package main

import "fmt"

func containsDuplicate(nums []int) bool {
	set := map[int]struct{}{}

	for _, val := range nums {
		if _, exist := set[val]; exist {
			return true
		}
		set[val] = struct{}{}
	}
	return false
}

func main() {
	nums := []int{1, 2, 2, 1}
	res := containsDuplicate(nums)
	fmt.Println(res)

}
