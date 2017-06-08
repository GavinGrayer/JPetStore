<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="org.apache.struts2.ServletActionContext"%>


<%
		HttpServletRequest request2=ServletActionContext.getRequest();
		HttpSession session2=request2.getSession();
		String mylistopt=(String)session.getAttribute("mylistopt");



		if(mylistopt!=null&&mylistopt.equals("1")){
	%>	
		<p>
   宠物的最爱
    <br/>
     为你最喜欢的宠物店在这里
  </p>
  <ul>
  
      <li><a href="./catalog/Product.jsp">斗牛犬</a>(K9-BD-01)</li>
 
  </ul>

  <p>
   
      <a href="javascript:void(0)" class="Button">&lt;&lt;上一页</a>
  
    
        <a href="javascript:void(0)" class="Button">下一页 &gt;&gt;</a>
  
  </p>
		
		
	<%		
		}
 %>


  




