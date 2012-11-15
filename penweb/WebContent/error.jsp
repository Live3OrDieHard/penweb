<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="database.*,penweb.*,dataStructure.*,java.util.List"%>
<!DOCTYPE html>
<html>
<head>
	<%
		// Instantiate the webcon
		WebController webcon = new WebController();
		// Check if we are showing all or category
		int error = 0;
		if (request.getParameterMap().containsKey("err")) {
			error = Integer.parseInt(request.getParameter("err"));
		}
		
		
	%>
	<meta charset="UTF-8">
	<title>PEN &middot; Error</title>
	<link rel="stylesheet" type="text/css" href="css/reset.css" />
	<link rel="stylesheet" type="text/css" href="css/style.css" />
	<link rel="shortcut icon" type="image/x-icon" href="favicon.ico" />
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
	<script src="js/jquery.watermark.min.js"></script>
	<script src="js/penweb.js"></script>
</head>
<body>
<div class="modal">
	<div class="sheet" id="createCategory">
		<a href="javascript: closeModal();"><div class="close"></div></a>
		<h1>New Category</h1>
		<div class="modalContent">
			<form action="addCategory" method="post" onsubmit="return checkAddCategorySubmit();">
				<p class="error"></p>
				<input type="text" name="name" />
				<textarea name="desc"></textarea>
				<input type="submit" value="Create" />
			</form>
		</div>
	</div>
	<div class="sheet" id="duplicateIntoCategories">
		<a href="javascript: closeModal();"><div class="close"></div></a>
		<h1>Duplicate Entry</h1>
		<div class="modalContent">
			<form action="duplicateCode" method="post">
				<p>Select categories to duplicate this entry into:</p>
				<p><input type="checkbox" name="cids" value="cid_here" /> Category title</p>
				<p><input type="checkbox" name="cids" value="cid_here" /> Category title</p>
				<p><input type="checkbox" name="cids" value="cid_here" /> Category title</p>
				<p><input type="checkbox" name="cids" value="cid_here" /> Category title</p>
				<p><input type="checkbox" name="cids" value="cid_here" /> Category title</p>
				<p><input type="checkbox" name="cids" value="cid_here" /> Category title</p>
				<p><input type="checkbox" name="cids" value="cid_here" /> Category title</p>
				<p><input type="checkbox" name="cids" value="cid_here" /> Category title</p>
				<p><input type="checkbox" name="cids" value="cid_here" /> Category title</p>
				<p><input type="checkbox" name="cids" value="cid_here" /> Category title</p>
				<input type="submit" value="Duplicate" />
			</form>
		</div>
	</div>
	<div class="sheet" id="signUp">
		<a href="javascript: closeModal();"><div class="close"></div></a>
		<h1>Sign Up</h1>
		<div class="modalContent">
			<p class="error"></p>
			<form action="addUser" method="post" onsubmit="return checkSignUpSubmit();">
			<div class="input"><input type="text" name="loginname" /></div>
			<div class="input"><input type="text" name="displayname" /></div>
			<div class="input"><input type="password" name="password" /></div>
			<div class="input"><input type="password" name="confirm_password" /></div>
			<input type="submit" value="Create Account" />
			</form>
		</div>
	</div>
</div>
<div class="header">
	<h1>PEN</h1>
	<h2>The Programmer's<br>Examples Notebook</h2>
	<form name="login">
		<div class="input"><input type="text" name="username" /></div>
		<div class="input"><input type="password" name="password" /></div>
		<input type="submit" class="button blue" value="Log In" />
		<input type="button" class="button black" value="Sign Up" onclick="signUp();" />
	</form>
</div>
<div class="bar">
	<div class="left">
		<a href="edit.jsp"><div class="button green">New Entry</div></a>
	</div>
	<div class="right">
		<h1>Error</h1>
	</div>
</div>
<div class="content">
	<div class="left">
		<h1>My Examples</h1>
		<ul>
			<%List<ICategory> cats = webcon.getCategories(); %>
			<a href="index.jsp"><li>All Entries (<%=webcon.getNumEntries() %>)</li></a>
			<% for (ICategory c : cats) { %>
				<a href="index.jsp?cat=<%=c.getId() %>"><li><%=c.getTitle()%> (<%=c.getExampleList().size() %>)</li></a>
			<%} %>
		</ul>
		<a href="javascript:newCategory();"><div class="button black-wide">New Category</div></a>
	</div>
	<div class="right">
		<%
			switch (error) {
			case 1:%>
				<p>The user name you chose is unavailable</p>
			<%
				break;
			case 2:%>
				<p>Invalid username and password.</p>
			<%
				break;
			default:%>
				<p>Invalid error message.</p>
			<%
				break;
			}
		%>
	</div>
</div>
<%
	// Close the web controller
	webcon.close();
%>
</body>
</html>