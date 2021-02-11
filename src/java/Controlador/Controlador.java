package Controlador;

import Modelo.Aluno;
import ModeloDAO.AlunoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controlador extends HttpServlet {
    String listar="vistas/listar.jsp";//Caminho da tela de Listar
    Aluno a = new Aluno(); //instanciar ao aluno()
    AlunoDAO dao = new AlunoDAO();//instanciar DAO - bd
    int id;//criar indentificador id
  
    //processRequest - http servlet
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");//documents Type 
            out.println("<html>"); //html open
            out.println("<head>"); //cabeçalho open
            out.println("<title>Servlet Controlador</title>");//controlador            
            out.println("</head>"); //cabeçalho close
            out.println("<body>"); //corpo jsp - open
            out.println("<h1>Servlet Controlador at " + request.getContextPath() + "</h1>"); //controlador que recebe a request
            out.println("</body>");//corpo jsp - close
            out.println("</html>");//html close
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        String acceso = "";
        String action = request.getParameter("accion");
        
            if(action.equalsIgnoreCase("listar")){
                  acceso = listar;  
            } //adicionado
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        processRequest(request, response);
    }
   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}







//    String add="vistas/add.jsp";
//    String edit="vistas/edit.jsp";


     
//        }else if(action.equalsIgnoreCase("add")){
//            acceso=add;
//        }
//        else if(action.equalsIgnoreCase("Adicionar")){
//            String email=request.getParameter("txtEmail");
//            String nom=request.getParameter("txtNom");
//            a.setEmail(email);
//            a.setNom(nom);
//            dao.add(a);
//            acceso=listar;
//        }
//        else if(action.equalsIgnoreCase("editar")){
//            request.setAttribute("id-a",request.getParameter("id"));
//            acceso=edit;
//        }
//        else if(action.equalsIgnoreCase("Atualizar")){
//            id=Integer.parseInt(request.getParameter("txtid"));
//            String email=request.getParameter("txtEmail");
//            String nom=request.getParameter("txtNom");
//            a.setId(id);
//            a.setEmail(email);
//            a.setNom(nom);
//            dao.edit(a);
//            acceso=listar;
//        }
//        else if(action.equalsIgnoreCase("eliminar")){
//            id=Integer.parseInt(request.getParameter("id"));
//            a.setId(id);
//            dao.eliminar(id);
//            acceso=listar;
//        }