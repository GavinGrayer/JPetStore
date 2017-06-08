
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@page import="com.domain.Cart"%>


<%@taglib uri="/struts-tags" prefix="s"%>

<%@ include file="../common/IncludeTop.jsp" %>







<div id="Catalog">

<div id="BackLink" >
  <a href="<%=basePath%>catalog/Main.jsp">返回主菜单</a>
</div>
  <div id="Cart">

    <h2>购物车</h2>
    <form action="UpdateCartAction" method="post">
      <table>
        <tr>
          <th><b>商品编号</b></th>  <th><b>产品编号</b></th>  <th><b>产品描述</b></th> <th><b>有库存?</b></th>
          <th><b>产品数量</b></th>  <th><b>定价</b></th> <th><b>总成本</b></th>  <th>&nbsp;</th>
        </tr>

      <%
      	List<Cart> cartList=(List<Cart>)session.getAttribute("cartList") == null ? null : (List<Cart>)session.getAttribute("cartList");
      	
      	//out.println(cartList.size());
      	
      	String username=(String)session.getAttribute("username") ==null ? "" : (String)session.getAttribute("username") ;
      
      
      if(username==null||username.equals("")){//判断是否为登录状态
      	
      	if(cartList==null){//当临时购物车为空未添加的时候
       %>	
      	<tr><td colspan="8"><b>你的购物车是空的.</b></td></tr>
      	
      <%	
      	} else if(cartList.isEmpty()){//当临时购物车清空后
      %>	
      	<tr><td colspan="8"><b style="color:red">你的购物车已清空!!请重新添加.</b></td></tr>
      	
      <% 
      	}else {//临时购物车不为空

	        for(Cart cart:cartList){

	      %>  
	        	<tr>
	            <td><a href="<%=basePath %>/catalog/Item.jsp"><%=cart.getItem().getItemid() %></a></td>
	            <td><%=cart.getItem().getProduct().getProductid() %></td>
	            <td><%=cart.getItem().getAttr1() %><%=cart.getItem().getProduct().getName() %></td>
	            <td>有</td>
	            <td><input type="text" id="number" name="inStock" size="5" value="1"/> </td>
	            <td> 	$<%=cart.getItem().getListprice() %> 	</td>
	            <td>$<%=cart.getItem().getAllprice() %>
	            	
	           </td>
	            <td><a Class="Button" href="RemoveCartAction?itemid=<%=cart.getItem().getItemid() %>">
	              取消</a></td>
	          </tr> 	
	        	
	     <% 
	
				}     
     	
       		 }
        
       } else{//登录购物车
      %>
      
      	<s:iterator value="cartList" var="c">
         <tr>
            <td><a href="<%=basePath %>/catalog/Item.jsp">${c.item.itemid }</a></td>
            <td>${c.item.product.productid }</td>
            <td>${c.item.attr1 }${c.item.product.name }</td>
            <td>有</td>
            <td><input type="text" name="inStock" size="5" value="1"/> </td>
            <td> 	$${c.item.listprice } 	</td>
            <td>$${c.item.allprice }</td>
            <td><a Class="Button" href="delCartAction?itemid=${c.item.itemid }">
              取消</a></td>
          </tr>
       </s:iterator>
      <%  

        }
      %>       
       

   

        
        <tr>
          <td colspan="7">
            总金额: 
            <input type="submit" name="update" value="更新购物车" class="Button"  />

          </td>
          <td>&nbsp;</td>
        </tr>
      </table>
      
        <a class="Button" href="javascript:void(0);">&lt;&lt; 上一页</a>
      
      
        <a class="Button" href="javascript:void(0);">下一页 &gt;&gt;</a>


    </form>

  <a class="Button" href="CheckOutAction" >付款</a>


  </div>
    <div id="MyList" style="margin-top:10px;">
    <%@ include file="IncludeMyList.jsp" %>
    </div>
  <div id="Separator">&nbsp;</div>

</div>


<%@ include file="../common/IncludeBottom.jsp" %>



