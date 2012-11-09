<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="database.*,penweb.*,dataStructure.*,java.util.List"%>
<!DOCTYPE html>
<html>
<head>
	<%
		// Instantiate the webcon
		WebController webcon = new WebController();
		// Check if we are showing all or category
		boolean disp = request.getParameterMap().containsKey("cat");
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

			// Watermarks for new categories
			$("#createCategory input[name=name]").watermark("Category Name");
			$("#createCategory textarea[name=desc]").watermark("Enter description...");			
		});

		// Checks addCategory submission to make sure name isn't blank
		function checkAddCategorySubmit() {
			if ($("#createCategory input[name=name]").val() == "") {
				$(".modal .error").html("Error: Please provide a category name.");
				$(".modal .error").show();
				return false;
			}
			return true;
		}

		function newCategory() {
			$("#createCategory").show();
			$(".modal").show();		
		}
 
		function closeModal() {
			$(".modal").hide();
			$(".modal .sheet").hide();

		}
	</script>
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
</div>
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
		<%if (!disp) {%>
			<h1>All Entries (<%= webcon.getNumEntries() %>)</h1>
		<%} else {
			ICategory catego = webcon.getCategoryById(Long.parseLong(request.getParameter("cat")));
			%>
			<h1><%=catego.getTitle() %> (<%=catego.getExampleList().size() %>)</h1>
		<%} %>
	</div>
</div>
<div class="content">
	<div class="left">
		<h1>My Examples</h1>
		<ul>
			<a href="index.jsp"><li <% if (!disp) {%>class="selected"<%} %>>All Entries (<%= webcon.getNumEntries() %>)</li></a>
			<%
				List<ICategory> cat = webcon.getCategories();
				for (ICategory c : cat) {
			%>
			<a href="index.jsp?cat=<%=c.getId() %>"><li <% if ((disp) && (c.getId().equals(Long.parseLong(request.getParameter("cat"))))) { %>class="selected"<%} %>> <%= c.getTitle() %> (<%= c.getExampleList().size() %>)</li></a>
			<% } %> 
		</ul>
		<a href="javascript:newCategory();"><div class="button black-wide">New Category</div></a>
	</div>
	<div class="right">
		<ul class="entrylist">
			<% if (!disp) {%>
				<% List<IExample> ex = webcon.getExamples(); %>
				<% for (IExample e : ex) { %>
					<a href="view.jsp?id=<%=e.getId()%>">
						<li>
							<h1><%= e.getTitle() %></h1>
							<div class="fade"></div>
							<div class="code"><%= e.getCode().replaceAll("\n", "<br>").replaceAll(" ", "&nbsp;").replaceAll("\t", "&nbsp;&nbsp;&nbsp;&nbsp;") %></div>
						</li>
					</a>
				<%}%>
			<%} else {%>
				<%long catid = Long.parseLong(request.getParameter("cat"));
				ICategory categ = webcon.getCategoryById(catid);
				List<IExample> examp = categ.getExampleList();
				for (IExample exa : examp) {%>
					<a href="view.jsp?id=<%=exa.getId()%>">
					<li>
						<h1><%= exa.getTitle() %></h1>
						<div class="fade"></div>
						<div class="code"><%= exa.getCode().replaceAll("\n", "<br>").replaceAll(" ", "&nbsp;").replaceAll("\t", "&nbsp;&nbsp;&nbsp;&nbsp;") %></div>
					</li>
				</a>
				<%}%>
			<%} %>
		</ul>
	</div>
</div>
<%
	// Close the web controller
	webcon.close();
%>
</body>
</html>