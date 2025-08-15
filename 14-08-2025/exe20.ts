class Generic {
  pair<T, U>(first: T, second: U): [T, U] {
    return [first, second];
  }
}

let generic = new Generic();
console.log(generic.pair("age", 23));
