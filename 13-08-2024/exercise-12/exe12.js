function isPalindrome(name) {
  let reversed = "";
  for (let i = 0; i < name.length; i++) {
    reversed = name[i] + reversed;
  }
  if (name == reversed) {
    console.log("poindrome");
  } else {
    console.log("not polindrome");
  }
}
isPalindrome("madam");
isPalindrome("ram");
