<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="database.*,penweb.*,dataStructure.*,java.util.List"%>
<!DOCTYPE html>
<html>
<head>
	<%
		// Instantiate the web controller and grab id paramter
		WebController webcon = new WebController();
		boolean isNewExample;
		Long id;
		IExample ex;
		if (!request.getParameterMap().containsKey("id")) {
			isNewExample = true;
			ex = null;
			id = null;
		}
		else {
			System.out.println("here");
			id = Long.parseLong(request.getParameter("id"));
			ex = webcon.getExampleById(id);
			isNewExample = false;
		}
	%>
	<meta charset="UTF-8">
	<title>PEN &middot; Create Entry</title>
	<link rel="stylesheet" type="text/css" href="css/reset.css" />
	<link rel="stylesheet" type="text/css" href="css/style.css" />
	<link rel="shortcut icon" type="image/x-icon" href="favicon.ico" />
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
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
	<div class="sheet" id="duplicateIntoCategories">
		<a href="javascript: closeModal();"><div class="close"></div></a>
		<h1>Duplicate Entry</h1>
		<div class="modalContent">
			<form action="duplicateCode" method="post">
				<input type="hidden" name="eid" value="<%=id%>"/>
				<p>Select categories to duplicate this entry into:</p>
				<%List<ICategory> cats = webcon.getCategories(); %>
				<% for (ICategory c : cats) { %>
					<p><input type="checkbox" name="cids" value="<%=c.getId() %>"/> <%=c.getTitle() %></p>
				<%} %>
				<input type="submit" class="button green" value="Duplicate" />
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
	<form name="login" action="login" method="post">
		<div class="input"><input type="text" name="loginname" /></div>
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
		<h1>
		<%	if (isNewExample) {%>
				New Entry
			<%}	else {%>
				<%=ex.getTitle()%>
			<%}%></h1>
			
			<%	if (!isNewExample) {%>
				<form class="barForm">
				Options:
				<input type="button" class="button black-wide" onClick="javascript: duplicateIntoCategories();" value="Duplicate"/>
				<input type="button" class="button green" onClick="editForm.submit();" value="Save Entry" />
				</form>
			<%} else {%>
				<form class="barForm">
				<input type="button" class="button green" onClick="editForm.submit();" value="Save Entry" />
				</form>
			<%} %>
	</div>
</div>
<div class="content">
	<div class="left">
		<h1>My Examples</h1>
		<ul>
			<a href="index.jsp"><li>All Entries (<%=webcon.getNumEntries() %>)</li></a>
			<% for (ICategory c : cats) { %>
				<a href="index.jsp?cat=<%=c.getId() %>"><li><%=c.getTitle()%> (<%=c.getExampleList().size() %>)</li></a>
			<%} %>
		</ul>
		<a href="javascript:newCategory();"><div class="button black-wide">New Category</div></a>
	</div>
	<div class="right">
		<form action="<%if (isNewExample) { %>addCode<%} else { %>modifyCode<%} %>" method="post" name="editForm" onsubmit="return checkAddCodeSubmit();">
			<p class="error"></p>
			<% if (!isNewExample) { %>
			<input type="hidden" name="eid" value="<%=id%>"/>
			<%} %>
			Title: *
			<input type="text" name="title" <%if(!isNewExample) {%>value="<%=ex.getTitle()%>"<%}%> />
			Author:
			<input type="text" name="author" <%if(!isNewExample) {%>value="<%=ex.getAuthorsNames()%>"<%}%>/>
			Language: 
			<input type="text" name="language" <%if(!isNewExample) {%>value="<%=ex.getLanguage()%>"<%}%>/>
			Code: *
			<textarea name="content"><%if(!isNewExample) {%><%=ex.getCode()%><%}%></textarea>
			<font size="1"><p>* Required Fields</p></font>
			<p>Categories</p>
			<% for (ICategory c : cats) { %>
				<p><input type="checkbox" name="cids" value="<%=c.getId() %>" <%if (!isNewExample){if (c.getExampleIds().contains(ex.getId())) {%>checked<%}}%>/> <%=c.getTitle() %></p>
			<%} %>
			
		</form>
	</div>
</div>
<%
	// Close the webcon
	webcon.close();
%>
</body>
</html>