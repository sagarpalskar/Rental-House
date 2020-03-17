<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add House For Rental System</title>
</head>
<body  align="center" bgcolor=#80d4ff>
  <h2> Property Details</h2>  
<form action="propertyadd" method="post">
<table align="center">
<tr><td align ="center">Flat Type:<input type ="text" name="type" required></td></tr>

<tr><td align ="center">Rent:<input type ="text" name="rent" required></td></tr>

<tr><td align ="center">Address:<input type ="text" name="address" required></td></tr>

<tr><td align ="center">Owner no:<input type ="text" name="ownerno" required></td></tr>

<tr><td align ="center">Owner Name:<input type ="text" name="ownername" required></td></tr>

<tr><td align ="center"><input type ="submit" value="House Add"></td></tr>
</table>
</body>
</html>