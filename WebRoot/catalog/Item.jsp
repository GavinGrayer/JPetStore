<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/IncludeTop.jsp" %>

<bean:define id="product" name="catalogBean" property="product"/>
<bean:define id="item" name="catalogBean" property="item"/>



<div id="Catalog">
<div id="BackLink">
<a href="ProductToItemAction?title=${title }&&productid=${productid }">
    返回到${title }</a>

</div>
  <table>
    <tr>
      <td>
       <image src="${path }">${inforMsg }
      </td>
    </tr>
    <tr>
      <td>
        <b>${itemid }</b>
      </td>
    </tr><tr>
    <td>
      <b><font size="4">
      ${item.attr1 }${productname }
      </font></b>
    </td></tr>
    <tr><td>
      ${productname }
    </td></tr>
    <tr><td>
      ${qty }库存.
    
    </td></tr>
    <tr><td>
    ${listprice }

    <tr><td>
      <a class="Button" href="CartAction?attr1=${item.attr1 }&&name=${productname }&&listprice= ${listprice }&&itemid=${itemid }&&productid=${productid }">
       添加到购物车</a>
    </td></tr>
  </table>

</div>

<%@ include file="../common/IncludeBottom.jsp" %>



