package main

import "fmt"

func firstUniqChar(s string) int {
	// 使用 map, key -> s的单个字符, value -> 出现次数
	charMap := make(map[int32]int)
	for _, e := range s {
		charMap[e] = charMap[e] + 1
	}

	for i, c := range s {
		if charMap[c] == 1 {
			return i
		}
	}
	return -1
}

func main() {
	s := "loveleetcode"
	count := firstUniqChar(s)
	fmt.Println(count)
}
