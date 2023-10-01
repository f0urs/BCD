<%-- 
    Document   : manager_register
    Created on : Apr 6, 2023, 11:44:06 PM
    Author     : ishara
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.webapp.entity.manager"%>
<%@page import="java.util.List"%>
<%@page import="com.webapp.ejb.managerSessionBeanRemote"%>
<%@page import="javax.naming.InitialContext"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="UTF-8">
        <title>EMP Manager / manager Register</title>
        <link type="text/css" rel="stylesheet" href="styles/manager_register.css" />
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Rubik:wght@700&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    </head>

    <body>
        <div class="section-div-outer-top">
            <div class="div-top-left">
                <span class="logo-title"><a href="index.jsp" style="text-decoration: none;
                                            color:#FF6000;
                                            transition: 0.5s;">EMP Manager</a></span>
            </div>
            <div class="div-top-right">

                <span class="nav-label"><a href="employee_register.jsp" style="text-decoration: none;
                                           color:#FF6000;  
                                           transition: 0.5s;">Employees</a></span>&nbsp; &nbsp; &nbsp;
                <span class="nav-label"><a href="" style="text-decoration: none;
                                           color:#FF6000;  
                                           transition: 0.5s;">Managers</a></span>&nbsp; &nbsp; &nbsp;
                
                <span class="nav-label"><a href="login.jsp" style="text-decoration: none;
                                           color:#FF6000;  
                                           transition: 0.5s;">Login/Signup</a></span> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                <span class="nav-label">Logout</span>
            </div>
        </div>
        <div class="box-outer">
            <div class="box-inner-out">
                <div class="midder-div">
                    <div class="div-right">
                        <form class="data-input-form" method="post" action="add_manager">
                            <div class="div-set-1">
                                <h1>Register manager</h1>
                                <br/>
                                <br/>
                                <input type="text" name="username" class="combo-12" placeholder="Username" required/>
                                <br/>
                                <br/>
                                <input type="password" name="username" class="combo-12" placeholder="Password" required/>
                                <br/>
                                <br/>
                                <input type="text" class="user-input-field" placeholder="First Name" name="firstname" required /> &nbsp;
                                <input type="text" name="lastname" class="combo-11" placeholder="Last Name" required/>
                                <br/>
                                <br/>
                                <input type="email" name="email" class="combo-12" placeholder="Email" required/>
                                <br/>
                                <br/>
                                <input type="text" name="contact" class="combo-12" placeholder="Contact Number" required/>
                                <br/>
                                <br/>
                                <input type="text" name="address" class="combo-12" placeholder="Address" required/>
                                <br/>
                                <br/>
                                
                                <br/>
                                <br/>
                                <input type="submit" value="Save" class="submit-button" />
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <section class="section2">
            <div class="section-2-div-top-search">
                <form method="post" action="#" class="employee-search-form">
                    <input type="text" name="manager_name" placeholder="Please Enter manager Name Here" class="search_field" />
                    <input type="submit" value="SEARCH" class="search-button" />
                </form>
            </div>
        </section>
        <div class="container">
            <table>
                <thead>
                    <tr>
                        <th>Username</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Email</th>
                        <th>Contact Number</th>
                        <th>Address</th>
                        
                        <th>Delete</th>
                        <th>Update</th>
                    </tr>
                    <%
                        try {
                            InitialContext ic = new InitialContext();
                            managerSessionBeanRemote tsbr = (managerSessionBeanRemote) ic.lookup("com.webapp.ejb.managerSessionBeanRemote");
                            List<manager> managers = tsbr.getAll();
                            pageContext.setAttribute("managers", managers);
                    %>
                </thead>
                <tbody>
                    <c:forEach var="managers" items="${managers}">
                        <tr>
                            <td>${managers.username}</td>
                            <td>${managers.firstname}</td>
                            <td>${managers.lastname}</td>
                            <td>${managers.email}</td>
                            <td>${managers.contactnumber}</td>
                            <td>${managers.address}</td>
                            
                            <td><a class="update-button" href="">Update</a></td>
                            <td><a class="delete-button" href="delete_employee?id=${managers.id}">Delete</a></td>
                        </tr>
                    </c:forEach>
                    <%
                        } catch (Exception e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                    %>
                </tbody>
            </table>
        </div>
        <footer class="ft">
            <p>&copy; 2023 Enitiac (Pvt).Ltd. All Rights Reserved.</p>
        </footer>
    </body>

</html>