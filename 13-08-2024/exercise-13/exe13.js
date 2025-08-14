function validateEmail() {
  let input = document.getElementById("emailinput").value.trim();
  let sendMsg = document.getElementById("email");
  if (input === "") {
    sendMsg.textContent = "Email is required";
    sendMsg.style.visibility = "visible";
    return false;
  } else {
    sendMsg.style.visibility = "hidden";
    return true;
  }
}

function validatePassword() {
  let input = document.getElementById("passinput").value.trim();
  let sendMsg = document.getElementById("pass");
  if (input === "") {
    sendMsg.textContent = "Password is required";
    sendMsg.style.visibility = "visible";
    return false;
  } else {
    sendMsg.style.visibility = "hidden";
    return true;
  }
}

function validateCredintials() {
  let email = validateEmail();
  let pass = validatePassword();
  if (email && pass) {
    alert("Login success");
    return true;
  } else {
    alert("Login not success");
    return false;
  }
}
