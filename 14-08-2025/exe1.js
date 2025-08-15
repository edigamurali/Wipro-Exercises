var numbers = [1, 4, 56, 78, 34, 10];

let sum = (arr) => arr.reduce((totalSum, number) => totalSum + number, 0);

console.log(sum(numbers));
