$(document).ready(function(){
	// Watermarks for login
	$("input[name=loginname]").watermark("Username");
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
	$("textarea#comment").watermark("Change comment?");

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
	if ($("input[name=language]").val() == "") {
		$(".error").html("Error: Please enter language.");
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
		$(".error").html("Error: Please provide a username.");
		$(".error").show();
		return false;
	} else if ($("#signUp input[name=displayname]").val() == "") {
		$(".error").html("Error: Please provide a display name.");
		$(".error").show();
		return false;
	} else if ($("#signUp input[name=password]").val() == "") {
		$(".error").html("Error: Please provide a password.");
		$(".error").show();
		return false;
	} else if ($("#signUp input[name=password]").val() != $("#signUp input[name=confirm_password]").val()) {
		$(".error").html("Error: The passwords do not match.");
		$(".error").show();
		return false;
	}
	return true;
}

//Create account
function signUp() {
	if(document.signUpForm.onsubmit()) {
		document.signUpForm.submit();
	}
}

//Category modal
function newCategory() {
	$("#createCategory").show();
	$(".modal").show();		
}

//Duplicate modal
function duplicateIntoCategories() {
	$("#duplicateIntoCategories").show();
	$(".modal").show();		
}

// Hides modal sheet
function closeModal() {
	$(".modal").hide();
	$(".modal .sheet").hide();
	$(".modal .error").html("");
}

//Save example
function saveExample() {
	$("form[name=editForm] input[name=comment]").val($("textarea#comment").val());
	if(document.editForm.onsubmit()) {
		document.editForm.submit();
	}
}

//Comment block on hover over Save Example
function showCommentBlock() {
	$("#commentBlock").show();
}

//Hide comment block
function hideCommentBlock() {
	$("#commentBlock").hide();
}

//Delete category modal
function deleteCategory() {
	$("#deleteCategory").show();
	$(".modal").show();	
}

//Search category modal
function searchCategory() {
	$("#searchCategory").show();
	$(".modal").show();
}