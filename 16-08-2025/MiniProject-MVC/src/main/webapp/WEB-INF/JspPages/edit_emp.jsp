<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Employee</title>
</head>
<body>
<h2 style="text-align:center;">Edit Employee</h2>
<center>
<form:form modelAttribute="employee" method="post" action="../edit">
    <form:hidden path="id"/>

    <div>
        Name: <form:input path="name"/><br><br>
    </div>

    <div>
        Dept: 
        <form:select path="dept">
            <form:option value="" label="--Select Department--"/>
            <form:option value="IT" label="IT"/>
            <form:option value="HR" label="HR"/>
            <form:option value="Finance" label="Finance"/>
            <form:option value="Sales" label="Sales"/>
        </form:select><br><br>
    </div>

    <div>
        Salary: <form:input path="salary" type="number"/><br><br>
    </div>

    <div>
        Type:
        <form:radiobutton path="empType" value="FullTime"/> Full Time
        <form:radiobutton path="empType" value="PartTime"/> Part Time<br><br>
    </div>

    <div>
        Address: <form:textarea path="address" rows="3" cols="20"/><br><br>
    </div>

    <input type="submit" value="Update"/>
</form:form>
</center>
</body>
</html>
