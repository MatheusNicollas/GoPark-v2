<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Vaga"%>
<%@page import="modelo.VagaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String nome = (String) session.getAttribute("nome");

    if (nome == null) {
        out.print("<script type='text/javascript'>");
        out.print("alert('Por Favor, Digite as informações necessárias para o acesso!');");
        out.print("location.href=('index.jsp');");
        out.print("</script>");
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>GoPark</title>
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="plugins/font-awesome/css/font-awesome.min.css">
        <link rel="stylesheet" href="dist/css/AdminLTE.min.css">
        <link rel="stylesheet" href="dist/css/skins/_all-skins.min.css">
        <link rel="stylesheet" type="text/css" href="css/estilo3.css">
        <script>
            sessionStorage.vaga = "vaga0";
            var tempo_reload = window.setInterval(carrega, 1500);
            function carrega() {
                $.get("carrega_vagas.jsp", function (data) {
                    $('#vagas').html(data);

                    $("#" + sessionStorage.vaga).children("img").attr("src", "imagens/vaga-azul.png");
                });
            }
        </script>
        <script>
            var segundos = 0;
            var minutos = 0;
            var horas = 0;
            var minutos_inf = 0;
            var valor_por_minuto = 0.10;

            function start() {
                segundos = segundos + 1;
                if (segundos >= 60) {
                    minutos = minutos + 1;
                    minutos_inf = minutos_inf + 1;
                    segundos = 0;
                    if (minutos >= 60) {
                        horas = horas + 1;
                        minutos = 0;
                    }
                }

                if (segundos < 10) {
                    var m_segundos = "0" + segundos;
                } else {
                    var m_segundos = segundos;
                }

                if (minutos < 10) {
                    var m_minutos = "0" + minutos;
                } else {
                    var m_minutos = minutos;
                }

                if (horas < 10) {
                    var m_horas = "0" + horas;
                } else {
                    var m_horas = horas;
                }

                tempo.innerText = m_horas + ":" + m_minutos + ":" + m_segundos;

                var valor_total = (valor_por_minuto * minutos_inf).toFixed(2);
                valor.innerText = "R$ " + valor_total;

                setTimeout(start, 1000);
            }
        </script>    
    </head>
    <body onload="start();" class="hold-transition skin-blue sidebar-mini">
        <div class="wrapper">
            <header class="main-header">
                <!-- Logo -->
                <a href="tag_setor_a.jsp" class="logo">
                    <span class="logo-mini"><b>G</b>P</span>
                    <span class="logo-lg"><b>Go</b>Park</span>
                </a>
                <!-- Header Navbar: style can be found in header.less -->
                <nav class="navbar navbar-static-top">
                    <!-- Sidebar toggle button-->
                    <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
                        <span class="sr-only">Toggle navigation</span>
                    </a>

                    <div class="navbar-custom-menu">
                        <ul class="nav navbar-nav">
                            <li class="dropdown notifications-menu">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    <i class="fa fa-clock-o" aria-hidden="true"></i>
                                </a>
                                <ul class="dropdown-menu">
                                    <li class="header">
                                    <center>
                                        <b><u>Simulador de Pagamento</u></b>
                                    </center>
                            </li>
                            <li>
                                <ul class="menu">
                                    <li>
                                    <center>
                                        <i class="fa fa-clock-o text-blue" aria-hidden="true"></i>    
                                        <b>Tempo de Permanência:</b>
                                        <div id="tempo"></div>    
                                    </center>
                            </li>
                            <li>
                            <center>
                                <i class="fa fa-money text-green" aria-hidden="true"></i>
                                <b>Valor Total:</b>
                                <div id="valor"></div>
                            </center>
                            </li>
                        </ul>
                        </li>
                        </ul>
                        </li> 
                        <li class="dropdown notifications-menu">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <i class="fa fa-car" aria-hidden="true"></i>
                            </a>
                            <ul class="dropdown-menu">
                                <li class="header">
                                    <i class="fa fa-circle text-yellow"></i><b> Total de Vagas:</b>
                                        <%
                                            VagaDAO vDAO = new VagaDAO();
                                            out.println(vDAO.totalVagas());
                                        %>
                                    <hr>
                                    <i class="fa fa-circle text-green"></i><b> Vagas livres:</b>
                                        <%
                                            out.println(vDAO.vagasLivres());
                                        %>
                                    <br>
                                    <i class="fa fa-circle text-red"></i><b> Vagas Ocupadas:</b>
                                        <%
                                            out.println(vDAO.vagasOcupadas());
                                        %>
                                    <br>
                                    <i class="fa fa-times-circle-o text-red"></i><b> Vagas Interditadas:</b>
                                        <%
                                            out.println(vDAO.vagasInterditadas());
                                        %>
                                </li>
                            </ul>
                        </li>
                        <li class="dropdown user user-menu">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <i class="fa fa-user" aria-hidden="true"></i>
                                <span class="hidden-xs">
                                    <%
                                        out.println("Olá, " + nome);
                                    %>
                                </span>                  
                            </a> 
                            <ul class="dropdown-menu">
                                <li class="user-body">
                                <center> 
                                    <%
                                        out.println("Olá, " + nome);
                                    %> 
                                </center>
                        </li>
                        </ul>    
                        </li>
                        <li>
                            <a href="sair.jsp">
                                <i class="fa fa-sign-out"></i>                   
                            </a>
                        </li>
                        </ul>
                    </div>
                </nav>
            </header>
            <aside class="main-sidebar">
                <section class="sidebar">
                    <ul class="sidebar-menu">
                        <li class="header">LOCALIZAÇÃO</li>
                        <li class="treeview">
                            <a href="#">
                                <i class="fa fa-building" aria-hidden="true"></i>
                                <span>Locais</span>
                                <span class="pull-right-container">
                                    <i class="fa fa-angle-left pull-right"></i>
                                </span>
                            </a>
                            <ul class="treeview-menu">
                                <li class="active"><a href="tag_setor_a.jsp"><i class="fa fa-circle-o"></i> Taguatinga Shopping</a></li>
                                <li class="active"><a href="tag_setor_b.jsp"><i class="fa fa-circle-o"></i> Cidade</a></li>
                            </ul>
                        </li>
                        <li class="treeview">
                            <a href="#">
                                <i class="fa fa-map-marker" aria-hidden="true"></i>
                                <span>Setores</span>
                                <span class="pull-right-container">
                                    <i class="fa fa-angle-left pull-right"></i>
                                </span>
                            </a>
                            <ul class="treeview-menu">
                                <li class="active"><a href="tag_setor_a.jsp"><i class="fa fa-circle-o"></i> Cidade - Lado Central</a></li>
                            </ul>
                        </li>
                        <li class="header">OBJETOS VISUAIS</li>
                        <li><a href="#"><i class="fa fa-times-circle-o text-red"></i> <span>  Vaga Interditada</span></a></li>
                        <li><a href="#"><i class="fa fa-circle-o text-red"></i> <span>Vaga Ocupada</span></a></li>
                        <li><a href="#"><i class="fa fa-circle-o text-green"></i> <span>Vaga Livre</span></a></li>
                        <li><a href="#"><i class="fa fa-circle-o text-aqua"></i> <span>Vaga Selecionada</span></a></li>

                        <li class="header">OUTRAS OPÇÕES</li>	
                        <li>
                            <a href="suporte.jsp">
                                <i class="fa fa-flag" aria-hidden="true"></i>
                                <span>Suporte</span>
                            </a>
                        </li>
                        <li>
                            <a href="manutencao.jsp">
                                <i class="fa fa-th"></i> <span>Sobre</span>
                            </a>
                        </li>
                        <li>
                            <a href="manutencao.jsp">
                                <i class="fa fa-question-circle" aria-hidden="true"></i>
                                <span>Dúvidas</span>
                            </a>
                        </li>
                    </ul>
                </section>
                <!-- /.sidebar -->
            </aside>
            <!-- Content Wrapper. Contains page content -->
            <div class="content-wrapper">
                <div id="fundo">	
                    <img src="css/estacionamento2.png">
                </div>	
                <div id="vagas"></div> 
            </div>
            <footer class="main-footer">
                <div class="pull-right hidden-xs">
                    <b>Alpha</b> 1.0
                </div>
                <strong>Copyright &copy; 2019 <span style="color: 3c8dbc;">GoPark</span>.</strong> All rights
                reserved.
            </footer>
        </div>
        <script src="plugins/jQuery/jquery-2.2.3.min.js"></script>
        <script src="bootstrap/js/bootstrap.min.js"></script>
        <script src="dist/js/app.min.js"></script>  
        <script>
        var vagaClicada = function (div) {
            
            if (sessionStorage.vaga === div.id)
                sessionStorage.vaga = "vaga0";
            else
                sessionStorage.vaga = div.id;
        };
        </script>  
        <style>
            .vaga:hover {
                cursor: pointer;
            }
        </style>
    </body>
</html>
