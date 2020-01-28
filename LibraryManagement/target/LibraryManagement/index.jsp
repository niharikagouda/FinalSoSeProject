<html>


<head>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

</head>
<body>
	<h2 style="padding-left: 37%">Library Management Login</h2>
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

		
		
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

	<script type="text/javascript">
		/* function checkLogin() {
			var loginId = document.getElementById("loginID").value;
			var password = document.getElementById("password").value;
			
			var url = "http://localhost:8080/LibraryManagement/checkValidUser/"+loginId+"/"+password;
			
			console.log(url)
	
			$.ajax({
				url : url,
				type : "GET",
				success : function(data, textStatus, jqXHR) {
					alert(data)
					 if(data || data == 'true'){
						window.location = "pages/registration.html";
					} else{
						document.getElementById("error").innerHTML = "Invalid Login";
					} 
				},
				byebye
				error : function(jqXHR, textStatus, errorThrown) {
					alert(errorThrown)
					document.getElementById("error").innerHTML = "Invalid Login";
				}
			});
		} */
		
	</script>


	<!-- Body goes here -->
	<div class="container">
		<div class="row">
			<div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
				<div class="card card-signin my-5">
					<div class="card-body">
						<h5 class="card-title text-center">Sign In</h5>
						<form class="form-signin" name="loginForm" action="login" method="post">
							<div class="form-label-group">
								<input type="text" id="loginId" name="loginId" class="form-control"
									placeholder="Login Id" required autofocus> <label
									for="loginID">Login Id</label>
							</div>

							<div class="form-label-group">
								<input type="password" id="password" name="password" class="form-control"
									placeholder="Password" required> <label
									for="inputPassword">Password</label>
							</div>

							<div class="custom-control custom-checkbox mb-3">
								<input type="checkbox" class="custom-control-input"
									id="customCheck1"> <label class="custom-control-label"
									for="customCheck1">Remember password</label>
							</div>
							<button class="btn btn-lg btn-primary btn-block text-uppercase"
								type="submit">Sign in</button>
								
								
								
							<label id="error"></label>

						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
