let persons = [
  { name: "ram", age: 20, city: "hyd" },
  { name: "ramesh", age: 17, city: "hyd" },
  { name: "murali", age: 23, city: "atp" },
  { name: "madhu", age: 15, city: "hyd" },
];

persons.map((person) => {
  person.status = person.age >= 18 ? "Adult" : "Minor";
  return person;
});
console.log(persons);
