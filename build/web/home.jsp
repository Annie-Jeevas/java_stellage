<%@page import="model.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>



<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%--
    This file is an entry point for JavaServer Faces application.
--%>

    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <link href="wrapper.css" rel="stylesheet"/>
            <title>StellAge</title>
        </head>

        <body>
            
            <div class="wrapper_body_1">
                <% for (int i = 0; i<2;i++){%>
                <div class="cbm_wrap ">
                    <h1>Волшебная зима</h1>
                    <img src="https://pp.vk.me/c636522/v636522049/3a8de/vndy5poFObM.jpg">
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam luctus consectetur 
                        dolor a porttitor. Curabitur id sem sed ante fringilla pulvinar et id lectus. 
                        Nullam justo ipsum, hendrerit ut commodo nec, pellentesque nec erat. Pellentesque pharetra.</p>
                    <br />
                    <a href="http://www.designshock.com/">DesignShock.com </a>
                </div>
                <%}%>
            </div>
           

        </body>
    </html>
