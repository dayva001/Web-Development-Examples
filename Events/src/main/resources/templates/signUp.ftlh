<#import "/spring.ftl" as spring />
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Sign Up</title>
	</head>
	<body>
		<form method='post'>
			<input type="hidden" id="id1" name="id1" value="${event.id}">
			<input type="hidden" id="id2" name="id2" value="${item.id}">
			Name: <input type="text" id="name" name="name"><br><br> 
			<button>Sign Up</button>
		</form>
	</body>
</html>