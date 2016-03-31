<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >

<%@ page import="tuntiprojekti.model.Henkilo"%>
<jsp:useBean id="henkilot" type="java.util.ArrayList<Henkilo>" scope="request" />

<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

<meta charset="UTF-8">
<title></title>

<link href="blogPostStyle.css" rel="stylesheet" type="text/css">
<!--The following script tag downloads a font from the Adobe Edge Web Fonts server for use within the web page. We recommend that you do not modify it.--><script>var __adobewebfontsappname__="dreamweaver"</script><script src="http://use.edgefonts.net/montserrat:n4:default;source-sans-pro:n2:default.js" type="text/javascript"></script>


</head>

<body>
<div id="mainwrapper">
  <header> 
   
  </header>
  <div id="content">    

    <section id="mainContent"> 

     <div id="lista">
     <h2>Lisää työtunnit</h2>
<!-- Lisää henkilö -->

			<form method="post">
			<table class="lisaa-henkilo">
				<tr>
					<td>Etunimi:</td>
					<td><input type="text" 
					value=""
					name="hlo_etunimi" size="50"  />
					</td>
				</tr>
				<tr>
					<td>Sukunimi:</td>
					<td><input type="text" 
					value=""
					name="hlo_sukunimi" size="50"  />
					</td>
				</tr>
				<tr>
					<td>Tuntimäärä:</td>
					<td><input type="text" 
					value=""
					name="hlo_tunnit" size="50"  />
					</td>
				</tr>
				<tr>
					<!-- <td>
						<div>
							<button type="button" class="button-grey" onclick="location.href='hallinnoi-tayte';">Peruuta</button>
						</div>
					</td> -->
					<td>
						<input type="submit" class="button-primary" name="submit-button" class="submit-button" value="Tallenna" />
					</td>
				</tr>	
			</table>
			</form>
			<table class="hallinnoi-tayte" style="width:auto">
			<tr>
				<td>Id</td>
				<td>Etunimi</td>
				<td>Sukunimi</td>
				<td>Tunnit</td>
				<td>Pvm</td>
			</tr>
			<%for(int i = 0; i < henkilot.size(); i++) {%>
		
			<tr>
				<td><%=henkilot.get(i).getHlo_id()%></td>
				<td><%=henkilot.get(i).getHlo_etunimi()%></td>
				<td><%=henkilot.get(i).getHlo_sukunimi()%></td>
				<td><%=henkilot.get(i).getHlo_tunnit()%></td>
				<td><%=henkilot.get(i).getHlo_pvm()%></td>
			</tr>
			<% } %>
     	</table>
	
	</div>
    </section>

    <footer> 
      
    </footer>
  </div>
  <div id="footerbar"><!-- Small footerbar at the bottom --></div>
</div>
</body>
</html>
