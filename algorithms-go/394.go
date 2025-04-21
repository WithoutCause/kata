package main

func decodeString(s string) string {
	var (
		numStack    []int
		stringStack []string
		num         int
		res         string
	)

	for _, val := range s {
		if val >= '0' && val <= '9' {
			num = num*10 + int(val-'0')
		} else if val == '[' {
			numStack = append(numStack, num)
			stringStack = append(stringStack, res)
			num = 0
			res = ""
		} else if val == ']' {
			number := numStack[len(numStack)-1]
			numStack = numStack[:len(numStack)-1]

			temp := ""
			for i := 0; i < number; i++ {
				temp += res
			}

			token := stringStack[len(stringStack)-1]
			stringStack = stringStack[:len(stringStack)-1]
			res = token + temp
		} else if val >= 'a' && val <= 'z' {
			res += string(val)
		}
	}

	return res
}

func main() {
	t1 := decodeString("3[a]def2[bc]")
	println(t1)
}
