jQuery(document).ready(function() {
	// 去除空格
	String.prototype.trim = function() {
		return this.replace(/(^\s*)|(\s*$)/g, "");
	};
	
	//保存函数
	jQuery("#save").click(function() {
		var url = "http://localhost:8080/web/register/action";
		var formData = jQuery("#myfrom").serialize();
		var executeMsg = "";
		if (jQuery("#email").val().trim() == "") {
			executeMsg += "邮箱名不能为空,请填写邮箱名<br><br>";
		}
		var pass = jQuery("#password").val().trim() ;
		if ( pass == "") {
			executeMsg += "密码不能为空 ,请填写密码<br><br>";
		}
		var confPass = jQuery("#confirmPassword").val().trim();
		if ( confPass == "") {
			executeMsg += "确认密码不能为空,请填写密码确认密码<br><br>";
		}
		if (pass != confPass) {
			executeMsg += "确认密码不一致,请重新输入<br><br>";
		}
		if (executeMsg == "") {
			alert(url);
			jQuery.post(url, formData, function(data, textStatus) {
					alert(textStatus);
						if (textStatus == "success") {
//							if (data) {
//								MBJ.alert("添加资源成功");
//								parent.oWinj.close();
								window.location.href = "http://localhost:8080/web/register/confirm";
//							} else {
//								parent.MBJ.alert("提示", "请求失败");
//								parent.oWinj.close();
//							}
//						} else {
//							parent.MBJ.alert("提示", "请求失败");
//							parent.oWinj.close();
						}
					}, "json");
//		} else if ($("#showIsUsed").css("display") == "inline") {
//			MBJ.alert("提示", "资源码字已被使用");
		} else{
			alert( executeMsg);
		}
	});
			
});