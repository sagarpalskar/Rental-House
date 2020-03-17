<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Property Details</title>
</head>
<body align="center" bgcolor=#80d4ff>
  <h2>Edit Property Details</h2>  

<form action="editsave" method="post">

<table align="center">
<tr><td align ="center">Flat Type:<input type ="text" name="type"></td></tr>

<tr><td align ="center">Rent:<input type ="text" name="rent"></td></tr>

<tr><td align ="center">Address:<input type ="text" name="address"></td></tr>

<tr><td align ="center">Owner no:<input type ="text" name="ownerno"></td></tr>

<tr><td align ="center">Owner Name:<input type ="text" name="ownername"></td></tr>

<tr><td align ="center"><input type ="submit" value="Edit Save"></td></tr> 
</form> 
</body>
</html>