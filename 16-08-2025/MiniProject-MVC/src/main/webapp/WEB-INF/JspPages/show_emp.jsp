<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head><title>Employees</title></head>
<body>
<h2 style="text-align:center;">Employee List</h2>
<center>
<a href="add"><button>Add New Employee</button></a>
</center>
<c:choose>
  <c:when test="${!empty empList}">
    <table border="1" align="center" cellpadding="10">
      <tr style="background:lightgray;">
        <th>ID</th><th>Name</th><th>Dept</th><th>Salary</th><th>Type</th><th>Address</th><th>Actions</th>
      </tr>
      <c:forEach var="emp" items="${empList}">
        <tr>
          <td>${emp.id}</td>
          <td>${emp.name}</td>
          <td>${emp.dept}</td>
          <td>${emp.salary}</td>
          <td>${emp.empType}</td>
          <td>${emp.address}</td>
          <td>
            <a href="edit/${emp.id}"><button>Edit</button></a>
            <a href="delete/${emp.id}" onclick="return confirm('Delete Employee?')"><button>Delete</button></a>
          </td>
        </tr>
      </c:forEach>
    </table>
  </c:when>
  <c:otherwise>
    <h3 style="color:red;text-align:center;">No Employees Found</h3>
  </c:otherwise>
</c:choose>
</body>
</html>
