<#import "/spring.ftl" as spring />
<!DOCTYPE html>
<html>
<#setting date_format="M/dd/yy">
	<head>
	<meta charset="UTF-8">
	<title>Add Events</title>
	</head>
	<body>
	<form method='post'>
		Event Name: <@spring.formInput "event.name"/><br><br>
		Date: <@spring.formInput "event.date" "" "date"/> <br><br>
		Creator:<@spring.formInput "event.creator"/> <br><br>
		<button>Add</button>
	</form>
	</body>
</html>