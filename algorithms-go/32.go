package main

import (
	"fmt"
)

/*
给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。

示例 1：
输入：s = "(()"
输出：2
解释：最长有效括号子串是 "()"

示例 2：
输入：s = ")()())"
输出：4
解释：最长有效括号子串是 "()()"

示例 3：
输入：s = ""
输出：0

提示：
0 <= s.length <= 3 * 104
s[i] 为 '(' 或 ')'
*/
func longestValidParentheses(s string) int {
	var stack []int
	start := 0 //记录有效括号的开始位置
	maxLength := 0
	for index, char := range s {
		if char == '(' {
			stack = append(stack, index)
		} else {
			if len(stack) == 0 {
				start = index + 1
			} else {
				stack = stack[:len(stack)-1]
				if len(stack) == 0 {
					maxLength = max(maxLength, index-start+1)
				} else {
					peek := stack[len(stack)-1]
					length := index - (peek + 1) + 1
					maxLength = max(maxLength, length)
				}
			}
		}
	}

	return maxLength
}

func main() {
	s := ")()())"
	res := longestValidParentheses(s)
	fmt.Println(res)
}
