/** log_in.html操作文件 */

$(function(){
		$("#login").click(checklogin);
		$("#regist_username").blur(checkname);
		$("#regist_button").click(adduser);
});

function checklogin(){
			var name=$("#count").val().trim();
			var password=$("#password").val().trim();
			var ok=true;
			$("#count_span").html("");
			$("#password_span").html("");
			if(name==""){
				$("#count_span").html("用户名为空");
				ok=false;
			}
			if(password==""){
				$("#password_span").html("密码为空");
				ok=false;
			}
			
		if(ok){
			
			$.ajax({
				url:basepath+"/user/login.do",type:"post",data:{"name":name,"password":password},
				dataType:"json",success:function(result){
					if(result.status==1){
						$("#count_span").html(result.msg);
					}else if(result.status==2){
						$("#password_span").html(result.msg);
					}else if(result.status==0){
						var user=result.data;
						addCookie("userId",user.cn_user_id,2);
						addCookie("userName",user.cn_user_name,2);
						window.location.href="edit.html";
					}
				},error:function(){alert("登录失败")}
			});
		}
			
	}


function adduser(){
	var name=$("#regist_username").val().trim();
	var password=$("#regist_password").val().trim();
	var nick=$("#nickname").val().trim();
	var f_password=$("#final_password").val().trim();
	var ok=true;
	$("#warning_1 span").html("");
	$("#warning_2 span").html("");
	$("#warning_3 span").html("");
	if(name==""){
		ok=false;
		$("#warning_1").show();
		$("#warning_1 span").html("用户名为空");
	}
	if(password==""){
		ok=false;
		$("#warning_2").show();
		$("#warning_2 span").html("密码为空");
	}else if(password.length<6){
		ok=false;
		$("#warning_2").show();
		$("#warning_2 span").html("密码太短");
	}
	if(f_password==""){
		ok=false;
		$("#warning_3").show();
		$("#warning_3 span").html("确认密码为空");
	}else if(password !=f_password){
		ok=false;
		$("#warning_3").show();
		$("#warning_3 span").html("密码不一致");
	}
	if(ok){
		$.ajax({
			url:basepath+"/user/add.do",type:"post",data:{"name":name,"password":password,"nick":nick},
			dataType:"json",success:function(result){
				if(result.status==1){
					$("#warning_1").show();
					$("#warning_1 span").html(result.msg);
				}else if(result.status==0){
					$("#back").click();
				}
				
			},error:function(){alert("注册失败")}
		});
		
	}
	
}

function checkname(){
	var name=$("#regist_username").val().trim();
	$.ajax({
		url:basepath+"/user/checkname.do",type:"post",data:{"name":name},dataType:"json",
		success:function(result){
			
				$("#warning_1").show();
				$("#warning_1 span").html(result.msg);
		
		},error:function(){alert("注册失败")}
	});
}




