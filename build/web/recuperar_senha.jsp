<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>GoPark | Login</title>
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="plugins/font-awesome/css/font-awesome.min.css">
        <link rel="stylesheet" href="dist/css/AdminLTE.min.css">
        <link rel="stylesheet" href="dist/css/skins/_all-skins.min.css">
        <link rel="stylesheet" type="text/css" href="css/estilo2.css">
        <style>
            body{
                background-color: #93b3ca;
            }
        </style>
    </head>
    <body >
        <div class="login-box">
            <br><br><br><br><br>
            <div id="logo">
                <img src="imagens/logo_login.png" width="110" height="110">
            </div>
            <div class="login-box-body">
                <form action="#" method="post">
                    <br><br> 
                    <div class="row">
                        <div class="col-xs-12"> 
                            <div class="form-group has-feedback">
                                <p class="login-box-msg">Digite o email da conta que deseja que a senha seja recuperada, enviaremos uma mensagem de confirmação para o mesmo.</p>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-9"> 
                            <input type="usuario" class="form-control" placeholder="Email">
                        </div>
                        <div class="col-xs-3">  
                            <button type="submit" class="btn btn-primary btn-block btn-flat">Enviar</button><br>
                        </div>
                        <center>
                            <a href="login.jsp">Voltar</a>
                        </center>
                    </div>
                </form>    
            </div>
        </div>
        <script src="plugins/jQuery/jquery-2.2.3.min.js"></script>
        <script src="bootstrap/js/bootstrap.min.js"></script>
        <script src="dist/js/app.min.js"></script>  
    </body>
</html>