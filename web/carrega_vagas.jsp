<%@page import="org.apache.taglibs.standard.tag.common.core.CatchTag"%>
<%@page import="modelo.VagaDAO"%>
<%@page import="modelo.Vaga"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    try {
        VagaDAO vDAO = new VagaDAO();

        for (int i = 1; i <= 9; ++i) {
            Vaga v = vDAO.buscarPorId(i);
%>
<div id="vaga<%= i %>" class="vaga" onclick="vagaClicada(this)"> 
    <% if (v.getStatus() == 0) { %>
    <img src="imagens/vaga-verde.png">
    <% } else if (v.getStatus() == 1) {%>
    <img src="imagens/vaga-vermelha.png">
    <% } else { %>
    <img src="imagens/vaga-inter.png">
    <% } %>         
</div>  
<% }  
} catch (Exception e) {
        System.out.println(e);
        System.out.println(e.getMessage());
    }%>

