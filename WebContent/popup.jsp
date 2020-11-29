<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<style>
 #popup{
 min-width: 200px;
 max-width: 400px;
 position: absolute;
 top:0;
 left:50%;
 transform: translate(-50%,0);
 opacity:100%;
 padding : 0.5rem 1rem;
 margin-top: 1rem;
 background-color: #707070;
 color:#eee;
 box-shadow : 2px 2px 5px rgba(0,0,0,0.2);
 border-radius: 2px;
 transition : transform 0.5s ease-in-out, opacity 0.4s linear;
 }
</style>
<div id="popup">
<%= request.getAttribute("msg") %>
</div>
<script>
	setTimeout(()=>{
		var pop = document.getElementById("popup");
		pop.style.transform = "translate(-50%,-200%)";
		pop.style.opacity="0";
	},3000);
</script>