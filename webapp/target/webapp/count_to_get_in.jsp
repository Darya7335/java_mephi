<%--
  Created by IntelliJ IDEA.
  User: darya
  Date: 27.09.2019
  Time: 14:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<head>
    <meta charset="UTF-8">
    <title>count_to_get_in</title>
</head>

<style>
    <%@include file='Style.css' %>
</style>


<form action="" method="POST" class="activation">
    <div class="form-inner">
        <h2>Найди сумму чисел ${num1} и ${num2} (${(num1 + num2)})</h2>
        <div class="form-content">
            <h3>Ваш ответ:</h3>
            <p><input id="answer" type="number" name="answer"></p>
            <p><input type="submit" value="Ввод"></p>
        </div>
    </div>
    <input type="hidden" name="hash" value=${hashNum}>
</form>
