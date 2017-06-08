<%@ include file="../common/IncludeTop.jsp" %>
     <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div id="Catalog">

  <form action="ShippingFormAction"  method="post">

    <table>
      <tr><th colspan=2>
     送货地址
      </th></tr>

      <tr><td>
      姓名:</td><td><input type="text" name="orders.account.userid"  value="j2ee" />
      </td></tr>
      <tr><td>
       姓:</td><td><input type="text"  value="XYX" />
      </td></tr>
      <tr><td>
       地址1:</td><td><input type="text" size="40" name="orders.shipaddr1" value="901 San Antonio Road" />
      </td></tr>
      <tr><td>
    地址 2:</td><td><input type="text" size="40" name="orders.billaddr1" value="MS UCUP02-206" />
      </td></tr>
      <tr><td>
        城市: </td><td><input type="text" size="40" name="orders.billcity" value="Palo Alto" />
      </td></tr>
      <tr><td>
        州、邦:</td><td><input type="text" size="4" name="orders.account.status" value="CA" />
      </td></tr>
      <tr><td>
       邮政编码:</td><td><input type="text" size="10" name="orders.shipzip" value="94303" />
      </td></tr>
      <tr><td>
       国家: </td><td><input type="text" size="15" name="orders.billcountry" value="USA" />
      </td></tr>
	
	<input type="hidden" name="orders.cardtype" value="${orders.cardtype }"/>
	<input type="hidden" name="orders.creditcard" value="${orders.creditcard }"/>
	<input type="hidden" name="orders.exprdate" value="${orders.exprdate }"/>




    </table>

    <input type="submit" name="submit" value="继续">

  </form>

</div>

<%@ include file="../common/IncludeBottom.jsp" %>