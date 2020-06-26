<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Vaga"%>
<%@page import="modelo.VagaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <link rel="stylesheet" type="text/css" href="css/estilo2.css">
    </head>
    <body class="hold-transition skin-blue sidebar-mini">
        <div class="wrapper">
            <header class="main-header">
                <!-- Logo -->
                <a href="#" class="logo">
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
                                          <i class="fa fa-exclamation-triangle text-red" aria-hidden="true"></i><br>
                                          Para inicar a contagem selecione a vaga estacionada! <br>--Basta clicar sobre a vaga--
                                      </center>
                                  </li>
                                  <li>
                                  <ul class="menu">
                                      <li>
                                          <center>
                                          <b>Tempo de Permanência:</b><br>
                                              <i class="fa fa-clock-o text-blue" aria-hidden="true"></i> 00:00 h
                                          </center>
                                      </li>
                                      <li>
                                          <center>
                                              <b>Valor Total:</b><br>
                                              <i class="fa fa-money text-green" aria-hidden="true"></i> R$ 00,00
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
                                        <br>
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
                                        <br>
                                    </li>
                                </ul>
                            </li>
                            <li class="dropdown user user-menu">
                                <a href="#">
                                    <i class="fa fa-user" aria-hidden="true"></i>
                                    <span class="hidden-xs"><%
                                        String nome = (String) session.getAttribute("nome");
                                        out.println("Olá, " + nome);
                                        %></span>
                                </a>
                            </li>
                            <li>
                                <a href="index.jsp">
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
                                <span>Reportar Problemas</span>
                            </a>
                        </li>
                        <li>
                            <a href="sobre.jsp">
                                <i class="fa fa-th"></i> <span>Sobre</span>
                            </a>
                        </li>
                        <li>
                            <a href="duvidas.jsp">
                                <i class="fa fa-question-circle" aria-hidden="true"></i>
                                <span>Dúvidas</span>
                            </a>
                        </li>
                    </ul>
                </section>
            </aside>
            <div class="content-wrapper">
                <section class="content">
                    <div class="error-page">
                        <h2 class="headline text-yellow"> <br>=/</h2>
                        <div class="error-content">
                            <br><br><br><br><br><br><br>
                            <h3><i class="fa fa-warning text-yellow"></i> Oops! Estamos trabalhando nisso!</h3>
                            <p>
                                O conteúdo acessado ainda está sendo implementado <a href="tag_setor_a.jsp">voltar</a>
                            </p>
                        </div>
                    </div>
                </section> 
            </div>
            <!-- /.content-wrapper -->
            <footer class="main-footer">

            </footer>
            <div class="control-sidebar-bg"></div>
        </div>
        <script src="plugins/jQuery/jquery-2.2.3.min.js"></script>
        <script src="bootstrap/js/bootstrap.min.js"></script>
        <script src="dist/js/app.min.js"></script>  
    </body>
</html>
