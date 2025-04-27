package main

type MyCircularDeque struct {
	size    int
	element []int
}

func New(k int) MyCircularDeque {
	return MyCircularDeque{
		size: k,
	}
}

func (this *MyCircularDeque) InsertFront(value int) bool {
	if this.IsFull() {
		return false
	}
	this.element = append([]int{value}, this.element...)
	return true
}

func (this *MyCircularDeque) InsertLast(value int) bool {
	if this.IsFull() {
		return false
	}
	this.element = append(this.element, value)
	return true
}

func (this *MyCircularDeque) DeleteFront() bool {
	if this.IsEmpty() {
		return false
	}
	if len(this.element) == 1 {
		this.element = nil
	} else {
		this.element = this.element[1:len(this.element)]
	}
	return true
}

func (this *MyCircularDeque) DeleteLast() bool {
	if this.IsEmpty() {
		return false
	}
	if len(this.element) == 1 {
		this.element = nil
	} else {
		this.element = this.element[:len(this.element)-1]
	}
	return true
}

func (this *MyCircularDeque) GetFront() int {
	if this.IsEmpty() {
		return -1
	}
	return this.element[0]
}

func (this *MyCircularDeque) GetRear() int {
	if this.IsEmpty() {
		return -1
	}
	return this.element[len(this.element)-1]
}

func (this *MyCircularDeque) IsEmpty() bool {
	return len(this.element) <= 0
}

func (this *MyCircularDeque) IsFull() bool {
	return len(this.element) >= this.size
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * obj := Constructor(k);
 * param_1 := obj.InsertFront(value);
 * param_2 := obj.InsertLast(value);
 * param_3 := obj.DeleteFront();
 * param_4 := obj.DeleteLast();
 * param_5 := obj.GetFront();
 * param_6 := obj.GetRear();
 * param_7 := obj.IsEmpty();
 * param_8 := obj.IsFull();
 */

func main() {
	//["MyCircularDeque","insertLast","insertLast","insertLast","insertLast","deleteFront","deleteFront","deleteFront","insertLast","insertLast"]
	myCircularDeque := New(3)
	last := myCircularDeque.InsertLast(1)
	print(last, ",")
	last = myCircularDeque.InsertLast(2)
	print(last, ",")
	last = myCircularDeque.InsertLast(3)
	print(last, ",")
	last = myCircularDeque.InsertLast(4)
	print(last, ",")
	last = myCircularDeque.DeleteFront()
	print(last, ",")
	last = myCircularDeque.DeleteFront()
	print(last, ",")
	last = myCircularDeque.DeleteFront()
	print(last, ",")
	last = myCircularDeque.InsertLast(4)
	print(last, ",")
	last = myCircularDeque.InsertLast(6)
	print(last, ",")

}
