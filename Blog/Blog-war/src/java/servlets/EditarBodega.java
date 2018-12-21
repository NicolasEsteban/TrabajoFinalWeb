
package servlets;

import data.Bodega;
import datasessionbeans.Data_BodegaFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class EditarBodega extends HttpServlet {

    @EJB
    public Data_BodegaFacadeLocal bodegaFacade;
    public List<Bodega> bo;
    private Bodega bodega;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String id = request.getParameter("id_p").toUpperCase();
        Long idp = Long.parseLong(id);
         
        bodega =  bodegaFacade.find(idp);
        if(bodega==null){
           response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet BlogServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Error el Producto ID: "+ id + " No Existe</h1>");
           out.println("<a href=\"index.html\"> <i class='fa fa-plus fa-fw'></i> Volver </a>");
            out.println("</body>");
            out.println("</html>");
        }
              
         }else{
             request.setAttribute("id", bodega.getId());
             request.setAttribute("nombre", bodega.getNombre());
              
               
             RequestDispatcher despachador = request.getRequestDispatcher("UpdateB.jsp");
                despachador.forward(request, response);
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
