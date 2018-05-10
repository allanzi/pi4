/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.pi3.servlets.email;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;



/**
 *
 * @author Felipe
 */
//@WebServlet(name = "SuporteServlet", urlPatterns = {"/suporte"})
public class EmailServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            request.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=UTF-8");
            String Assunto = request.getParameter("Assunto");
            String Mensagem = request.getParameter("Mensagem");
              

      SimpleEmail email = new SimpleEmail();  
  
      email.setDebug(true);  
      email.setHostName("smtp.gmail.com");  
      email.setAuthentication("suporte.tardis@gmail.com","tardis123");  
      email.setSSL(true);  
      email.addTo("suporte.tardis@gmail.com"); //pode ser qualquer email  
      email.setFrom("suporte.tardis@gmail.com"); //será passado o email que você fará a autenticação 
      email.setSubject(Assunto);  
      email.setMsg(Mensagem);  
      email.send();  

      } catch (EmailException e) {  

      System.out.println(e.getMessage());  

      }   

  }  

}

