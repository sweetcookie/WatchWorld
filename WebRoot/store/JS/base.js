$(document).ready(function(){
  $("#LoginName").onblur(function(){
  $(this).hide();
  });
});

function checkLoginName(input){
	alert(input.val);
}