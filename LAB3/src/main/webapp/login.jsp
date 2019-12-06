<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Войти</title>
</head>
<body>

<h1>Введите логин и пароль для входа</h1>
${message}
<form method="POST">
    <label for="login">Логин:</label>
    <input id="login" type="text" placeholder="введите логин" name="login" required>
    <p><label for="password">Пароль:</label>
    <input id="password" type="password" placeholder="введите пароль" name="password" required></p>
    <p><input type="submit" value="Ввод"></input></p>
    <input type="hidden" name="hash" value=${hashNum}>
</form>
</body>
</html>