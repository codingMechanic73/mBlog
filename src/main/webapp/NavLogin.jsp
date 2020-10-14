
<div style="margin-bottom:50px">
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="/">Home</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto"> </ul>
            <ul class="navbar-nav">
                <li class="nav-item" style="margin-right: 20px">
                    <form class="form-inline my-2 my-lg-0" action="/user" method="POST">
                        <input class="form-control mr-sm-2" type="text" placeholder="userName" name="userName" required>
                        <input class="form-control mr-sm-2" type="password" placeholder="********" aria-label="Password" name="password" required>
                        <button class="btn btn-outline-success my-2 my-sm-0" type="submit" name="button" value="Sign In">Sign In</button>
                    </form>
                    <%
                        String errorMsg = (String) request.getAttribute("errorMsg");
                        if (errorMsg != null) {
                    %>
                    <div style="color:red">
                        <%=errorMsg %>
                    </div>
                    <%
                    }
                    %>
                </li>
                <li class="nav-item">
                    <a href="/SignUp.jsp" class="btn btn-success my-2 my-sm-0" type="submit">Sign Up</a>
                </li>
            </ul>
        </div>
    </nav>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
                    integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
                    crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
            integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
            crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
            integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
            crossorigin="anonymous"></script>
</div>