package org.example.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.daos.UsuarioDao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class RegistroServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        request.getRequestDispatcher("/WEB-INF/jsp/registro.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        request.setCharacterEncoding("UTF-8");
        String nombres = request.getParameter("nombre");
        String apellidos = request.getParameter("apellido");
        String email = request.getParameter("email");
        String password_hash = request.getParameter("password_hash");
        if(nombres==null || apellidos==null|| email==null || password_hash==null){
            request.setAttribute("msg","error");
            request.getRequestDispatcher("/WEB-INF/jsp/registro.jsp").forward(request, response);
            return;
        }
        try {
            boolean creado = new UsuarioDao().registrar(nombres,apellidos,email,password_hash);
            if(!creado){
                request.setAttribute("msg","error");
                request.getRequestDispatcher("/WEB-INF/jsp/registro.jsp").forward(request, response);
                return;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}


