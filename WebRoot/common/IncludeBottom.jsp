<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="org.apache.struts2.ServletActionContext"%>


<%
	HttpServletRequest requestnn=ServletActionContext.getRequest();
	
	HttpSession sessionn=requestnn.getSession();
	
	String favcategroy=(String)sessionn.getAttribute("favcategroy");
		
	String banneropt=(String)sessionn.getAttribute("banneropt");

		
 %>


<html>

<body>

<div id="Footer">

  <div id="PoweredBy">
    <a href="http://ibatis.apache.org"><img src="./images/poweredby.gif"/></a>
  </div>

<%
	if(banneropt!=null&&!banneropt.equals("0")){
			
			if(favcategroy.equals("CATS")){
	%>		
				<div id="Banner">
	  				<img src="images/banner_cats.gif" />
	  			</div>	
	<% 		
			}
			if(favcategroy.equals("DOGS")){
	%>		
				<div id="Banner">
	  				<img src="images/banner_dogs.gif" />
	  			</div>
	<%		
			}
			if(favcategroy.equals("FISH")){
	%>		
				<div id="Banner">
	  				<img src="images/banner_fish.gif" />
	  			</div>
			
	<%		
			}
			if(favcategroy.equals("BIRD")){
	%>		
				<div id="Banner">
	  				<img src="images/banner_birds.gif" />
	  			</div>		
	<%		
			}
			if(favcategroy.equals("REPTILES")){
	%>		
				<div id="Banner">
	  				<img src="images/banner_reptiles.gif" />
	  			</div>
	<%		
			}
	%>	
		
	
<%	
	
	}else{
%>	
	<div id="Banner">
  
  </div>
	
<%	
	}
 %>


  

</div>

</body>
</html>