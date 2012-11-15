<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="database.*,penweb.*,dataStructure.*,java.util.List"%>
<!DOCTYPE html>
<html>
<head>
	<%
		// Instantiate the webcon
		WebController webcon = new WebController();
		// Check if we are showing all or category
		ICategory cat = null;
		if (request.getParameterMap().containsKey("cat")) {
			cat = webcon.getCategoryById(Long.parseLong(request.getParameter("cat")));
		}
	%>
	<meta charset="UTF-8">
	<title>PEN &middot; <%if (cat == null) { %>All Entries (<%= webcon.getNumEntries() %>)<%} else { %><%=cat.getTitle() %> (<%=cat.getExampleList().size() %>)<%} %></title>
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
				<div class="input"><input type="text" name="name" /></div>
				<textarea name="desc"></textarea>
				<input type="submit" value="Create" />
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
			<input type="submit" class="button green" value="Create Account" />
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
		<%if (cat == null) {%>
			<h1>All Entries (<%= webcon.getNumEntries() %>)</h1>
		<%} else {%>
			<h1><%=cat.getTitle() %> (<%=cat.getExampleList().size() %>)</h1>
		<%} %>
	</div>
</div>
<div class="content">
	<div class="left">
		<h1>My Examples</h1>
		<ul>
			<a href="index.jsp"><li <% if (cat == null) {%>class="selected"<%} %>>All Entries (<%= webcon.getNumEntries() %>)</li></a>
			<%
				List<ICategory> cats = webcon.getCategories();
				for (ICategory c : cats) {
			%>
			<a href="index.jsp?cat=<%=c.getId() %>"><li <% if ((cat != null) && (c.equals(cat))) { %>class="selected"<%} %>> <%= c.getTitle() %> (<%= c.getExampleList().size() %>)</li></a>
			<% } %> 
		</ul>
		<a href="javascript:newCategory();"><div class="button black-wide">New Category</div></a>
	</div>
	<div class="right">
		<ul class="entrylist">
			<% if (cat == null) {
				List<IExample> ex = webcon.getExamples();
					for (IExample e : ex) { %>
					<a href="edit.jsp?id=<%=e.getId()%>">
						<li>
							<h1><%= e.getTitle() %></h1>
							<div class="fade"></div>
							<div class="code"><%= e.getCode().replaceAll("\n", "<br>").replaceAll(" ", "&nbsp;").replaceAll("\t", "&nbsp;&nbsp;&nbsp;&nbsp;") %></div>
						</li>
					</a>
				<%}%>
			<%} else {
				List<IExample> ex = cat.getExampleList();
				for (IExample e : ex) {%>
					<a href="edit.jsp?id=<%=e.getId()%>">
					<li>
						<h1><%= e.getTitle() %></h1>
						<div class="fade"></div>
						<div class="code"><%= e.getCode().replaceAll("\n", "<br>").replaceAll(" ", "&nbsp;").replaceAll("\t", "&nbsp;&nbsp;&nbsp;&nbsp;") %></div>
					</li>
				</a>
				<%}
			} %>
		</ul>
	</div>
</div>
<%
	// Close the web controller
	webcon.close();
%>
</body>
</html>