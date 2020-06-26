<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>GoPark | Login</title>
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="plugin/font-awesome/css/font-awesome.min.css">
        <link rel="stylesheet" href="dist/css/AdminLTE.min.css">
        <link rel="stylesheet" type="text/css" href="css/estilo2.css">
        <style>
            body{
                background-color: #93b3ca;
            }
        </style>
    </head>
    <body>
        <div class="login-box">
            <br>
            <br>
            <br>
            <br>
            <br>
            <div id="logo">
                <img src="imagens/logo_login.png" width="110" height="110">
            </div>
            <div class="login-box-body">
                <form action="login.jsp" method="post">
                    <br><br> 
                    <div class="form-group has-feedback">
                        <input type="text" class="form-control" name="nome" placeholder="Digite seu Nome">
                        <span class="fa fa-user form-control-feedback"></span>
                    </div>
                    <div class="form-group">
                        <select class="form-control" name="local">
                            <option>Selecione o Local</option>
                            <option>Cidade</option>
                            <option>Taguatinga Shopping</option>
                        </select>
                    </div>
                    <div class="row">
                        <div class="col-xs-12"> 
                            <button type="submit" class="btn btn-primary btn-block btn-flat">Entrar</button>
                        </div>
                    </div>
                </form>   
                <center>  
                    <span>Alpha 1.0</span>
                </center>    
            </div>
        </div>
        <script src="plugins/jQuery/jquery-2.2.3.min.js"></script>
        <script src="bootstrap/js/bootstrap.min.js"></script>
    </body>
</html>
