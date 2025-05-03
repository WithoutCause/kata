package main

import (
	"fmt"
)

/*
给定两个字符串 s 和 t ，判断它们是否是同构的。

如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。

每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。

示例 1:

输入：s = "egg", t = "add"
输出：true
示例 2：

输入：s = "foo", t = "bar"
输出：false
示例 3：

输入：s = "paper", t = "title"
输出：true
*/
func isIsomorphic(s, t string) bool {
	sCharMap := make(map[int32]uint8) // key->字符s, value -> 字符 t
	tCharMap := make(map[int32]uint8)
	for i, c := range s {
		v, exist := sCharMap[c]
		tv, existT := tCharMap[int32(t[i])]
		if exist && v != t[i] || existT && tv != s[i] {
			return false
		}
		sCharMap[c] = t[i]
		tCharMap[int32(t[i])] = uint8(c)
	}
	return true
}

func main() {
	s := "badc"
	t := "baba"

	res := isIsomorphic(s, t)
	fmt.Println(res)

}
