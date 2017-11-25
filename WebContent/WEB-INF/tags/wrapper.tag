<%@tag description="Simple Wrapper Tag" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="en">


  <head>


    <title>projet sgbd</title>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
  
  

  </head>



  <body>

    <!-- Navigation -->
    <div class="container">
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Projet SGBD</a>
    </div>
    <ul class="nav navbar-nav">
    </ul>
  </div>

</nav>
  </div>



    <!-- Page Content -->
    <div class="container">
<div style="height:35px;"></div>
     <div class="row">

        <div class="col-lg-3">
          <div class="list-group">
            <a href="accueil" class="list-group-item active">Accueil</a>
            <a href="matches" class="list-group-item">Matches</a>
            <a href="#" class="list-group-item">Clubs</a>
            <a href="#" class="list-group-item">Responsables</a>
            <a href="#" class="list-group-item">Joueurs</a>
            <a href="#" class="list-group-item">Entraîneurs</a>
            <a href="#" class="list-group-item">Saisons</a>
            <a href="#" class="list-group-item">Statistiques</a>

          </div>
        </div>
        <!-- /.col-lg-3 -->

        <div class="col-lg-9">
			<jsp:doBody/>
        </div>
        <!-- /.col-lg-9 -->

      



</div>
<div style="height:50px;"></div>
    </div>
    <!-- /.container -->




    <!-- Footer -->
    <footer class="py-5 bg-dark">
      <div class="container">
        <p class="m-0 text-center text-white">Copyright &copy;  2017</p>
      </div>
      <!-- /.container -->
    </footer>

 
  </body>

</html>







