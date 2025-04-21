package main

import "fmt"

func isValid(s string) bool {
	if len(s)%2 == 1 {
		return false
	}
	pairs := map[byte]byte{
		')': '(',
		']': '[',
		'}': '{',
	}

	var stack []byte
	for i := 0; i < len(s); i++ {
		c := s[i]
		b := pairs[c]
		if b == 0 { // 说明不是闭合的符合，是 ( [ { 中的一种，压入栈中
			stack = append(stack, c)
		} else {
			// 切片操作，把倒数的那个取出来
			if len(stack) == 0 || stack[len(stack)-1] != pairs[s[i]] {
				return false
			}
			stack = stack[:len(stack)-1] // 新的 stack 取值为原来的 0 到 倒数第 2 个
		}
	}

	return len(stack) == 0
}

func main() {
	result := isValid("(()")
	fmt.Println(result)

}
