const employeeDetails = [
  { empId: "wipro100", empName: "Murali", role: "Manager", salary: 10000 },
  { empId: "wipro101", empName: "Sita", role: "QA", salary: 8000 },
  { empId: "wipro102", empName: "Ravi", role: "Developer", salary: 12000 },
  { empId: "wipro103", empName: "Anita", role: "Manager", salary: 11000 },
  { empId: "wipro104", empName: "Rahul", role: "Developer", salary: 13000 },
  { empId: "wipro105", empName: "Priya", role: "QA", salary: 9000 },
  { empId: "wipro106", empName: "Kiran", role: "Manager", salary: 15000 },
];

const totalManagerSalary = employeeDetails
  .filter((emp) => emp.role === "Manager")
  .reduce((sum, emp) => sum + emp.salary, 0);

console.log("Total salary of all managers:", totalManagerSalary);
