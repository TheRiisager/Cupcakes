<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Olsker Cupcakes</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

          <style>
                html {
                  height: 100%;
                }

                body {
                  background-color: #9b9b9b;
                  background-image: url("img/bg.jpg");
                  background-size: cover;
                  height: 100%;
                }

                #centerdiv {
                    background-color: #3c1460;
                    padding: 0px;
                }


               #nav-item nav-link {
                    color #3c1460:
               }

           </style>
    </head>
        <body>

            <div class="row no-gutters h-100">

                <div class="col-sm h-100"></div>

                <div class="col-lg-7 h-100" id="centerdiv">
                    <nav class="navbar navbar-expand-lg navbar-light bg-light" id="mainnav">
                        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                        </button>
                        <div class="collapse navbar-collapse justify-content-center" id="navbarNavAltMarkup">
                            <div class="navbar-nav">

                                    <form name="index" action="FrontController" method="POST">
                                        <input type="hidden" name="target" value="index">
                                        <input type="submit" value="Hjem">
                                    </form>
                                    <form name="products" action="FrontController" method="POST">
                                        <input type="hidden" name="target" value="products">
                                        <input type="submit" value="Sortiment">
                                    </form>
                                    <form name="about" action="FrontController" method="POST">
                                        <input type="hidden" name="target" value="about">
                                        <input type="submit" value="Om os">
                                    </form>
                                    <form name="contact" action="FrontController" method="POST">
                                         <input type="hidden" name="target" value="contact">
                                        <input type="submit" value="Kontakt">
                                    </form>

                                </div>
                            </div>
                           </nav>




