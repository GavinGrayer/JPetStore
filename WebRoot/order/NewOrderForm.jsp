<%@ include file="../common/IncludeTop.jsp" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div id="Catalog">

  <form action="OrderAction"  method="post">

    <table>
      <tr><th colspan=2>
   付款详情
      </th></tr><tr>
    <td>付款方式:</td><td>
          <select name="orders.cardtype">
       <option>维萨信用卡</option>
        <option>万事达信用卡</option>
         <option>美国运通信用卡</option>
      </select></td>
  </tr><tr>
      <tr><td>
        信用卡号码:</td><td><input type="text" name="orders.creditcard" value="9999 9999 9999"/>
        * 用一个假的号码!
      </td></tr>
      <tr><td>
        终止日期 (MM/YYYY):</td><td><input type="text" name="orders.exprdate" value="12/03" />
      </td></tr>
      <tr><th colspan=2>
    账单地址
      </th></tr>

      <tr><td>
       姓名:</td><td><input type="text" name="orders.account.userid" value="j2ee" />
      </td></tr>
      <tr><td>
       地址1:</td><td><input type="text" size="40" name="orders.shipaddr1" value="南通市崇川区青年东路" />
      </td></tr>
      <tr><td>
      地址2:</td><td><input type="text" size="40" name="orders.billaddr1" value="南通市中南世纪花城" />
      </td></tr>
      <tr><td>
     城市: </td><td><input type="text" size="10" name="orders.billcity" value="南通市" />
      </td></tr>
      <tr><td>
    区、县:</td><td><input type="text" size="4" name="orders.account.status" value="崇川区" />
      </td></tr>
      <tr><td>
      邮政编码:</td><td><input type="text" size="10" name="orders.shipzip" value="212000" />
      </td></tr>
      <tr><td>
      国籍: </td><td><input type="text" size="15" name="orders.billcountry" value="中国" />
      </td></tr>

      <tr><td colspan=2>
        不同的送货地址...<input type="radio" name="flag" value="1"/> 是
        			 <input type="radio" name="flag" value="0"/> 否
      </td>
      
      
      
      </tr>

    </table>

    <input type="submit" name="submit" value="继续">

  </form>

</div>

<%@ include file="../common/IncludeBottom.jsp" %>