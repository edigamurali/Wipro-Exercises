class Box<T> {
  value: T;

  constructor(value: T) {
    this.value = value;
  }

  getValue(): T {
    return this.value;
  }
}
let box1: Box<string> = new Box("Murali");
let box2: Box<number> = new Box(23);
console.log(box1.getValue());
console.log(box2.getValue());
