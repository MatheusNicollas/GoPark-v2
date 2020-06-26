<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    request.setCharacterEncoding("UTF-8");
    
    String nome = request.getParameter("nome");

    if (nome != null) {
        session.setAttribute("nome", nome);
    }

    response.sendRedirect("tag_setor_b.jsp");
%>