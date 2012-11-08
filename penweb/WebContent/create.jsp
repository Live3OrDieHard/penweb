<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>PEN &middot; Create Entry</title>
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

			// Watermarks for new entry
			$("input[name=title]").watermark("Title");
			$("input[name=author]").watermark("Author");
			$("input[name=language]").watermark("Language");
			$("textarea[name=content]").watermark("Enter code here...");
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
		<h1>New Entry</h1>
	</div>
</div>
<div class="content">
	<div class="left">
		<h1>My Examples</h1>
		<ul>
			<a href="index.jsp"><li>All Entries (1)</li></a>
			<li>Tests (0)</li>
			<li>Security (0)</li>
			<li>Search (0)</li>
			<li>Data Structures (0)</li>
			<li>Algorithms (0)</li>
			<li>Math (0)</li>
		</ul>
	</div>
	<div class="right">
		<form action="addCode" method="post">
			<input type="text" name="title" />
			<input type="text" name="author" />
			<input type="text" name="language" />
			<textarea name="content"></textarea>
			<input type="submit" class="button black" value="Save Entry" />
		</form>
	</div>
</div>
</body>
</html>