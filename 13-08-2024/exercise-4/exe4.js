function dec() {
  let maxLen = 50;
  let currentLen = document.getElementById("in").value.length;
  let remainchar = maxLen - currentLen;
  document.getElementById("remain").innerHTML = remainchar + " are remaining";
}
