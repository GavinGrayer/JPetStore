<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/IncludeTop.jsp" %>

<%@taglib uri="/struts-tags" prefix="s"%>

<div id="Catalog">
<div id="BackLink">
<a href="<%=basePath %>/cart/Cart.jsp">返回到购物车</a>
</div>

  <table>
    <tr>
      <td>
        <h2>核对信息</h2>

        <table>

          <tr>
            <td><b>商品编号</b></td>  <td><b>产品编号</b></td>  <td><b>产品描述</b></td> <td><b>In Stock?</b></td>
            <td><b>产品数量</b></td>  <td><b>定价</b></td> <td><b>总成本</b></td>
          </tr>

         <s:iterator value="cartList" var="c">
            <tr>
              <td><a href="<%=basePath %>/catalog/Product.jsp">${c.item.itemid }</a></td>
              <td>${c.item.product.productid }</td>
              <td>${c.item.attr1 }${c.item.product.name }</td>
              <td>有</td>
              <td>
                ${c.item.number }
              </td>
              <td>$${c.item.listprice }</td>
              <td>$${c.item.allprice }</td>
            </tr>
      </s:iterator>  
          <tr>
            <td colspan="7">
              总金额:${sum }
            </td>
          </tr>
        </table>
        
          <a href="javascript:void(0);" class="Button">&lt;&lt; 上一页</a>
       
          <a href="javascript:void(0)" class="Button">下一页&gt;&gt;</a>
        
        <a class="Button" href="<%=basePath %>/order/NewOrderForm.jsp">继续</a>
      </td>
  

    </tr>
  </table>

</div>

<%@ include file="../common/IncludeBottom.jsp" %>





