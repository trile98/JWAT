function validateText(id)
{
	if($("#"+id).val()==null || $("#"+id).val()=="")
	{
		var div = $("#"+id).closest("div");
		div.removeClass("has-success");
		$("#fa"+id).remove();
		div.addClass("has-error has-feedback");
		div.append('<span id="fa'+id+'" class="fa fa-times form-control-feedback"></span>');
		return false;
	}
	else{
	    var div = $("#"+id).closest("div");
	    div.removeClass("has-error");
		$("#fa"+id).remove();
		div.addClass("has-success has-feedback");
		div.append('<span id="fa'+id+'" class="fa fa-check form-control-feedback"></span>');
		return true;
	}

}

function validateEmail(id)
{
	  var email_regex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/i;
	if(!email_regex.test($("#"+id).val()))
	{
		var div = $("#"+id).closest("div");
		div.removeClass("has-success");
		$("#fa"+id).remove();
		div.addClass("has-error has-feedback");
		div.append('<span id="fa'+id+'" class="fa fa-times form-control-feedback"></span>');
		return false;
	}
	else{
	    var div = $("#"+id).closest("div");
		    div.removeClass("has-error");
		$("#fa"+id).remove();
		div.addClass("has-success has-feedback");
		div.append('<span id="fa'+id+'" class="fa fa-check form-control-feedback"></span>');
	    return true;
	}

}

$(document).ready(
	function()
	{
		$("#submitButton").click(function()
		{
		 if(!validateText("usernameInput"))
		 {
		    return false;
		 }
		 if(!validateText("passwordInput"))
		 {
		    return false;
		 }
		 if(!validateEmail("emailInput"))
		 {
		    return false;
		 }
		 $("form#registerForm").submit();
		});
	}

);