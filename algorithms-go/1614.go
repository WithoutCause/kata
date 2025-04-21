package main

func maxDepth(s string) int {
	size, maxSize := 0, 0
	for _, c := range s {
		if c == '(' {
			size++
			maxSize = max(size, maxSize)
		} else if c == ')' {
			size--
		}
	}
	return maxSize
}

func main() {
	maxSize := maxDepth("(1+(2*3)+((8)/4))+1")
	println(maxSize)
}
