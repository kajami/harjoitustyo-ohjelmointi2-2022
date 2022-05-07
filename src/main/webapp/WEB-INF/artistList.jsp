<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Artistlist</title>
</head>
<body>

<h1>Artistlist</h1>

<form method="post">
   	<input name="artistName" type="text" required placeholder="type artist here..." autofocus /> 
   	<input type="submit" value="Add to list" />
</form>

<table>
    <thead>
        <tr><th>Artists</th></tr>
    </thead>
    <tbody>
    	<c:forEach items="${ artists }" var="artist">
	        <tr>
	        	<td>
	        		<a href="/albums?ArtistId=${ artist.getId() }"><c:out value="${ artist.getName() }"></c:out></a>
	        	</td>
	        </tr>
        </c:forEach>
    </tbody>
</table>
	
</body>
</html>