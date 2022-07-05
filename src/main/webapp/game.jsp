<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Game 21</title>
</head>
<body>
<form method=post>
    Player Points:  ${playerScore}
    <br>
    Server Points: ${serverScore}
    <br>
    <input type="submit" name="take" value="Take card">
    <input type="submit" name="pass" value="Pass">
</form>
</body>
</html>
