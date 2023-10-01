<%-- 
    Document   : login
    Created on : Apr 6, 2023, 11:39:43 PM
    Author     : ishara
--%>

    <%@page contentType="text/html" pageEncoding="UTF-8"%>
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="UTF-8">
            <title>EMP Manager / Login</title>
            <link type="text/css" rel="stylesheet" href="styles/login.css" />
            <link rel="preconnect" href="https://fonts.googleapis.com">
            <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
            <link href="https://fonts.googleapis.com/css2?family=Rubik:wght@700&display=swap" rel="stylesheet">
        </head>

        <body>
            <div class="box-outer">
                <div class="box-body-inner">
                    <br/>
                    <br/>
                    <br/>
                    <br/>
                    <div class="head-1">
                        <h1 class="login-head">Login</h1>
                    </div>
                    <div class="inner">
                        <form id="login" class="data-input-form" method="post" action="check_login">
                            <br/>
                            <br/>
                            <input type="text" class="user-input-field" placeholder="Username" name="username" autocomplete="off" required />
                            <br/>
                            <input type="password" class="user-input-field" placeholder="Password" name="pswd" autocomplete="off" required />
                            <br/>
                            <button type="submit" class="submit-button">Login</button>
                            <br/>
                            <br/>
                            <a href="index.jsp" class="anchorTag">Back to Home</a>
                            <br/>
                            <br/>
                            <a href="manager_register.jsp" class="anchorTag">Don't Have An Account? Signup</a>
                        </form>
                    </div>
                </div>
            </div>
            <script type="text/javascript" src="js/login.js"></script>
        </body>

        </html>