class Util {
  getDate(date) {
    return date;
  }

  getPIValue() {
    return Math.PI;
  }

  convertC2F(centigrade) {
    return (centigrade * 9) / 5 + 32;
  }

  getFibonacci(n) {
    let first = 0;
    let second = 1;
    let series = [];

    for (let i = 0; i < n; i++) {
      series.push(first);
      let temp = first + second;
      first = second;
      second = temp;
    }

    return series;
  }
}

let u = new Util();
console.log(u.getDate("14-08-2025"));
console.log(u.getPIValue());
console.log(u.convertC2F(30));
console.log(u.getFibonacci(7));
