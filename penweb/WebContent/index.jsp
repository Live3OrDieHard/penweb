<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>PEN &middot; The Programmer's Examples Notebook</title>
	<link rel="stylesheet" type="text/css" href="css/reset.css" />
	<link rel="stylesheet" type="text/css" href="css/style.css" />
	<link rel="shortcut icon" type="image/x-icon" href="favicon.ico" />
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
	<script src="js/jquery.watermark.min.js"></script>
	<script>
		$(document).ready(function(){
			$("input[name=username]").watermark("Username");
			$("input[name=password]").watermark("Password");
		});
	</script>
</head>
<body>
<div class="header">
	<img class="logo" src="images/logo.png" />
	<form name="login">
		<div class="input"><input type="text" name="username" /></div>
		<div class="input"><input type="password" name="password" /></div>
		<input type="submit" class="button blue" value="Log In" />
		<input type="button" class="button black" value="Sign Up" />
</div>
<div class="bar">
	<div class="left">
		<div class="button green">New Entry</div>
	</div>
</div>
<div class="content">
	<div class="left">
		<h1>My Examples</h1>
		<ul>
			<li>All Entries (24)</li>
			<li>Tests (4)</li>
			<li class="selected">Security (5)</li>
			<li>Search (3)</li>
			<li>Data Structures (1)</li>
			<li>Algorithms (10)</li>
			<li>Math (3)</li>
		</ul>
		<h1>Public Examples</h1>
		<ul>
			<li>All Entries (240)</li>
			<li>Tests (47)</li>
			<li>Security (53)</li>
			<li>Search (67)</li>
			<li>Data Structures (141)</li>
			<li>Algorithms (108)</li>
			<li>Math (903)</li>
		</ul>
	</div>
	<div class="right">
		<ul class="entrylist">
			<a href="viewcode.jsp?id=1">
				<li>
					<h1>Entry Name 1</h1>
					<div class="fade"></div>
					<div class="code">public class MyClass {<br><br>private LoremIpsum loremIpsum;<br><br>public MyClass() {<br><br>this.loremIpsum = new LoremIpsum();</div>
				</li>
			</a>
			<a href="viewcode.jsp?id=2">
				<li>
					<h1>Entry Name 2</h1>
					<div class="fade"></div>
					<div class="code">public class MyClass {<br><br>private LoremIpsum loremIpsum;<br><br>public MyClass() {<br><br>this.loremIpsum = new LoremIpsum();</div>
				</li>
			</a>
		</ul>
	</div>
</div>
</body>
</html>