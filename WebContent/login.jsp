<%@ include file="header.jsp" %>
<style>
.login-form{
	display:flex;
	flex-direction:column;
	border-radius:0.25rem;
	border:0.1rem solid #ddd;
	padding: 1rem;
	min-width: 300px;
	align-self: center;
}
.input1{
margin: 0.25rem 0rem;
padding: 0.5rem 1rem;
background-color: #adce74;
border-radius: 0.25rem;
border:0;
}
.action-button{
	border:0;
	align-self: center;
	padding:0.5rem 1rem;
	background-color: #adce74;
	color:#fff;
	font-size: 1.1rem;
	font-weight: 500;
}
.input1:focus{
	outline: none;
	border:0;
	box-shadow: 2px 2px 4px rgba(0,0,0,0.2);
}
.action-button:hover{
	box-shadow: 2px 2px 4px rgba(0,0,0,0.2);
}
</style>
<div class="top-container">
	<form action="login" method="post" class="login-form shadow">
		<h2 style="color:#adce74;">User Login</h2>
			<br>
			<label for="email">Email:</label> 
			<input class="input1" type="email" id="email" name="email" required/> 
			<br> 
			<label for="password">Password:</label>
			<input class="input1" type="password" id="password" name="password" required mixlength="30" minlength="8"/> 
			<br><br> 
			<input class="action-button" type="submit" value="Login" />
	</form>
</div>

<%@ include file="footer.jsp" %>
