<%@ include file="header.jsp" %>
<style>
.register-form{
	display:flex;
	flex-direction:column;
	border-radius:0.25rem;
	border:0.1rem solid #ddd;
	padding: 1rem;
	min-width: 400px;
	align-self: center;
}
.input2{
margin: 0.25rem 0rem;
padding: 0.5rem 1rem;
background-color: #d2d2d2;
border-radius: 0.25rem;
border:0;
}
.input2:invalid{
background-color: #ffd2d2;
}
.action-button{
	color:#fff;
	border:0;
	align-self: center;
	padding:0.5rem 1rem;
	background-color: #d2d2d2;
	font-size: 1.1rem;
	font-weight: 300;
	border-radius: 0.25rem;
}
.input2:focus{
	outline: none;
	border:0;
	box-shadow: 2px 2px 4px rgba(0,0,0,0.2);
}
.action-button:hover{
	box-shadow: 2px 2px 4px rgba(0,0,0,0.2);
}
.input-container{
	display: grid;
	grid-gap: 1rem 0.5rem;
}
.label{
	display:grid;
}
.grid-col-2{
	display:grid;
	grid-template-columns: auto auto;
	grid-gap: 0.5rem;
}
</style>
<div class="top-container">
	<form action="register" method="post" class="register-form shadow">
		<h2 style="color:#d2d2d2;">New User Register</h2>
		<br><br>
		<div class="input-container">
		<div class="grid-col-2">
			<label for="last-name" class="label">First Name: 
			<input class="input2" type="text" id="last-name" name="first_name" required pattern="[a-zA-Z]{3,30}" title="should contain only alphabets"/> 
			</label>
			<label for="first-name" class="label">Last Name: 
			<input class="input2" type="text" id="first-name" name="last_name" pattern="[a-zA-Z]{3,30}" title="should contain only alphabets"/> 
			</label>
		</div>
			<label for="mobile" class="label">Mobile: 
			<input class="input2" type="text" id="mobile" name="mobile" required pattern="[0-9]{10}" title="should contain 10 digits"/> 
			</label>
			<label for="email" class="label">Email: 
			<input class="input2" type="email" id="email" name="email" required/> 
			</label>
		<div class="grid-col-2">
			<label for="password" class="label">Password:
			<input class="input2" type="password" id="password" name="password" required minlength="8" maxlength="30" /> 
			</label>
			<label for="confirm_password" class="label">Confirm Password:
			<input class="input2" type="password" id="confirm_password" name="confirm_password" required minlength="8" maxlength="30"/> 
			</label>
		</div>	
		</div>
			<br><br> 
			<input class="action-button" type="submit" value="Register" />
	</form>
</div>

<%@ include file="footer.jsp" %>
<script>
var password = document.getElementById("password");
var confirm_password = document.getElementById("confirm_password");

function validatePassword(){
if(password.value != confirm_password.value) {
  confirm_password.setCustomValidity("Passwords Don't Match");
} else {
  confirm_password.setCustomValidity('');
}
}
password.onchange = validatePassword;
confirm_password.onkeyup = validatePassword;
</script>