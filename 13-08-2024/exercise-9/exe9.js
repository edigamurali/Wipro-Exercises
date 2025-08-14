let persons = [
  { name: "ram", age: 20, city: "hyd" },
  { name: "ramesh", age: 30, city: "hyd" },
  { name: "murali", age: 23, city: "atp" },
  { name: "madhu", age: 15, city: "hyd" },
];

for (let i = 0; i < persons.length; i++) {
  if (persons[i].age >= 18) {
    persons[i].status = "Adult";
  } else {
    persons[i].status = "Minor";
  }
}

console.log(persons);
