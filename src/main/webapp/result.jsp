<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>End</title>
</head>
<body>
Player Points:  ${playerScore}
<br>
Server Points: ${serverScore}
<br>
<h1>${res}</h1>
<br>
<form method=post>
    <input type="submit" name="restart" value="Restart">
</form>
</body>
</html>
