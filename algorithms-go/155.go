package main

type MinStack struct {
	val []int
}

func Constructor() MinStack {
	return MinStack{}
}

func (this *MinStack) Push(val int) {
	this.val = append(this.val, val)
}

func (this *MinStack) Pop() {
	this.val = this.val[:len(this.val)-1]
}

func (this *MinStack) Top() int {
	return this.val[len(this.val)-1]
}

func (this *MinStack) GetMin() int {
	var m = this.val[0]
	for _, item := range this.val {
		if item < m {
			m = item
		}
	}
	return m
}

/**
 * Your MinStack object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Push(val);
 * obj.Pop();
 * param_3 := obj.Top();
 * param_4 := obj.GetMin();
 */

func main() {

	obj := Constructor()
	obj.Push(-2)
	obj.Push(0)
	obj.Push(-3)
	obj.Pop()
	param_3 := obj.Top()
	println(param_3)
	param_4 := obj.GetMin()
	println(param_4)
}
