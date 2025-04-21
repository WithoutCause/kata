package main

func calculate(s string) int {
	stack := []int{1}
	sign := 1 //符号位，遇到 - 号将该标志取反
	length := len(s)
	res := 0
	for i := 0; i < length; i++ {
		if s[i] == ' ' {
			i++
		} else if s[i] == '+' {
			sign = stack[len(stack)-1]
			i++
		} else if s[i] == '-' {
			sign = -stack[len(stack)-1]
			i++
		} else if s[i] == '(' {
			stack = append(stack, sign)
			i++
		} else if s[i] == ')' {
			stack = stack[:len(stack)-1]
			i++
		} else {
			num := 0
			for i < length && (s[i] >= '0' && s[i] <= '9') {
				num = num*10 + int(s[i]-'0')
				i++
			}
			res += num * sign
		}
	}

	return res
}

func main() {
	c1 := calculate("-(123+1)")
	println(c1)

}
