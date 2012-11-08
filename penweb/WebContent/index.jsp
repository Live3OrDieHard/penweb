<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="database.*,penweb.*,dataStructure.*,java.util.List"%>
<!DOCTYPE html>
<html>
<head>
	<%
		// Instantiate the webcon
		WebController webcon = new WebController();
	%>
	<meta charset="UTF-8">
	<title>PEN &middot; All Entries (<%= webcon.getNumEntries() %>)</title>
	<link rel="stylesheet" type="text/css" href="css/reset.css" />
	<link rel="stylesheet" type="text/css" href="css/style.css" />
	<link rel="shortcut icon" type="image/x-icon" href="favicon.ico" />
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
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
		<a href="create.jsp"><div class="button green">New Entry</div></a>
	</div>
	<div class="right">
		<h1>All Entries (<%= webcon.getNumEntries() %>)</h1>
	</div>
</div>
<div class="content">
	<div class="left">
		<h1>My Examples</h1>
		<ul>
			<a href="index.jsp"></a><li class="selected">All Entries (<%= webcon.getNumEntries() %>)</li></a>
			<li>Tests (0)</li>
			<li>Security (0)</li>
			<li>Search (0)</li>
			<li>Data Structures (0)</li>
			<li>Algorithms (0)</li>
			<li>Math (0)</li>
		</ul>
	</div>
	<div class="right">
		<ul class="entrylist">
			<% int id = 1; %>
			<% List<IExample> ex = webcon.getExamples(); %>
			<% for (IExample e : ex) { %>
				<a href="viewcode.jsp?id=<%=id%>">
					<li>
						<h1><%= e.getTitle() %></h1>
						<div class="fade"></div>
						<div class="code"><%= e.getCode().replaceAll("\n", "<br>") %></div>
					</li>
				</a>
				<% id++; %>
			<%}%>
		</ul>
	</div>
</div>
<%
	// Close the web controller
	webcon.close();
%>
</body>
</html>