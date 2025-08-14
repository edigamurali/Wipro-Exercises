let cities = ["Hyderabad", "Mumbai", "Bangalore", "Delhi", "Chennai"];

function addCities() {
  let dropdown = document.getElementById("cityDropdown");

  dropdown.length = 1;
  let sortedCities = cities.slice().sort();
  for (let i = 0; i < sortedCities.length; i++) {
    let option = document.createElement("option");
    option.value = sortedCities[i];
    option.textContent = sortedCities[i];
    dropdown.appendChild(option);
  }
}
