<%@ include file="../common/IncludeTop.jsp" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<script type="text/javascript" src="jquery-1.7.2.min.js"></script>

<script type="text/javascript">
	$(function(){
	
		$("#userid").blur(function(){

			var params=$("#newAccForm").serialize();
			
			console.log($("#userid").val()+"---------新网页");
			
			console.log(params+"-------");
				$.ajax({
					url:"NewAccountAction",
					data:params,
					success:function(data){
						
						console.log("从ajax得来的值：----"+data);
						
						var userid=$("#userid").val();
						
						if(userid==""){
						
							$("#useridMsg").hide();
							$("#useriderrMsg").hide();
							$("#useridnullMsg").show();
							
						}else if(data=="true"){
							$("#useridMsg").show();
							$("#useriderrMsg").hide();
							$("#useridnullMsg").hide();
						}else{
							$("#useriderrMsg").show();
							$("#useridMsg").hide();
							$("#useridnullMsg").hide();
						}
					},
					error:function(){
						alert("出错了");
					}
				
				});

			});
			
			
			$("#password").blur(function(){
			
				var password=$("#password").val();
				
				console.log("<<<<<<"+password);
				
				if(password==""){
				
					$("#passworderrMsg").show();
				}else{
			
					$("#passworderrMsg").hide();
				}
			
			});
			
			$("#reppassword").blur(function(){
				
				var password=$("#password").val();
				var reppassword=$("#reppassword").val();
				
				console.log("<<<<<<"+password);
				
				if(password==""){
			
					$("#reppassworderrMsg1").show();
				}else if(reppassword!=password){
					$("#reppassworderrMsg1").hide();
					$("#passworderrMsg2").show();
				}else{
					$("#reppassworderrMsg1").hide();
					$("#passworderrMsg2").hide();
				}
			
			});
			
			
			
			
			

	})
</script>

<div id="Catalog">

  <form id="newAccForm" action="RegisterAction" method="post">

<!-- action="<%=basePath %>/account/SignonForm.jsp" -->
    

    <h3>账户信息</h3>

    <table>
      <tr>
        <td>账户:</td><td><input id="userid" name="signon.userid" type="text" />
        <span id="useriderrMsg"  style="color:red;display:none">账户已存在</span>
        <span id="useridMsg" style="color:green;display:none">账户可以使用</span>
        <span id="useridnullMsg" style="color:red;display:none">账户不能为空</span>
        </td>
      </tr><tr>
      <td>新密码:</td><td><input id="password" name="signon.password" type="password" />
      <span id="passworderrMsg"  style="color:red;display:none">密码不能为空</span>
  
      </td>
    </tr><tr>
      <td>重复密码:</td><td><input id="reppassword" type="password"/>
      <span id="reppassworderrMsg1"  style="color:red;display:none">密码不能为空</span>
      <span id="passworderrMsg2"  style="color:red;display:none">密码不一致</span>
      </td>
    </tr>
    </table>

    <%@ include file="IncludeAccountFields.jsp" %>

    <input type="submit" id="submit" name="submit" value="创建账户" class="Button" />

  </form>

</div>

<%@ include file="../common/IncludeBottom.jsp" %>