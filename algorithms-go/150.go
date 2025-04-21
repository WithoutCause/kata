package main

import "strconv"

func evalRPN(tokens []string) int {
	// 用一个切片来模拟实现 stack
	opList := [4]string{"+", "-", "*", "/"}
	stack := make([]int, 0)

	for _, token := range tokens {
		if contains(opList, token) {
			num2 := stack[len(stack)-1]
			num1 := stack[len(stack)-2]
			stack = stack[:len(stack)-2]
			var result int
			switch token {
			case "+":
				result = num1 + num2
			case "-":
				result = num1 - num2
			case "*":
				result = num1 * num2
			case "/":
				result = num1 / num2
			}
			stack = append(stack, result)
		} else {
			num, _ := strconv.Atoi(token)
			stack = append(stack, num)
		}
		switch token {
		case "+":

		}
	}
	return stack[0]
}

func contains(opList [4]string, op string) bool {
	for _, value := range opList {
		if value == op {
			return true
		}
	}
	return false
}

func main() {
	tokens := []string{"4", "13", "5", "/", "+"}
	rpn := evalRPN(tokens)
	println(rpn)
}
