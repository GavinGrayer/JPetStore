<%@ include file="../common/IncludeTop.jsp" %>
  <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@taglib uri="/struts-tags" prefix="s"%>


<div id="Catalog">
<div id="BackLink">
  <a href="<%=basePath%>catalog/Main.jsp">返回主菜单</a>
</div>
<table>
<tr><th align="center" colspan="2">
  订单 号1000 2013/02/21 11:13:31 
</th></tr>
<tr><th colspan="2">
付款详情
</th></tr>
<tr><td>
  信用卡类型:</td><td>
 ${orders.cardtype}
</td></tr>
<tr><td>
信用卡号码:</td><td>${orders.creditcard } * 使用假号码!
</td></tr>
<tr><td>
 有效日期 (MM/YYYY):</td><td>${orders.exprdate }
</td></tr>
<tr><th colspan="2">
账单地址
</th></tr>
<tr><td>
  姓名:</td><td>${orders.account.userid }</td></tr>

<tr><td>
 地址 1:</td><td>${orders.shipaddr1 }
</td></tr>
<tr><td>
地址 2:</td><td>${orders.billaddr1 }
</td></tr>
<tr><td>
城市: </td><td>${orders.billcity }
</td></tr>
<tr><td>
区、县:</td><td>${orders.account.status } 
</td></tr>
<tr><td>
邮政编码:</td><td>${orders.shipzip } 
</td></tr>
<tr><td>
 国籍: </td><td>${orders.billcountry }
</td></tr>




<tr><th colspan="2">
收货地址
</th></tr><tr><td>
姓名:</td><td>${orders.account.userid }
</td></tr>
<tr><td>
  地址1:</td><td>${orders.shipaddr1 }
</td></tr>
<tr><td>
地址2:</td><td>${orders.billaddr1 }
</td></tr>
<tr><td>
城市: </td><td>${orders.billcity }
</td></tr>
<tr><td>
区、县:</td><td>${orders.account.status }
</td></tr>
<tr><td>
邮政编码:</td><td>${orders.shipzip } 
</td></tr>
<tr><td>
国籍: </td><td>${orders.billcountry }
</td></tr>
<tr><td>
邮政公司: </td><td>汇通快递
</td></tr>
<tr><td colspan="2">
  状态:已付款
</td></tr>
<tr><td colspan="2">
  <table>
    <tr>
      <th>商品编号</th>
      <th>产品描述</th>
      <th>数量</th>
      <th>价格</th>
      <th>总金额</th>
    </tr>
    
    
  <s:iterator value="cartList" var="c">  
   
      <tr>
        <td>${c.item.itemid }</td>
        <td>
           ${c.item.attr1 }${c.item.product.name }         
        </td>

        <td>${c.item.number }</td>
        <td>$${c.item.listprice }</td>
        <td>$${c.item.allprice }</td>
      </tr>
   </s:iterator> 

    <tr>
    
    
       <th colspan="5">总金额: $${sum } 
      </th>
    </tr>
  </table>
</td></tr>

</table>

</div>

<%@ include file="../common/IncludeBottom.jsp" %>



