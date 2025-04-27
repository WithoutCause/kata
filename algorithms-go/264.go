package main

func nthUglyNumber(n int) int {
	res := make([]int, 0, n)
	res = append(res, 1) //第一个丑数是 1
	// 用 三个指针
	a, b, c := 0, 0, 0
	for i := 1; i < n; i++ {
		n2, n3, n5 := res[a]*2, res[b]*3, res[c]*5
		minNumber := min(n2, min(n3, n5))
		res = append(res, minNumber)
		if res[i] == n2 {
			a++
		}
		if res[i] == n3 {
			b++
		}
		if res[i] == n5 {
			c++
		}
	}

	return res[len(res)-1]
}

func main() {
	n := 10
	number := nthUglyNumber(n)
	print(number)
}
