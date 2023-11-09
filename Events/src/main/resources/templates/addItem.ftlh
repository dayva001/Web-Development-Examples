<#import "/spring.ftl" as spring />
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Add Items to ${event.name}</title>
	</head>
	<body>
		<form method='post'>
			<@spring.formHiddenInput "event.id"/>
			Item Name: <@spring.formInput "item.name"/><br><br>
			Amount: <@spring.formInput "item.amount" "step=1" "number"/> <br><br>
			Bringer:<@spring.formInput "item.bringer"/> <br><br>
			<button>Add</button>
		</form>
	</body>
</html>