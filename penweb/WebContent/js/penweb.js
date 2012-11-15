$(document).ready(function(){
	// Watermarks for login
	$("input[name=username]").watermark("Username");
	$("input[name=password]").watermark("Password");

	// Watermarks for sign up
	$("#signUp input[name=loginname]").watermark("Username");
	$("#signUp input[name=displayname]").watermark("Display Name");
	$("#signUp input[name=password]").watermark("Password");
	$("#signUp input[name=confirm_password]").watermark("Confirm Password");
	
	// Watermarks for new categories
	$("#createCategory input[name=name]").watermark("Category Name");
	$("#createCategory textarea[name=desc]").watermark("Enter description...");			

	// Watermarks for new entry
	$("input[name=title]").watermark("Title");
	$("input[name=author]").watermark("Author");
	$("input[name=language]").watermark("Language");
	$("textarea[name=content]").watermark("Enter code here...");
});

// Checks addCode submission to make sure title and content aren't blank
function checkAddCodeSubmit() {
	if ($("input[name=title]").val() == "") {
		$(".error").html("Error: Please provide a title.");
		$(".error").show();
		return false;
	}
	if ($("textarea[name=content]").val() == "") {
		$(".error").html("Error: Please enter code.");
		$(".error").show();
		return false;
	}					
	return true;
}

// Checks addCategory submission to make sure name isn't blank
function checkAddCategorySubmit() {
	if ($("#createCategory input[name=name]").val() == "") {
		$(".modal .error").html("Error: Please provide a category name.");
		$(".modal .error").show();
		return false;
	}
	return true;
}

// Check signUp submission to make sure fields aren't blank and passwords math

function checkSignUpSubmit() {
	if ($("#signUp input[name=loginname]").val() == "") {
		$(".modal .error").html("Error: Please provide a username.");
		$(".modal .error").show();
		return false;
	} else if ($("#signUp input[name=displayname]").val() == "") {
		$(".modal .error").html("Error: Please provide a display name.");
		$(".modal .error").show();
		return false;
	} else if ($("#signUp input[name=password]").val() == "") {
		$(".modal .error").html("Error: Please provide a password.");
		$(".modal .error").show();
		return false;
	} else if ($("#signUp input[name=password]").val() != $("#signUp input[name=confirm_password]").val()) {
		$(".modal .error").html("Error: The passwords do not match.");
		$(".modal .error").show();
		return false;
	}
	return true;
}

function newCategory() {
	$("#createCategory").show();
	$(".modal").show();		
}

function duplicateIntoCategories() {
	$("#duplicateIntoCategories").show();
	$(".modal").show();		
}

function signUp() {
	$("#signUp").show();
	$(".modal").show();
}

function closeModal() {
	$(".modal").hide();
	$(".modal .sheet").hide();
	$(".modal .error").html("");
}