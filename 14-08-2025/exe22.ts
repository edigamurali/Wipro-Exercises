class Stack<T> {
  data: T[] = [];

  push(item: T): void {
    this.data.push(item);
  }

  pop(): T | undefined {
    return this.data.pop();
  }

  peek(): T | undefined {
    return this.data[this.data.length - 1];
  }
}

let stack = new Stack<number>();
stack.push(10);
stack.push(20);
stack.push(30);
console.log(stack.peek());
console.log(stack.pop());
console.log(stack.pop());
console.log(stack.pop());

let stack2 = new Stack<string>();
stack2.push("Murali");
stack2.push("Ram");
stack2.push("vinay");
console.log(stack2.peek());
console.log(stack2.pop());
