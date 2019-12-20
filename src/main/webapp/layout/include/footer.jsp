<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<footer class="footer" style=" background: #02bec6;">
    <div class="container">
        <div class="row align-items-center flex-row-reverse">
            <div class="col-auto ml-lg-auto">
                <div class="row align-items-center">
                    <div class="col-auto">
                        <%--<a href="/login" class="btn btn-outline-primary btn-sm">Login</a>--%>
                    </div>
                </div>
            </div>
            <div class="col-12 col-lg-auto mt-3 mt-lg-0 text-center" style="color: #000000">
                Copyright &copy;
                <%
                    String currentDate = new SimpleDateFormat("yyyy").format(new Date());
                    out.print(currentDate);
                %>
                Thimphu TechPark Ltd.
            </div>
        </div>
    </div>
</footer>