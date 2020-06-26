<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Vaga"%>
<%@page import="modelo.VagaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    try {
        String nome = (String) session.getAttribute("nome");
        if (nome.equals("") || nome.isEmpty()) {
            out.print("<script type='text/javascript'>");
            out.print("alert('Por Favor, Digite as informações necessárias para o acesso!');");
            out.print("location.href=('index.jsp');");
            out.print("</script>");
        } else {
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
        <script src="plugins/jQuery/jquery-2.2.3.min.js"></script>
        <script src="js/config.js"></script>
        <link rel="stylesheet" href="dist/css/AdminLTE.min.css">
        <link rel="stylesheet" href="dist/css/skins/_all-skins.min.css">
        <link rel="stylesheet" type="text/css" href="css/estilo2.css">
    </head>
    <body class="hold-transition skin-blue sidebar-mini">
        <div class="wrapper">
            <header class="main-header">
                <!-- Logo -->
                <a href="tag_setor_a.jsp" class="logo">
                    <span class="logo-lg"><b>Ardu</b>Park</span>
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
                                <li class="active"><a href="tag_setor_a.jsp"><i class="fa fa-circle-o"></i> Setor A - Piso 1</a></li>
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
                <div class="box box-warning">
                    <div class="box-header with-border">
                        <h3 class="box-title">Dúvidas</h3>
                    </div>
                    <div class="box-body"> 
                        <b>Quem Somos?</b>
                        <p>Somos uma empresa desenvolvedora de softwares que possui um serviço de criação e suporte de sistemas para estacionamento,
                            atendendo a todos os tipos de clientes, desde a grandes empresas até pequenas, auxiliando-os e criando soluções que atenda 
                            todos os devidos pedidos e requisitos dos clientes.</p>
                        <br>
                        <b>GoPark Mobile</b>
                        <p>Um dos aplicativos que nossa empresa oferece é o GoPark Mobile, que vai desde a estrutura montada no estacionamento do cliente,
                            até um aplicativo fornecedo aos usuários do mesmo, possuindo um acesso gratuito e sem necessidade de login ou registro, sendo completamente
                            intuitivo, o mapeamento das vagas é feito uma por uma para facilitação do encontro das mesmas</p>  
                        <br>    
                        <b>GoPark para Gestão</b>
                        <p>Esse sistema é exclusivo para funcionários do estacionamento assinante, contendo ferramentas que tornam a gestão do estacionamento mais
                            intuitiva e organizada, trabalhando com níveis de acesso e garantindo a segurança dos dados.</p> 
                        <br>    
                        <b>GoPark para Gestão</b>
                        <p>Esse sistema é exclusivo para funcionários do estacionamento assinante, contendo ferramentas que tornam a gestão do estacionamento mais
                            intuitiva e organizada, trabalhando com níveis de acesso e garantindo a segurança dos dados.</p> 
                        <b>Detalhes Técnicos</b>
                        <p>GoPark é um sistema com duplo serviço que supre as necessidades de gestão e controle administrativo de estacionamentos, além de possuir 
                            um serviço para usuários do mesmo, que os auxiliam para o uso e facilidade para estacionar e permanecer no estacionamento.</p>
                        <p>Possuindo uma arquitetura WEB desenvolvida na linguagem JAVA EE, uma linguagem que possui como principal característica o uso da programação 
                            orientação a objetos POO, que torna mais dinâmica e efetiva a criação do sistema, contém níveis de acesso para garantir a segurança das informações 
                            contidas no sistema, usando então, a metodologia MVC - Model View Control (Modelo Visão Controle) - Todas as funcionalidades vistas pelos usuários do 
                            sistema são desenvolvidas na visão, de acordo com o uso, mudanças e configurações feitas pelos mesmos, gerenciamentos e validações do sistema são feitos 
                            na camada de Controle, que depois de serem devidamente tratadas são enviadas para a camada de Modelo, na qual são feitas as alterações diretas no Banco 
                            de Dados do sistema, que é usado para armazenar os dados usando a linguagem SQL, utilizando a ferramenta XAMPP (X, Apache, MySQL, PHP), que permite a 
                            criação de um servidor local e administração direta do Banco de Dados pelos desenvolvedores.</p>
                        <p>O Sistema também possui a eletrônica que foi devidamente desenvolvida em Arduino que utiliza como base as liguagens C/C++, a estrutura possui o 
                            microcontrolador Arduino Mega 2560, sensores ultra-sônicos, leds RGB e placa de rede ENC28J60.</p>
                        <p>Com o propósito de facilitar a usabilidade e aumentar a interatividade dos usuários do sistema, foram usadas ferramentas de suporte visual e dinâmico, 
                            normalmente são chamadas de FrameWorks, como: Twitter Bootstrap, FontAwesome, Dist e Jquery. Também foi usado o AdminLTE, um modelo popular de Web Preset 
                            de código aberto para painéis de administração e controle.</p>  
                    </div>
                </div>    
            </div>
            <footer class="main-footer">
                <div class="pull-right hidden-xs">
                    <b>Alpha</b> 1.0
                </div>
                <strong>Copyright &copy; 2019 <span style="color: 3c8dbc;">GoPark</span>.</strong> All rights
                reserved.
            </footer>
        </div>
    </div>
    <script src="plugins/jQuery/jquery-2.2.3.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <script src="dist/js/app.min.js"></script>
</body>
</html>
<%
        }
    } catch (Exception e) {
        out.print("<script type='text/javascript'>");
        out.print("alert('Por Favor, Digite as informações necessárias para o acesso!');");
        out.print("location.href=('index.jsp');");
        out.print("</script>");
    }
%>