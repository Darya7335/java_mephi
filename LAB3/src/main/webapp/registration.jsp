<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Регистрация</title>
</head>
<body>
<h1>Введите логин и пароль для регистрации</h1>
${message}
<form method="POST">
    <label for="login">Логин:</label>
    <input id="login" type="text" placeholder="Введите логин" name="login" required>
    <p><label for="password">Пароль:</label>
        <input id="password" type="password" placeholder="Введите пароль" name="password" required></p>
    <p><input type="submit" value="Ввод"></p>
</form>
</body>
</html>
