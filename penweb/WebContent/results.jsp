<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="database.*,penweb.*,dataStructure.*,java.util.List"%>
<!DOCTYPE html>
<html>
<head>
	<%
		// Instantiate the webcon
		WebController webcon = new WebController();
		// Check if we are showing all or category
		List<IExample> ex = null;
		String loginName = (String) session.getAttribute("name");
		IUser user = null;
		if (loginName != null) {
			user = webcon.getUserByLoginName(loginName);
		}
		if (request.getParameterMap().containsKey("lang")) {
			ex = webcon.getCodeByLanguageAndUser(user, request.getParameter("lang"));
		}
		
	%>
	<meta charset="UTF-8">
	<title>PEN &middot; Search Results (<%if (ex!=null) {%><%= ex.size() %><%} else {%>0<%}%>) </title>
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
				<input type="submit" class="button black" value="Create" />
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
	<div class="sheet" id="searchCategory">
		<a href="javascript: closeModal();"><div class="close"></div></a>
		<h1>Search Category</h1>
		<div class="modalContent">
			<form>
				Language: 
				<!-- These need to be filled -->
				<select>
					<option></option>
					<option></option>
				</select>
				<p></p>
				<input type="submit" class="button green" value="Search" />
				<input type="button" class="button black" value="Cancel" onClick="closeModal();" />
			</form>
		</div>
	</div>
</div>
<div class="header">
	<h1>PEN</h1>
	<h2>The Programmer's<br>Examples Notebook</h2>
	<%if (loginName == null) {%>
		<form name="login" action="login" method="post">
				<div class="input"><input type="text" name="loginname" /></div>
				<div class="input"><input type="password" name="password" /></div>
				<input type="submit" class="button blue" value="Log In" />
				<input type="button" class="button black" value="Sign Up" onclick="signUp();" />
		</form>
	<%} else if (loginName != null) {%>
		<div class="right">
			<p>Welcome, <%=user.getDisplayName() %></p>
			<a href="/penweb/logout"><input type="button" class="button black" value="Log Out"></a>
		</div>
	<%} %>
</div>

<!-- Anjali: This is the top bar with New Example and Category title -->
<div class="bar">
	<div class="left">
		<a href="edit.jsp"><div class="button green">New Example</div></a>
	</div>
	<div class="right">
		<h1>Search Results (<%if (ex!=null) {%><%= ex.size() %><%} else {%>0<%}%>)</h1>		
	</div>
</div>

<div class="content">
	<div class="left">
		<h1>My Examples</h1>
		<ul>
			<a href="index.jsp"><li>All Examples (<%= webcon.getNumEntries() %>)</li></a>
		</ul>
		<a href="<% if (user != null) { %>javascript:newCategory();<%} else { %>/penweb/error.jsp?err=5<%}%>"><div class="button black-wide">New Category</div></a>
	</div>
	<div class="right">
		<ul class="entrylist">
			<% 
				if (ex != null) {
					for (IExample e : ex) { %>
					<a href="edit.jsp?id=<%=e.getId()%>">
						<li>
							<h1><%= e.getTitle() %></h1>
							<div class="fade"></div>
							<div class="code"><%= e.getCode().replaceAll("\n", "<br>").replaceAll(" ", "&nbsp;").replaceAll("\t", "&nbsp;&nbsp;&nbsp;&nbsp;") %></div>
						</li>
					</a>
				<%
					}
				}	
			%>
		</ul>
	</div>
</div>
<%
	// Close the web controller
	webcon.close();
%>
</body>
</html>