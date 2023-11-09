<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>${event.name}</title>
	</head>
	<body>
		<div>
			Event: ${event.name}<br>
			Date: ${event.date}<br>
			Created by: ${event.creator}<br>
		</div>
		<div>
			<table border="1" cellspacing="2" cellpadding="5">
				<thead>
					<tr><th>Item</th><th>Amount</th><th>Brought By</th></tr>
				</thead>
				<tbody>
				<#list itemList>
					<#items as itemList>
						<tr>
							<td>${itemList.name}</td> <td>${itemList.amount}</td>
							<td>
							<#if itemList.bringer!="">	
									${itemList.bringer}
								<#else>
									<a href="${event.id}/signUp/${itemList.id}"><button>Sign Up</button></a>
							</#if>
							</td>
							<td><a href="${event.id}/deleteItem/${itemList.id}"><button>Delete</button></a></td>
						</tr>
					</#items>
				</#list>
				<tr>
					<td><a href="${event.id}/addItem">Add Item</a></td> <td></td> <td></td>
				</tr>
				</tbody>
			</table>
		</div>
		<br>
		<div><a href="/">Go Back</a></div>
	</body>
</html>