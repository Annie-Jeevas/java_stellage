<%-- 
    Document   : my_books
    Created on : 03.12.2016, 16:18:31
    Author     : Анюта
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:h="http://xmlns.jcp.org/jsf/html">
    <h:head>
        <link href="wrapper.css" rel="stylesheet"/>
        <link rel="stylesheet" type="text/css" href="css/normalize.css" />
        <link rel="stylesheet" type="text/css" href="css/demo.css" />
        <link rel="stylesheet" type="text/css" href="css/component.css" />
        <link href="style.css" rel="stylesheet" type="text/css" media="screen" /> 

        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.1/jquery.min.js" type="text/javascript"></script> 
        <script src="js/animate-bg.js" type="text/javascript"></script> 
        <script src="js/scripts.js" type="text/javascript"></script> 
        <script src="js/modernizr.custom.js"></script>
        <title>StellAge</title>
    </h:head>

    <h:body>
        <div id="container_menu"> 
            <ul id="nav"> 
                <li><a href="real_home.jsp">Главная</a></li> 
                <li><a href="user_profile.jsp">Кабинет</a></li> 
                <li><a href="#">Бан</a></li>                 
            </ul> 
        </div> 
        <div class="container">
            <header class="color-8">
                <nav class="cl-effect-14">
                    <a href="home.jsp" class="button24">Мой кабинет</a>
                    <a href="user_profile.jsp"><span data-hover="Ссылка 2">Войти</span></a>

                </nav>
            </header>
        </div>
        <header id="header">
            Электронная библиотека "Стеллаж"
        </header>
        <h1 class="ahref">Мои книги</h1>
        <table>
            <tr>
                <td>Название</td>
                <td>Автор</td>
                <td>Год</td>
                <td>Страниц</td>
            </tr>
            <tr>
                <td>Гарри Потттер и Принц-полукровка</td>
                <td>Д.Роулинг</td>
                <td>2006</td>
                <td>961</td>
            </tr>
        </table>
    </h:body>
</html>
