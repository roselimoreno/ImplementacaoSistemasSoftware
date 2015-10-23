<%-- 
    Document   : index
    Created on : Oct 22, 2015, 12:08:21 AM
    Author     : Gabriel
--%>

<%@page import="java.util.List"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="modelo.Produto"%>
<%@page import="persistencia.EMF"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<% 
    EntityManager em = EMF.createEntityManager() ;
    em.getTransaction().begin();
    List<Produto> produtos = em.createQuery("from Produto").getResultList();
        
%>




<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%for (int i=0; i<produtos.size(); i++) {%>
            <p><%=produtos.get(i).getNome()%></p>
        <%}%>
    </body>
</html>
