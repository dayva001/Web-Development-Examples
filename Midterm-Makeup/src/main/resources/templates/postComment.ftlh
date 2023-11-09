<#import "/spring.ftl" as spring />
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Create a Post</title>
	</head>
	<body>
		<form method="post">
			
			Your Name: <@spring.formInput "comment.commenter"/><br><br>
			Your Answer: <@spring.formInput "comment.content"/><br>
			<@spring.formHiddenInput "comment.timestamp"/>
			<button>Post</button>
		</form>

</body>
</html>