<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/IncludeTop.jsp" %>

<%@taglib uri="/struts-tags" prefix="s"%>



<div id="Catalog">
<div id="BackLink">

  <a href="TypeAction?title=${title }">
  返回 ${title }</a>

</div>
  <h2>${title }</h2>

  <table>
    <tr><th>商品编号</th>  <th>产品编号</th>  <th>产品描述</th>  <th>定价</th>  <th>&nbsp;</th></tr>
  <s:iterator value="itemList" var="ia">
      <tr>
        <td><a href="FindItemByIdAction?itemid=${ia.itemid }&&productname=${ia.product.name }&&listprice=${ia.listprice }&&productid=${productid }&&title=${title }">${ia.itemid }</a></td>
        <td>${productid }</td>
        <td>${ia.attr1 }${ia.product.name }</td>
        <td>$${ia.listprice }</td>
        <td><a href="CartAction?attr1=${ia.attr1 }&&name=${ia.product.name }&&listprice=${ia.listprice }&&itemid=${ia.itemid }&&productid=${productid }" class="Button"> 添加到购物车</a></td>
      </tr>
   </s:iterator> 
    <tr><td>
      
        <a class="Button" href="javascript:void(0)">&lt;&lt; 上一页</a>
     
        <a class="Button" href="javascript:void(0)">下一页 &gt;&gt;</a>
   
    </td></tr>
  </table>

</div>

<%@ include file="../common/IncludeBottom.jsp" %>





