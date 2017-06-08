<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/IncludeTop.jsp" %>

<%@taglib uri="/struts-tags" prefix="s"%>


<div id="Catalog">

<div id="BackLink">

  <a href="<%=basePath%>catalog/Main.jsp">返回主菜单</a>

</div>
  <h2>${title }</h2>

  <table>
    <tr><th>产品编号</th>  <th>产品名称</th></tr>
    
    
    <s:iterator value="productList" var="i">
    
    <tr><td><a href="ProductToItemAction?productid=${i.productid }&&title=${title }">${i.productid }</a></td>
   <td>${i.name }</td></tr>

    </s:iterator>
  
  <%
  	HttpServletRequest requestmm=ServletActionContext.getRequest();
  	HttpSession sessionmm=requestmm.getSession();
  	
  	String keyword=(String)sessionmm.getAttribute("keyword");
  	
  	//keyword=new String(keyword.getBytes("ISO8859-1"),"UTF-8");
  	
  	
  	//out.print(keyword+"----");
	
	
	if(keyword==null){
%>	

	<tr><td>
      
        <a class="Button" href="TypeAction?currentPage=${currentPage-1 }&&title=${title }">&lt;&lt; 上一页</a>
     
        <a class="Button" href="TypeAction?currentPage=${currentPage+1 }&&title=${title }">下一页 &gt;&gt;</a>
   
    </td></tr>

<%	

	}else{
%>	
	
	<tr><td>
      
        <a class="Button" href="TypeAction?currentPage=${currentPage-1 }&&title=${title }&&keyword=${keyword }">&lt;&lt; 上一页</a>
     
        <a class="Button" href="TypeAction?currentPage=${currentPage+1 }&&title=${title }&&keyword=${keyword }">下一页 &gt;&gt;</a>
   
    </td></tr>
	
	
<%	
	}
  %>	
  	 

  
  
  
  </table>
  

</div>

<%@ include file="../common/IncludeBottom.jsp" %>


