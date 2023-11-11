<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mail Center </title>
<style>
* {
  box-sizing: border-box;
}
h2 .red-text {
    color: red;
  }

.column {
  float: left;
  width: 50%;
  padding: 5px;
}

/* Clearfix (clear floats) */
.row::after {
  content: "";
  clear: both;
  display: table;
}
</style>
</head>
<body>
   <h2 class="red-text" > Project: ContactDirecory !!  </h2>
   <i><h4>Contacts Saving made easy...</h4></i>
  	
  	<div class="row">
  <div class="column">
    <img src="images/directory.png" alt="directory" style="width:100%" height="50%">
  </div>
  <div class="column">
    <img src="images/directory2.png" alt="phonedirectory" style="width:100%" height="30%">
  </div>
  
</div>
   
   <ul>
  <li><a href="UserRegisteration.jsp">New Registration</a></li>
  <li><a href="login.jsp">login here</a></li>
  <!-- <li><a href="microservice.jsp">Integrated Micro Service</a></li>  -->
  
</ul>
</body>
</html>