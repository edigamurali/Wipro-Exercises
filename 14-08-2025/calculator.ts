class Calculator {
  add(a: number, b: number): number {
    return a + b;
  }

  subtract(a: number, b: number): number {
    return a - b;
  }
}

let calculator = new Calculator();

console.log(calculator.add(10, 20));
console.log(calculator.subtract(30, 20));
