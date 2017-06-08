<%@ include file="../common/IncludeTop.jsp" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@taglib uri="/struts-tags" prefix="s"%>

<div id="Catalog">
<h2>我的订单</h2>

<table >
  <tr><th>订单编号</th>  <th>日期</th>  <th>总金额</th></tr>

<s:iterator value="ordersList" var="o">

    <tr>		
      <td><a href="CheckOutAction">${o.orderid } </a></td>
      <td>${o.orderdate } </td>
      <td>$${o.totalprice }</td>
    </tr>
  </s:iterator>
</table>


  <a href="javascript:void(0);" class="Button">&lt;&lt; 上一页</a>

  <a href="javascript:void(0);" Class="Button">下一页 &gt;&gt;</a>

</div>
<%@ include file="../common/IncludeBottom.jsp" %>


