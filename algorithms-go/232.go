package main

type MyQueue struct {
	inStack  []int
	outStack []int
}

func Constructor232() MyQueue {
	return MyQueue{
		inStack:  make([]int, 0),
		outStack: make([]int, 0),
	}
}

func (this *MyQueue) Push(x int) {
	this.inStack = append(this.inStack, x)
}

func (this *MyQueue) Pop() int {
	if len(this.outStack) == 0 {
		this.outStack = append(this.inStack)
		this.inStack = nil
	}
	peek := this.outStack[0]
	this.outStack = this.outStack[1:len(this.outStack)]
	return peek
}

func (this *MyQueue) Peek() int {
	if len(this.outStack) == 0 {
		this.outStack = append(this.inStack)
		this.inStack = nil
	}
	return this.outStack[0]
}

func (this *MyQueue) Empty() bool {
	return len(this.outStack) == 0 && len(this.inStack) == 0
}

func main() {
	//["MyQueue","push","push","push","push","pop","push","pop","pop","pop","pop"]
	// [[],[1],[2],[3],[4],[],[5],[],[],[],[]]
	myQueue := Constructor232()
	myQueue.Push(1)
	myQueue.Push(2)
	myQueue.Push(3)
	myQueue.Push(4)
	pop := myQueue.Pop()
	println(pop)
	myQueue.Push(5)
	pop1 := myQueue.Pop()
	println(pop1)
	pop2 := myQueue.Pop()
	println(pop2)
	pop3 := myQueue.Pop()
	println(pop3)
	pop4 := myQueue.Pop()
	println(pop4)
}
