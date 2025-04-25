package main

import "fmt"

func largestRectangleArea(heights []int) int {
	res := 0
	stack := make([]int, 0)
	// 在原切片前后追加一个 0 作为哨兵元素
	heights = append([]int{0}, heights...)
	heights = append(heights, 0)
	for i, val := range heights {
		for len(stack) > 0 && val < heights[stack[len(stack)-1]] {
			cur := stack[len(stack)-1]   // 栈的 peek 操作
			stack = stack[:len(stack)-1] //弹出栈顶元素
			curHeight := heights[cur]    //当前要计算的矩形的高

			leftIndex := stack[len(stack)-1] // 栈的 peek 操作

			rectAngleArea := (i - leftIndex - 1) * curHeight
			res = max(res, rectAngleArea)
		}
		stack = append(stack, i)
	}

	return res
}

func main() {
	heights := []int{2, 1, 5, 6, 2, 3}
	area := largestRectangleArea(heights)
	fmt.Println(area)

}
