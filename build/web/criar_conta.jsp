<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>GoPark | Criar Conta</title>
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
                    <div class="form-group has-feedback">
                        <input type="usuario" class="form-control" placeholder="Nome de Usuário">
                        <span class="fa fa-user form-control-feedback"></span>
                    </div>
                    <div class="form-group has-feedback">
                        <input type="usuario" class="form-control" placeholder="Email">
                        <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
                    </div>
                    <div class="form-group has-feedback">
                        <input type="senha" class="form-control" placeholder="Senha">
                        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                    </div>
                    <div class="form-group has-feedback">
                        <input type="senha" class="form-control" placeholder="Confime a senha">
                        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                    </div>
                    <div class="row">
                        <div class="col-xs-12"> 
                            <button type="submit" class="btn btn-primary btn-block btn-flat">Criar Conta</button>
                            <center>
                                <br><a href="login.jsp">Voltar</a>
                            </center>
                        </div>
                    </div>
                </form>    
            </div>
        </div>
        <script src="plugins/jQuery/jquery-2.2.3.min.js"></script>
        <script src="bootstrap/js/bootstrap.min.js"></script>
        <script src="dist/js/app.min.js"></script>  
    </body>
</html>