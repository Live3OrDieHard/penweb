<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="database.*,penweb.*,dataStructure.*,java.util.List"%>
<!DOCTYPE html>
<html>
<head>
	<%
		// Instantiate the web controller and grab id paramter
		WebController webcon = new WebController();
		int id = Integer.parseInt(request.getParameter("id")) - 1;
	%>
	<meta charset="UTF-8">
	<title>PEN &middot; <%= webcon.getTitles().get(id) %></title>
	<link rel="stylesheet" type="text/css" href="css/reset.css" />
	<link rel="stylesheet" type="text/css" href="css/style.css" />
	<link rel="shortcut icon" type="image/x-icon" href="favicon.ico" />
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
	<script src="js/jquery.watermark.min.js"></script>
	<script>
		$(document).ready(function(){
			// Watermarks for login
			$("input[name=username]").watermark("Username");
			$("input[name=password]").watermark("Password");

		});
	</script>
</head>
<body>
<div class="header">
	<h1>PEN</h1>
	<h2>The Programmer's<br>Examples Notebook</h2>
	<form name="login">
		<div class="input"><input type="text" name="username" /></div>
		<div class="input"><input type="password" name="password" /></div>
		<input type="submit" class="button blue" value="Log In" />
		<input type="button" class="button black" value="Sign Up" />
	</form>
</div>
<div class="bar">
	<div class="left">
		<a href="create.jsp"><div class="button green">Create Entry</div></a>
	</div>
	<div class="right">
		<h1><%=webcon.getTitles().get(id) %></h1>
	</div>
</div>
<div class="content">
	<div class="left">
		<h1>My Examples</h1>
		<ul>
			<a href="index.jsp"><li>All Entries (<%=webcon.getNumEntries() %>)</li></a>
			<li>Tests (0)</li>
			<li>Security (0)</li>
			<li>Search (0)</li>
			<li>Data Structures (0)</li>
			<li>Algorithms (0)</li>
			<li>Math (0)</li>
		</ul>
	</div>
	<div class="right">
		<% IExample ex= webcon.getExamples().get(id); %>
		<p>Author: <b><%=ex.getAuthors().get(0).getName() %></b></p>
		<p>Language: <%=ex.getLanguage() %><b></b></p>
		<p class="code">
			<%= ex.getCode().replaceAll("\n", "<br>").replaceAll(" ", "&nbsp;").replaceAll("\t", "&nbsp;&nbsp;&nbsp;&nbsp;") %>
		</p>
	</div>
</div>
<%
	// Close the webcon
	webcon.close();
%>
</body>
</html>