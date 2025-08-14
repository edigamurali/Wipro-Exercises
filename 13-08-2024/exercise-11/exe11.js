let date = new Date(2030, 7, 13);
let days = [
  "Sunday",
  "Monday",
  "Tuesday",
  "Wednesday",
  "Thursday",
  "Friday",
  "Saturday",
];
let dayName = days[date.getDay()];

console.log(dayName);
