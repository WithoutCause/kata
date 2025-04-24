package main

import "fmt"

func dailyTemperatures(temperatures []int) []int {
	res := make([]int, len(temperatures))
	for i, val := range temperatures {
		for j := i + 1; j < len(temperatures); j++ {
			if temperatures[j] > val {
				res[i] = j - i
				break
			}
		}
	}
	return res
}

func dailyTemperatures2(temperatures []int) []int {
	res := make([]int, len(temperatures))
	stack := make([]int, 0)
	for i, val := range temperatures {

		for len(stack) > 0 && val > temperatures[stack[len(stack)-1]] {
			prevIndex := stack[len(stack)-1]
			res[prevIndex] = i - prevIndex
			stack = stack[:len(stack)-1]
		}
		stack = append(stack, i)
	}

	return res
}

func main() {
	//temperatures := []int{73, 74, 75, 71, 69, 72, 76, 73}
	//temperatures := []int{30, 40, 50, 60}
	//temperatures := []int{73, 74, 75, 71, 69, 72, 76, 73}
	//res := dailyTemperatures(temperatures)
	//fmt.Println(res)

	temperatures2 := []int{73, 74, 75, 71, 69, 72, 76, 73}
	res := dailyTemperatures2(temperatures2)
	fmt.Println(res)
}
