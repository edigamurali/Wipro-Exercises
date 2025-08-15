interface Employee {
  empId: number;
  empName: string;
  salary: number;
}
let empList: Employee[] = [
  { empId: 1000, empName: "Murali", salary: 10000 },
  { empId: 1001, empName: "Ram", salary: 10000 },
  { empId: 1002, empName: "Shiva", salary: 5000 },
];
function printEmployees(employee: Employee[]): number {
  for (let i = 0; i < employee.length; i++) {
    console.log(employee[i]);
  }

  return employee.length;
}
console.log(printEmployees(empList));
