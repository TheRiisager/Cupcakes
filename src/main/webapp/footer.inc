
                    </div>

                    <div class="col-sm"></div>
                    <div class="col-sm"></div>

                </div>

                <div class="container-fluid">
                    <div class="row">
                        <div class="col-sm h-25">
                            <nav class="navbar navbar-expand-lg fixed-bottom navbar-light bg-light" id="mainnav">
                                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                                    <span class="navbar-toggler-icon"></span>
                                </button>
                                <div class="collapse navbar-collapse justify-content-center" id="navbarNavAltMarkup">
                                    <div class="navbar-nav">

                                        <form name="index" action="FrontController" method="POST">
                                            <input type="hidden" name="target" value="index">
                                            <input type="submit" value="Hjem" class="btn btn-light">
                                        </form>
                                        <form name="products" action="FrontController" method="POST">
                                            <input type="hidden" name="target" value="products">
                                            <input type="submit" value="Sortiment" class="btn btn-light">
                                        </form>
                                        <form name="about" action="FrontController" method="POST">
                                            <input type="hidden" name="target" value="about">
                                            <input type="submit" value="Om os" class="btn btn-light">
                                        </form>
                                        <form name="contact" action="FrontController" method="POST">
                                             <input type="hidden" name="target" value="contact">
                                            <input type="submit" value="Kontakt" class="btn btn-light">
                                        </form>

                                    </div>
                                </div>
                            </nav>
                        </div>
                    </div>
            </div>

        </body>
</html>