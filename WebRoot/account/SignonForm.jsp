<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/IncludeTop.jsp" %>


<script type="text/javascript" src="jquery-1.7.2.min.js"></script>

<script type="text/javascript">

	$(function(){
	
		$("#userid").blur(function(){
		
			var userid=$("#userid").val();
			
			if(userid==""){
			
				$("#useridnullMsg").show();

			}
		
		
		
		})
		
		$("#password").blur(function(){
		
			var password=$("#password").val();
			
			if(password==""){
			
				$("#passwordnullMsg").show();
			}
		
		})
	
	
	
	})

</script>

<div id="Catalog">
  <form action="LoginAction" method="POST">

    <p>请输入您的用户名和密码.</p>
    
    
    
    <table>
    
    <tr>
    	<td>
      用户名:
      	</td>
      
      
      	<td>
      <input type="text" id="userid" name="signon.userid" value="j2ee"/>
		
        <span id="useridnullMsg" style="color:red;display:none">账户不能为空</span>
        </td>
    </tr>    
      <br/> 
      
    <tr>  
      	<td>
      
    	 密&nbsp; 码:
     
    	 </td>
     
     	<td>
     		<input type="password" id="password" name="signon.password" value="j2ee"/>
     
     	
     		<span id="passwordnullMsg" style="color:red;display:none">密码不能为空</span>
     		
     		
     		
     		
     		
     	</td>
     	
     	
    </tr> 
     </table>
     
    
    <input type="submit" name="submit" value="登录"/>
    <span id="errMsg" style="color:red;">${errMsg }</span>

  </form>

需要用户名和密码？
  <a href="<%=basePath %>/account/NewAccountForm.jsp">立即注册!</a>

</div>

<%@ include file="../common/IncludeBottom.jsp" %>

