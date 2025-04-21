package main

import "fmt"

func findMaxConsecutiveOnes(nums []int) int {
	lastZero := -1
	result := 0
	for i := 0; i < len(nums); i++ {
		if nums[i] == 0 {
			lastZero = i
		} else {
			pos := i - lastZero
			if pos > result {
				result = pos
			}

		}
	}

	return result
}
func main() {
	nums := []int{0, 0, 1, 1, 1, 0}
	result := findMaxConsecutiveOnes(nums)
	fmt.Print(result)
}
