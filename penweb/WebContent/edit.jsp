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
			isOwner = true;
			ex = null;
			id = null;
		}
		else {
			id = Long.parseLong(request.getParameter("id"));
			ex = webcon.getExampleById(id);
			if (ex == null) {
				response.sendRedirect("/penweb/error.jsp?err=6");
				webcon.close();
				return;
			}
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
			if (!isOwner && !ex.isPublic()) {
				response.sendRedirect("/penweb/");
				webcon.close();
				return;
			}
		}
	%>
	<title>PEN &middot; Edit Example</title>
<%@include file="includes/head/tags" %>
</head>
<body>
<div class="modal">
<%@include file="includes/modal/createCategory" %>
<%@include file="includes/modal/duplicateIntoCategories" %>
<%@include file="includes/modal/signUp" %>
</div>
<%@include file="includes/header" %>
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
				<form class="barForm" method="post" action="deleteExample"<%if(user==null){%>style="display:none"<%}%>>
				Options:
				<%if (isOwner) {%>
				<input type="hidden" name="eid" value="<%= ex.getId()%>"/>
				<!-- input type="submit" class="button black-wide" value="Delete Example"/-->
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
		<h1><%if (user != null) { %>Examples<%} else { %>Public Examples<%} %></h1>
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
			Language: *
			<input type="text" name="language" <%if(user==null || !isOwner){%>disabled="disabled"<%}%> <%if(!isNewExample) {%>value="<%=ex.getLanguage()%>"<%}%>/>
			Code: *
			<textarea <%if(user==null || !isOwner){%>disabled="disabled"<%}%> name="content"><%if(!isNewExample) {%><%=ex.getCode()%><%}%></textarea>
			<font size="1"><p>* Required Fields</p></font>
			
				<p>Share with public? <input <%if(user==null || !isOwner){%>disabled="disabled"<%}%> <%if (!isNewExample) { if (ex.isPublic()) {%>checked<%}}%> type="checkbox" name="public"/></p>
			<p>Categories:</p>
			<% for (ICategory c : cats) { %>
			<p><%if(user==null){%>
			<%if (!isNewExample){if (c.getExampleIds().contains(ex.getId())) {%><input disabled="disabled" type="checkbox" name="cids"value="<%=c.getId() %>"checked/> <%=c.getTitle() %><%}}%></p>
			<%} else {%>
			<input <%if(user==null || !isOwner){%>disabled="disabled"<%}%> type="checkbox" name="cids" value="<%=c.getId() %>" <%if (!isNewExample){if (c.getExampleIds().contains(ex.getId())) {%>checked<%}}%>/> <%=c.getTitle() %></p>
			<%} }%>
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
