package controle;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Vaga;
import modelo.VagaDAO;

public class GerenciarAcesso extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet GerenciarAcesso</title>");            
            out.println("</head>");
            out.println("<body>");
            HttpSession session = request.getSession();
            String nome = request.getParameter("nome");
            String local = request.getParameter("local");  
            if (nome.isEmpty() || nome.equals("")) {
                    out.print("<script type='text/javascript'>");
                    out.print("alert('O campo Nome deve ser preenchido!');");
                    out.print("history.back();");
                    out.print("</script>");
                } else if (local.equals("Selecione o Local")) {
                    out.print("<script type='text/javascript'>");
                    out.print("alert('Selecione um Local!!');");
                    out.print("history.back();");
                    out.print("</script>");
                } else {
                        session.setAttribute("nome", nome);
                        response.sendRedirect("tag_setor_a.jsp");
                }

            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
