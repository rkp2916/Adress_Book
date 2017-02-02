<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title> Welcome to this page</title>
</head>
<body background= "welcome.jpg" />
<h1 align="center">Welcome to the contact Book:</h1>

<form name="login">
<label>Username: </label>
<input type="text" name="username"><br>
<label>Passsword: </label>
<input type="password" name="password"><br>
<input type= "Submit" onclick="check(this.form)">



</form>
<script language="javascript" >
            function check(form) 
            { 
                if(form.username.value == "rushi" && form.password.value == "rushi") 
                {
                   window.open('index.jsp')/*opens the target page while Id & password matches*/
                	/*self.location("index.jsp")*/
                	 	
                }
                
                else 
                {
                	window.open('home.jsp')/*displays error message*/
                	/*self.location('home.jsp')*/
                }
                
            }
</script>

</body>

</html>