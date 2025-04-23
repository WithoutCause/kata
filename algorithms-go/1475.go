package main

import "fmt"

func finalPrices(prices []int) []int {
	res := make([]int, len(prices))
	for i, val := range prices {
		price := val
		for j := i + 1; j < len(prices); j++ {
			if prices[j] <= price {
				price = price - prices[j]
				break
			}
		}
		res[i] = price
	}
	return res
}

func main() {
	prices := []int{8, 4, 6, 2, 3}
	ints := finalPrices(prices)
	fmt.Println(ints)
}
