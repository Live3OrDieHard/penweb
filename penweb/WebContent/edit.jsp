<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="database.*,penweb.*,dataStructure.*,java.util.List,java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
	<%
		// Instantiate the web controller and grab id paramter
		WebController webcon = new WebController();
		boolean isNewExample;
		boolean isOwner = false;
		Long id;
		IExample ex;
		if (!request.getParameterMap().containsKey("id")) {
			isNewExample = true;
			ex = null;
			id = null;
		}
		else {
			id = Long.parseLong(request.getParameter("id"));
			ex = webcon.getExampleById(id);
			isNewExample = false;
		}
		String loginName = (String) session.getAttribute("name");
		IUser user = null;
		if (loginName != null) {
			user = webcon.getUserByLoginName(loginName);
		}
		if (isNewExample) {
			if (user == null) {
				response.sendRedirect("/penweb/error.jsp?err=3");
				webcon.close();
				return;
			}
		}
		else {
			if (user != null) {
				if (ex.getOwner() == user) {
					isOwner = true;
				}
			}
		}
	%>
	<meta charset="UTF-8">
	<title>PEN &middot; Edit Example</title>
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
				<input type="submit" class="button black" value="Create" />
			</form>
		</div>
	</div>
	<div class="sheet" id="duplicateIntoCategories">
		<a href="javascript: closeModal();"><div class="close"></div></a>
		<h1>Duplicate Example</h1>
		<div class="modalContent">
			<form action="duplicateCode" method="post">
				<input type="hidden" name="eid" value="<%=id%>"/>
				<input type="hidden" name="uid" value="<%if (user!=null) {%><%=user.getLoginName()%><%}%>"/>
				<p>Select categories to duplicate this example into:</p>
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
	<%if (loginName == null) {%>
		<form name="login" action="login" method="post">
				<div class="input"><input type="text" name="loginname" /></div>
				<div class="input"><input type="password" name="password" /></div>
				<input type="submit" class="button blue" value="Log In" />
				<input type="button" class="button black" value="Sign Up" onclick="signUp();" />
		</form>
	<%} else {%>
		<div class="right">
			<p>Welcome, <%=user.getDisplayName() %></p>
			<a href="/penweb/logout"><input type="button" class="button black" value="Log Out"></a>
		</div>
	<%} %>
</div>
<div class="bar">
	<div class="left">
		<a href="edit.jsp"><div class="button green">New Example</div></a>
	</div>
	<div class="right">
		<h1>
		<%	if (isNewExample) {%>
				New Example
			<%}	else {%>
				<%=ex.getTitle()%>
			<%}%></h1>
			
			<%	if (!isNewExample) {%>
				<form class="barForm" <%if(user==null){%>style="display:none"<%}%>>
				Options:
				<%if (isOwner) {%>
				<input type="button" class="button black-wide" onClick="location.href=('dependency.jsp?eid=<%= id %>')" value="Dependencies"/>
				<%}%>
				<input type="button" class="button black-wide" onClick="javascript: duplicateIntoCategories();" value="Duplicate"/>
				<%if (isOwner) {%>
				<input type="button" class="button green" id="saveButton" onClick="saveExample();" value="Save Example" <%if (!isNewExample) {%>onmouseover="showCommentBlock();"<%}%> />
				<%}%>
				</form>
			<%} else {%>
				<form class="barForm" <%if(user==null){%>style="display:none"<%}%>>
				<input type="button" class="button green" id="saveButton" onClick="saveExample();" value="Save Example" <%if (!isNewExample) {%>onmouseover="showCommentBlock();"<%}%> />
				</form>
			<%} %>
	</div>
</div>
	<div id="commentBlock">
		<textarea id="comment" onmouseout="hideCommentBlock();"></textarea>
	</div>
<div class="content">
	<div class="left">
		<h1>My Examples</h1>
		<ul>
			<% 
				int num;
				if (user == null) {
					num = webcon.getAllPublicExamples().size();
				}
				else {
					num = webcon.getVisibleExamples(user).size();
				}
			%>
			<a href="index.jsp"><li>All Examples (<%=num %>)</li></a>
			<% for (ICategory c : cats) {
				if (user == null) {
					num = c.getPublicExamples().size();
				}
				else {
					num = c.getVisibleExamples(user).size();
				} %>
				<a href="index.jsp?cat=<%=c.getId() %>"><li><%=c.getTitle()%> (<%=num %>)</li></a>
			<%} %>
		</ul>
		<a href="<% if (user != null) { %>javascript:newCategory();<%} else { %>/penweb/error.jsp?err=5<%}%>"><div class="button black-wide">New Category</div></a>
	</div>
	<div class="right">
		<form action="<%if (isNewExample) { %>addCode<%} else { %>modifyCode<%} %>" method="post" name="editForm" onsubmit="return checkAddCodeSubmit();">
			<input type="hidden" name="comment" />
			<p class="error"></p>
			<% if (!isNewExample) { %>
			<input type="hidden" name="eid" value="<%=id%>"/>
			<%} %>
			Author:
			<%if (!isNewExample) {%>
				<p><%=ex.getAuthorsNames() %></p>
			<%} else {%>
				<p><%=user.getDisplayName() %></p>
			<%} %>
			Title: *
			<input type="text" name="title" <%if(user==null || !isOwner){%>disabled="disabled"<%}%> <%if(!isNewExample) {%>value="<%=ex.getTitle()%>"<%}%> />
			
			<input type="hidden" name="loginname" <%if(!isNewExample) {%>value="<%=ex.getAuthors().get(0).getLoginName()%>"<%} else {%>value="<%=user.getLoginName()%>"<%}%>/>
			Language: 
			<input type="text" name="language" <%if(user==null || !isOwner){%>disabled="disabled"<%}%> <%if(!isNewExample) {%>value="<%=ex.getLanguage()%>"<%}%>/>
			Code: *
			<textarea <%if(user==null || !isOwner){%>disabled="disabled"<%}%> name="content"><%if(!isNewExample) {%><%=ex.getCode()%><%}%></textarea>
			<font size="1"><p>* Required Fields</p></font>
			
				<p>Share with public? <input <%if(user==null || !isOwner){%>disabled="disabled"<%}%> <%if (!isNewExample) { if (ex.isPublic()) {%>checked<%}}%> type="checkbox" name="public"/></p>
			<p>Categories:</p>
			<% for (ICategory c : cats) { %>
				<p><input <%if(user==null || !isOwner){%>disabled="disabled"<%}%> type="checkbox" name="cids" value="<%=c.getId() %>" <%if (!isNewExample){if (c.getExampleIds().contains(ex.getId())) {%>checked<%}}%>/> <%=c.getTitle() %></p>
			<%} %>
			<%
			if (!isNewExample) {
				ArrayList<IExample> dependencies = ex.getDependency();
				if (dependencies.size() != 0) {
			%>
			<p>Dependencies</p>
			<ul class="dependencyList">
				<%
					for (IExample e : dependencies) {
				%>
				<li><a href="edit.jsp?id=<%= e.getId() %>"><%= e.getTitle() %></a></li>
				<%} %>
			</ul>
			<%} }%>
			<% if (!isNewExample && (ex.getComment() != null && ex.getComment() != "")) { %><p>Last change: <%= ex.getComment() %></p> <%} %>
		</form>
	</div>
</div>
<%
	// Close the webcon
	webcon.close();
%>
</body>
</html>