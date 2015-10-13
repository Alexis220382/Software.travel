<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <script type="text/javascript" src="js/Ajax.js"></script>
    <link rel=stylesheet type="text/css" href="css/style.css">
</head>
<body background="images/bricks-12.gif">
<h3 align="center">Ввод в текстовое поле вручную</h3>
<h4 align="center">Binary формат</h4>
<form action="/hand2.form">
    <div align="center">
        <input type="text" class="textfield" name="textfield" size="30" value="${fromFile}${fromDB}${result2}" />
        <input type="submit" class="submit" value="Calculate and send to file" />
    </div>
</form>
<h4 align="center">Decimal формат</h4>
<form action="/hand10.form">
    <div align="center">
    <input type="text" class="textfield" name="textfield" size="30" value="${fromFile}${fromDB}${result10}" />
    <input type="submit" class="submit" value="Calculate and send to file" />
    </div>
</form>
<h4 align="center">Hex формат</h4>
<form action="/hand16.form">
    <div align="center">
        <input type="text" class="textfield" name="textfield" size="30" value="${fromFile}${fromDB}${result16}" />
        <input type="submit" class="submit" value="Calculate and send to file" />
    </div>
</form>
<h3 align="center">Ввод в текстовое поле из файла</h3>
<form action="/fromFile.form">
    <div align="center">
        <input type="submit" class="submit" value="Get formula" />
    </div>
</form>
<h3 align="center">Ввод в текстовое поле из базы данных</h3>
<form action="/fromDB.form">
    <div align="center">
        <h6>Введите номер формулы от 0 до 9</h6>
        <input type="text" class="textfield" name="number" size="1" />
        <input type="submit" class="submit" value="Get formula" />
    </div>
</form>
</body>
</html>
