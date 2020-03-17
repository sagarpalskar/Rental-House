<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<!DOCTYPE html>
<html>
<head>
<style>
a:link, a:visited {
  background-color: #003366;
  color: white;
  padding: 15px 25px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
}


</style>
<meta charset="UTF-8">
<title>View Property Details</title>
</head>
<body bgcolor=#80d4ff align="center">
<form method="post">


<table border="2" align="center">
<h3 align="center">Registerd Property  </h3>

<tr>
<td>Id</td>
<td>Type</td>
<td>Rent</td>
<td>Addres</td>
<td>Owner Name</td>
<td>Owner No</td>
 <td>Edit</td>  
 <td>Delete</td>  
</tr>
<%
try
{
Class.forName("com.mysql.jdbc.Driver");
String url=("jdbc:mysql://localhost:3306/RentDB");
String username="root";
String password="!@Sagar96";
String query="select * from Property";
Connection conn=DriverManager.getConnection(url, username, password);
Statement stmt=conn.createStatement();
ResultSet rs=stmt.executeQuery(query);
while(rs.next())
{
%>
<tr>
<td><%=rs.getString("Id") %></td>
<td><%=rs.getString("type") %></td>
<td><%=rs.getString("rent") %></td>
<td><%=rs.getString("address") %></td>
<td><%=rs.getString("ownerno") %></td>
<td><%=rs.getString("ownername") %></td>
<td><a href="edit<%=rs.getString("Id") %>">Edit</a></td>  
 <td><a href="delete<%=rs.getString("Id") %>">Delete</a></td>  

</tr>

<%
}
%>
</table>
<%
rs.close();
stmt.close();
conn.close();
}
catch(Exception e)
{
e.printStackTrace();
}
%>


</form>
<br>
<a href="Welcome" >Home Page</a> 
<a href="logout">logout</a> 
</body>
</html>