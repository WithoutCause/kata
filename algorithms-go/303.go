package main

import "fmt"

type NumArray struct {
	nums []int
}

func Constructor303(nums []int) NumArray {
	return NumArray{nums: nums}
}

func (this *NumArray) SumRange(left int, right int) int {
	sum := 0
	for i := left; i <= right; i++ {
		sum += this.nums[i]
	}
	return sum
}

func main() {
	nums := []int{-2, 0, 3, -5, 2, -1}

	numArray := Constructor303(nums)
	res := numArray.SumRange(0, 2)
	fmt.Println(res)
	res = numArray.SumRange(2, 5)
	fmt.Println(res)
	res = numArray.SumRange(0, 5)
	fmt.Println(res)
}
