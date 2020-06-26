<%
    String nome = (String) session.getAttribute("nome");
    session.removeAttribute(nome);
    session.invalidate();
    response.sendRedirect("index.jsp");
%>