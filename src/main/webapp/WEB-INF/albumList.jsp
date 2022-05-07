<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Albumlist</title>
</head>
<body>

<h1>Albumlist</h1>

<table>
    <thead>
        <tr><th>Albums</th></tr>
    </thead>
    <tbody>
    	<c:forEach items="${ albums }" var="album">
	        <tr>
	        	<td>
	        		${ album.getTitle() }
	        	</td>
	        </tr>
        </c:forEach>
    </tbody>
</table>
	
</body>
</html>