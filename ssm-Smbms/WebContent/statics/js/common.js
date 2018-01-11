var path = $("#path").val();
var imgYes = "<img width='15px' src='"+path+"/images/y.png' />";
var imgNo = "<img width='15px' src='"+path+"/images/n.png' />";
/**
 * 提示信息显示
 * element:显示提示信息的元素（font）
 * css：提示样式
 * tipString:提示信息
 * status：true/false --验证是否通过
 */
function validateTip(element,css,tipString,status){
	element.css(css);
	element.html(tipString);
	
	element.prev().attr("validateStatus",status);
}
var referer = $("#referer").val();

function submitImgSize1Upload(domid,imgName){
	
	var option ={
		type:"POST",
		url:"upload/uploadImg",
		dataType:"text",
		data:{fileName:imgName},
		success:function(data){
			var jsonobj = $.parseJSON(data);
			console.info(jsonobj.relativePath);
			$(domid).val(jsonobj.relativePath);
			
		}
	};
	
	$("#addForm").ajaxSubmit(option);
	
	
}


$(".providerClick").click(function(){
	
	if(confirm("你确定删除吗?")){
		return true;
	}
	return false;
})



$(function(){
	// 使用简单的方式 代替了
/*	var userRole = $("#userRoelInfo");
	$("#userRoelInfo").each(function(){
		console.info($(this).val());
		$(this).val($(this).attr("data"));
	});*/
	
	
	$(".deleteUser").click(function(){
		var userid = $(this).attr("username");
		var user = $(this).parent().parent().parent();
		if(confirm("你确定删除该名员工吗？")){
			$.ajax({
				type:"GET",
				url:"user/deleteUser",
				dataType:"json",
				data:{userId:userid},
				success:function(data){
					if(data.res > 1){
						user.remove();
						alert("删除成功！");
					}else {
						alert("删除失败");
					}
				}
				
				
			});
		}
	});
	
	
});