<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >

<%@ page import="bean.Tuntikirjaus"%>
<jsp:useBean id="kirjaukset" type="java.util.ArrayList<Tuntikirjaus>" scope="request" />

<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

<meta charset="UTF-8">
<title>Placeholder</title>

<link href="blogPostStyle.css" rel="stylesheet" type="text/css">
</head>

<body>
<div id="mainwrapper">
  <header> 
  <nav> 
  <a href="logout" title="Link">Logout</a> </nav> 
  </header>
  <div id="content">    

    <section id="mainContent"> 

     <div id="menulista">
     <h4>Hallinnoi pizzoja</h4>
     <div id="frm">
     <button type="button" onclick="location.href='lisaa-kirjaus';">Add</button>
     <button type="button" onclick="location.href='hallinnoi-tayte';">H</button>
     </div>
     <form method="post">
     <table class="hallinnoi-pizzat" style="width:auto">
 			<tr>
				<td>Id</td>
				<td>Selite</td>
				<td>Tuntimäärä</td>
				<td>Pvm</td>
				<td></td>
				<td></td>
			</tr>
		
			<%for(Tuntikirjaus tuntikirjaus : kirjaukset) {%>
		
			<tr>
				<td><%=tuntikirjaus.getTuntikirjaus_id()%></td>
				<td><%=tuntikirjaus.getSelite()%></td>
				<td><%=tuntikirjaus.getTuntimaara()%></td>
				<td><%=tuntikirjaus.getPvm()%></td>
				<td>
				<button type="button" onclick="location.href='muokkaa-kirjaus?kirjaus_valinta=<%=tuntikirjaus.getTuntikirjaus_id()%>';">Muokkaa</button>
				</td>
				<td>
				<button type="button" onclick="location.href='poista-kirjaus?kirjaus_valinta=<%=tuntikirjaus.getTuntikirjaus_id()%>';">Poista</button>
				</td>
			</tr>
			<% } %>
	</table>
	</form>
	
	</div>
    </section>
    
    <section id="sidebar">  
      
    </section>
    
    <footer> 
      
    </footer>
  </div>
  <div id="footerbar"><!-- Small footerbar at the bottom --></div>
</div>
</body>
</html>
