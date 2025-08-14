function getValues() {
  let n1 = Number(document.getElementById("num1").value);
  let n2 = Number(document.getElementById("num2").value);
  return { n1, n2 };
}

function add() {
  let { n1, n2 } = getValues();
  document.getElementById("result").innerText = n1 + n2;
}

function sub() {
  let { n1, n2 } = getValues();
  document.getElementById("result").innerText = n1 - n2;
}

function mul() {
  let { n1, n2 } = getValues();
  document.getElementById("result").innerText = n1 * n2;
}

function divide() {
  let { n1, n2 } = getValues();
  if (n2 === 0) {
    document.getElementById("result").innerText = "Cannot divide by 0";
  } else {
    document.getElementById("result").innerText = n1 / n2;
  }
}
