package main

import "fmt"

func moveZeros(nums []int) {
	slowPointer := 0
	for i := 0; i < len(nums); i++ {
		if nums[i] != 0 {
			nums[slowPointer] = nums[i]
			slowPointer++
		}
	}
	for i := slowPointer; i < len(nums); i++ {
		nums[i] = 0
	}
}

func moveZeros2(nums []int) {
	left, right := 0, 0
	for i := 0; i < len(nums); i++ {
		if nums[right] != 0 {
			// 交换左右指针的值
			nums[left], nums[right] = nums[right], nums[left]
			//左指针向前推进 1
			left++
		}
		// 右指针向前推进 1
		right++
	}
}

func main() {
	nums := []int{0, 1, 0, 3, 12}
	moveZeros2(nums)
	fmt.Println(nums)
}
