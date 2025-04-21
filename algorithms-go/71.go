package main

import (
	"fmt"
	"strings"
)

func simplifyPath(path string) string {
	paths := strings.Split(path, "/")
	var stack []string
	var res string
	for _, item := range paths {
		if item == ".." {
			if len(stack) != 0 {
				stack = stack[:len(stack)-1]
			}
		} else if len(item) != 0 && item != "." {
			stack = append(stack, item)
		}
	}

	if len(stack) == 0 {
		res = "/"
	} else {
		for len(stack) != 0 {
			res = "/" + stack[len(stack)-1] + res
			stack = stack[:len(stack)-1]
		}
	}

	return res
}

func main() {
	path := "/home//foo/"
	res := simplifyPath(path)
	fmt.Println(res)
}
