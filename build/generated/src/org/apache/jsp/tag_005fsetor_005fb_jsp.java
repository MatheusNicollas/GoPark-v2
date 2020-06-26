package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import java.util.List;
import modelo.Vaga;
import modelo.VagaDAO;

public final class tag_005fsetor_005fb_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

    String nome = (String) session.getAttribute("nome");

    if (nome == null) {
        out.print("<script type='text/javascript'>");
        out.print("alert('Por Favor, Digite as informações necessárias para o acesso!');");
        out.print("location.href=('index.jsp');");
        out.print("</script>");
    }

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("        <title>GoPark</title>\n");
      out.write("        <meta content=\"width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no\" name=\"viewport\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"bootstrap/css/bootstrap.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"plugins/font-awesome/css/font-awesome.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"dist/css/AdminLTE.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"dist/css/skins/_all-skins.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/estilo3.css\">\n");
      out.write("        <script>\n");
      out.write("            sessionStorage.vaga = \"vaga0\";\n");
      out.write("            var tempo_reload = window.setInterval(carrega, 1500);\n");
      out.write("            function carrega() {\n");
      out.write("                $.get(\"carrega_vagas.jsp\", function (data) {\n");
      out.write("                    $('#vagas').html(data);\n");
      out.write("\n");
      out.write("                    $(\"#\" + sessionStorage.vaga).children(\"img\").attr(\"src\", \"imagens/vaga-azul.png\");\n");
      out.write("                });\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("        <script>\n");
      out.write("            var segundos = 0;\n");
      out.write("            var minutos = 0;\n");
      out.write("            var horas = 0;\n");
      out.write("            var minutos_inf = 0;\n");
      out.write("            var valor_por_minuto = 0.10;\n");
      out.write("\n");
      out.write("            function start() {\n");
      out.write("                segundos = segundos + 1;\n");
      out.write("                if (segundos >= 60) {\n");
      out.write("                    minutos = minutos + 1;\n");
      out.write("                    minutos_inf = minutos_inf + 1;\n");
      out.write("                    segundos = 0;\n");
      out.write("                    if (minutos >= 60) {\n");
      out.write("                        horas = horas + 1;\n");
      out.write("                        minutos = 0;\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("\n");
      out.write("                if (segundos < 10) {\n");
      out.write("                    var m_segundos = \"0\" + segundos;\n");
      out.write("                } else {\n");
      out.write("                    var m_segundos = segundos;\n");
      out.write("                }\n");
      out.write("\n");
      out.write("                if (minutos < 10) {\n");
      out.write("                    var m_minutos = \"0\" + minutos;\n");
      out.write("                } else {\n");
      out.write("                    var m_minutos = minutos;\n");
      out.write("                }\n");
      out.write("\n");
      out.write("                if (horas < 10) {\n");
      out.write("                    var m_horas = \"0\" + horas;\n");
      out.write("                } else {\n");
      out.write("                    var m_horas = horas;\n");
      out.write("                }\n");
      out.write("\n");
      out.write("                tempo.innerText = m_horas + \":\" + m_minutos + \":\" + m_segundos;\n");
      out.write("\n");
      out.write("                var valor_total = (valor_por_minuto * minutos_inf).toFixed(2);\n");
      out.write("                valor.innerText = \"R$ \" + valor_total;\n");
      out.write("\n");
      out.write("                setTimeout(start, 1000);\n");
      out.write("            }\n");
      out.write("        </script>    \n");
      out.write("    </head>\n");
      out.write("    <body onload=\"start();\" class=\"hold-transition skin-blue sidebar-mini\">\n");
      out.write("        <div class=\"wrapper\">\n");
      out.write("            <header class=\"main-header\">\n");
      out.write("                <!-- Logo -->\n");
      out.write("                <a href=\"tag_setor_a.jsp\" class=\"logo\">\n");
      out.write("                    <span class=\"logo-mini\"><b>G</b>P</span>\n");
      out.write("                    <span class=\"logo-lg\"><b>Go</b>Park</span>\n");
      out.write("                </a>\n");
      out.write("                <!-- Header Navbar: style can be found in header.less -->\n");
      out.write("                <nav class=\"navbar navbar-static-top\">\n");
      out.write("                    <!-- Sidebar toggle button-->\n");
      out.write("                    <a href=\"#\" class=\"sidebar-toggle\" data-toggle=\"offcanvas\" role=\"button\">\n");
      out.write("                        <span class=\"sr-only\">Toggle navigation</span>\n");
      out.write("                    </a>\n");
      out.write("\n");
      out.write("                    <div class=\"navbar-custom-menu\">\n");
      out.write("                        <ul class=\"nav navbar-nav\">\n");
      out.write("                            <li class=\"dropdown notifications-menu\">\n");
      out.write("                                <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">\n");
      out.write("                                    <i class=\"fa fa-clock-o\" aria-hidden=\"true\"></i>\n");
      out.write("                                </a>\n");
      out.write("                                <ul class=\"dropdown-menu\">\n");
      out.write("                                    <li class=\"header\">\n");
      out.write("                                    <center>\n");
      out.write("                                        <b><u>Simulador de Pagamento</u></b>\n");
      out.write("                                    </center>\n");
      out.write("                            </li>\n");
      out.write("                            <li>\n");
      out.write("                                <ul class=\"menu\">\n");
      out.write("                                    <li>\n");
      out.write("                                    <center>\n");
      out.write("                                        <i class=\"fa fa-clock-o text-blue\" aria-hidden=\"true\"></i>    \n");
      out.write("                                        <b>Tempo de Permanência:</b>\n");
      out.write("                                        <div id=\"tempo\"></div>    \n");
      out.write("                                    </center>\n");
      out.write("                            </li>\n");
      out.write("                            <li>\n");
      out.write("                            <center>\n");
      out.write("                                <i class=\"fa fa-money text-green\" aria-hidden=\"true\"></i>\n");
      out.write("                                <b>Valor Total:</b>\n");
      out.write("                                <div id=\"valor\"></div>\n");
      out.write("                            </center>\n");
      out.write("                            </li>\n");
      out.write("                        </ul>\n");
      out.write("                        </li>\n");
      out.write("                        </ul>\n");
      out.write("                        </li> \n");
      out.write("                        <li class=\"dropdown notifications-menu\">\n");
      out.write("                            <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">\n");
      out.write("                                <i class=\"fa fa-car\" aria-hidden=\"true\"></i>\n");
      out.write("                            </a>\n");
      out.write("                            <ul class=\"dropdown-menu\">\n");
      out.write("                                <li class=\"header\">\n");
      out.write("                                    <i class=\"fa fa-circle text-yellow\"></i><b> Total de Vagas:</b>\n");
      out.write("                                        ");

                                            VagaDAO vDAO = new VagaDAO();
                                            out.println(vDAO.totalVagas());
                                        
      out.write("\n");
      out.write("                                    <hr>\n");
      out.write("                                    <i class=\"fa fa-circle text-green\"></i><b> Vagas livres:</b>\n");
      out.write("                                        ");

                                            out.println(vDAO.vagasLivres());
                                        
      out.write("\n");
      out.write("                                    <br>\n");
      out.write("                                    <i class=\"fa fa-circle text-red\"></i><b> Vagas Ocupadas:</b>\n");
      out.write("                                        ");

                                            out.println(vDAO.vagasOcupadas());
                                        
      out.write("\n");
      out.write("                                    <br>\n");
      out.write("                                    <i class=\"fa fa-times-circle-o text-red\"></i><b> Vagas Interditadas:</b>\n");
      out.write("                                        ");

                                            out.println(vDAO.vagasInterditadas());
                                        
      out.write("\n");
      out.write("                                </li>\n");
      out.write("                            </ul>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"dropdown user user-menu\">\n");
      out.write("                            <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">\n");
      out.write("                                <i class=\"fa fa-user\" aria-hidden=\"true\"></i>\n");
      out.write("                                <span class=\"hidden-xs\">\n");
      out.write("                                    ");

                                        out.println("Olá, " + nome);
                                    
      out.write("\n");
      out.write("                                </span>                  \n");
      out.write("                            </a> \n");
      out.write("                            <ul class=\"dropdown-menu\">\n");
      out.write("                                <li class=\"user-body\">\n");
      out.write("                                <center> \n");
      out.write("                                    ");

                                        out.println("Olá, " + nome);
                                    
      out.write(" \n");
      out.write("                                </center>\n");
      out.write("                        </li>\n");
      out.write("                        </ul>    \n");
      out.write("                        </li>\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"sair.jsp\">\n");
      out.write("                                <i class=\"fa fa-sign-out\"></i>                   \n");
      out.write("                            </a>\n");
      out.write("                        </li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                </nav>\n");
      out.write("            </header>\n");
      out.write("            <aside class=\"main-sidebar\">\n");
      out.write("                <section class=\"sidebar\">\n");
      out.write("                    <ul class=\"sidebar-menu\">\n");
      out.write("                        <li class=\"header\">LOCALIZAÇÃO</li>\n");
      out.write("                        <li class=\"treeview\">\n");
      out.write("                            <a href=\"#\">\n");
      out.write("                                <i class=\"fa fa-building\" aria-hidden=\"true\"></i>\n");
      out.write("                                <span>Locais</span>\n");
      out.write("                                <span class=\"pull-right-container\">\n");
      out.write("                                    <i class=\"fa fa-angle-left pull-right\"></i>\n");
      out.write("                                </span>\n");
      out.write("                            </a>\n");
      out.write("                            <ul class=\"treeview-menu\">\n");
      out.write("                                <li class=\"active\"><a href=\"tag_setor_a.jsp\"><i class=\"fa fa-circle-o\"></i> Taguatinga Shopping</a></li>\n");
      out.write("                                <li class=\"active\"><a href=\"tag_setor_b.jsp\"><i class=\"fa fa-circle-o\"></i> Cidade</a></li>\n");
      out.write("                            </ul>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"treeview\">\n");
      out.write("                            <a href=\"#\">\n");
      out.write("                                <i class=\"fa fa-map-marker\" aria-hidden=\"true\"></i>\n");
      out.write("                                <span>Setores</span>\n");
      out.write("                                <span class=\"pull-right-container\">\n");
      out.write("                                    <i class=\"fa fa-angle-left pull-right\"></i>\n");
      out.write("                                </span>\n");
      out.write("                            </a>\n");
      out.write("                            <ul class=\"treeview-menu\">\n");
      out.write("                                <li class=\"active\"><a href=\"tag_setor_a.jsp\"><i class=\"fa fa-circle-o\"></i> Cidade - Lado Central</a></li>\n");
      out.write("                            </ul>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"header\">OBJETOS VISUAIS</li>\n");
      out.write("                        <li><a href=\"#\"><i class=\"fa fa-times-circle-o text-red\"></i> <span>  Vaga Interditada</span></a></li>\n");
      out.write("                        <li><a href=\"#\"><i class=\"fa fa-circle-o text-red\"></i> <span>Vaga Ocupada</span></a></li>\n");
      out.write("                        <li><a href=\"#\"><i class=\"fa fa-circle-o text-green\"></i> <span>Vaga Livre</span></a></li>\n");
      out.write("                        <li><a href=\"#\"><i class=\"fa fa-circle-o text-aqua\"></i> <span>Vaga Selecionada</span></a></li>\n");
      out.write("\n");
      out.write("                        <li class=\"header\">OUTRAS OPÇÕES</li>\t\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"suporte.jsp\">\n");
      out.write("                                <i class=\"fa fa-flag\" aria-hidden=\"true\"></i>\n");
      out.write("                                <span>Suporte</span>\n");
      out.write("                            </a>\n");
      out.write("                        </li>\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"manutencao.jsp\">\n");
      out.write("                                <i class=\"fa fa-th\"></i> <span>Sobre</span>\n");
      out.write("                            </a>\n");
      out.write("                        </li>\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"manutencao.jsp\">\n");
      out.write("                                <i class=\"fa fa-question-circle\" aria-hidden=\"true\"></i>\n");
      out.write("                                <span>Dúvidas</span>\n");
      out.write("                            </a>\n");
      out.write("                        </li>\n");
      out.write("                    </ul>\n");
      out.write("                </section>\n");
      out.write("                <!-- /.sidebar -->\n");
      out.write("            </aside>\n");
      out.write("            <!-- Content Wrapper. Contains page content -->\n");
      out.write("            <div class=\"content-wrapper\">\n");
      out.write("                <div id=\"fundo\">\t\n");
      out.write("                    <img src=\"css/estacionamento2.png\">\n");
      out.write("                </div>\t\n");
      out.write("                <div id=\"vagas\"></div> \n");
      out.write("            </div>\n");
      out.write("            <footer class=\"main-footer\">\n");
      out.write("                <div class=\"pull-right hidden-xs\">\n");
      out.write("                    <b>Alpha</b> 1.0\n");
      out.write("                </div>\n");
      out.write("                <strong>Copyright &copy; 2019 <span style=\"color: 3c8dbc;\">GoPark</span>.</strong> All rights\n");
      out.write("                reserved.\n");
      out.write("            </footer>\n");
      out.write("        </div>\n");
      out.write("        <script src=\"plugins/jQuery/jquery-2.2.3.min.js\"></script>\n");
      out.write("        <script src=\"bootstrap/js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"dist/js/app.min.js\"></script>  \n");
      out.write("        <script>\n");
      out.write("        var vagaClicada = function (div) {\n");
      out.write("            \n");
      out.write("            if (sessionStorage.vaga === div.id)\n");
      out.write("                sessionStorage.vaga = \"vaga0\";\n");
      out.write("            else\n");
      out.write("                sessionStorage.vaga = div.id;\n");
      out.write("        };\n");
      out.write("        </script>  \n");
      out.write("        <style>\n");
      out.write("            .vaga:hover {\n");
      out.write("                cursor: pointer;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
