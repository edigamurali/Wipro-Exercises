var Stack = /** @class */ (function () {
    function Stack() {
        this.data = [];
    }
    Stack.prototype.push = function (item) {
        this.data.push(item);
    };
    Stack.prototype.pop = function () {
        return this.data.pop();
    };
    Stack.prototype.peek = function () {
        return this.data[this.data.length - 1];
    };
    return Stack;
}());
var stack = new Stack();
stack.push(10);
stack.push(20);
stack.push(30);
console.log(stack.peek());
console.log(stack.pop());
console.log(stack.pop());
console.log(stack.pop());
var stack2 = new Stack();
stack2.push("Murali");
stack2.push("Ram");
stack2.push("vinay");
console.log(stack2.peek());
console.log(stack2.pop());
