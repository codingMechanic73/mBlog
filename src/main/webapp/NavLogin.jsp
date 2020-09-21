<div style="margin-bottom:50px">
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="/Home.jsp">Home</a>
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
                </li>
                <li class="nav-item">
                    <a href="/SignUp.jsp" class="btn btn-success my-2 my-sm-0" type="submit">Sign Up</a>
                </li>
            </ul>
        </div>
    </nav>
</div>