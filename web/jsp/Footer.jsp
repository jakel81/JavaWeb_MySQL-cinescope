<%-- 
    Document   : Footer
    Created on : 16 oct. 2017, 16:27:28
    Author     : rayanakel
--%>

<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    SimpleDateFormat sdfJour = new SimpleDateFormat("EEEE dd MMMM yyyy");
    SimpleDateFormat sdfHeure = new SimpleDateFormat("HH:mm");
    String lsJour = sdfJour.format(new Date());
    String lsHeure = sdfHeure.format(new Date());
    out.print("Date et heure à Paris : " + lsJour + " " + lsHeure);
%>
