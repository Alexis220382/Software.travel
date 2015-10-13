<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <script type="text/javascript" src="js/Ajax.js"></script>
    <link rel=stylesheet type="text/css" href="css/style.css">
</head>
<body>
<h3 align="center">Ввод в текстовое поле вручную</h3>
<form action="/hand.form">
    <div align="center">
    <input type="text" name="textfield" size="30" value="${fromFile}${fromDB}${result}" />
    <input type="submit" name="fromfield" value="Calculate and send to file" />
    </div>
</form>
<h3 align="center">Ввод в текстовое поле из файла</h3>
<form action="/fromFile.form">
    <div align="center">
        <input type="submit" name="fromfile" value="Get formula" />
    </div>
</form>
<h3 align="center">Ввод в текстовое поле из базы данных</h3>
<form action="/fromDB.form">
    <div align="center">
        <h6>Введите номер формулы от 0 до 9</h6>
        <input type="text" name="number" size="1" pattern="[0-9]{1}"/>
        <input type="submit" name="fromDB" value="Get formula" />
    </div>
</form>
</body>
</html>
