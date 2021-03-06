<%@page import="java.util.Iterator"%>
<%@page import="servlets.VerBodega"%>
<%@page import="producto.listarProductos"%>
<%@page import="java.util.List"%>
<%@page import="data.Producto"%>
<%@page import="datasessionbeans.Data_ProductoFacadeLocal"%>
<%@page import="javax.ejb.EJB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>

    <!-- IMPORTANDO ICONOS -->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Panel Admin</title>
     <link rel="stylesheet" href="admin/css/bootstrap.min.css" type="text/css"/>
     <link rel="stylesheet" href="admin/css/metisMenu.min.css" type="text/css"/>
     <link rel="stylesheet" href="admin/css/sb-admin-2.css" type="text/css"/>
     <link rel="stylesheet" href="admin/css/font-awesome.min.css" type="text/css"/>
      <link rel="stylesheet" href="admin/css/tabla_scroll.css" type="text/css"/>

    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>

    <script type="text/javascript" src="js/Chart.bundle.js"></script>
      <script type="text/javascript" src="js/Chart.bundle.min.js"></script>
      <script type="text/javascript" src="js/Chart.js"></script>
      <script type="text/javascript" src="js/Chart.min.js"></script>
      
      <script type="text/javascript" src="admin/js/jquery.min.js"></script>
      <script type="text/javascript" src="admin/js/bootstrap.min.js"></script>
      <script type="text/javascript" src="admin/js/metisMenu.min.js"></script>
      <script type="text/javascript" src="admin/js/sb-admin-2.js"></script>



</head>

<body>

    <div id="wrapper">

        
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
            
                <a class="navbar-brand" href="/">Admin</a>

            </div>
           
    
 <ul class="nav navbar-top-links navbar-right">
                 <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user fa-fw"></i>  <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="#"><i></i></a>
                        </li>
                        <li class="divider"></li>
                        <li><a href=""><i class="fa fa-sign-out fa-fw"></i>Cerrar Sección</a>
                        </li>
                    </ul>
                </li>
            </ul>

            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">

                    
                    <li>
                            <a href="#"><i class="fa fa-film fa-fw"></i> Inventario<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                     
                                <li>
                                
                                    <a href="plantillaCrear"><i class='fa fa-plus fa-fw'></i>Agregar Productos</a>
                                </li>

                                <li>
                                    <a href="VerProductos"><i class='fa fa-list-ol fa-fw'></i> Ver Productos</a>
                                </li>
                            </ul>
                        </li>

    <li>
                            <a href="#"><i class="fa fa-film fa-fw"></i>Bodegas<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                         
                                <li>
                                    <a href="plantillaCrearBodega"> <i class='fa fa-plus fa-fw'></i> Agregar </a>
                                </li>
                                <li>
                                
                                    <a href="VerBodega"><i class='fa fa-list-ol fa-fw'></i>Ver</a>
                                </li>
                            </ul>
                        </li>
                        
                      
                        <li>
                            <a href="#"><i class="fa fa-film fa-fw"></i> Movimientos<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                          
                                <li>
                                    <a href=""> <i class='fa fa-plus fa-fw'></i> Agregar </a>
                                </li>
                                <li>
                                    <a href="/alumno/importar"> <i class='fa fa-plus fa-fw'></i> Importar lista </a>
                                </li>
                                <li>
                     
                                    <a href="/alumno"><i class='fa fa-list-ol fa-fw'></i> Estudiantes</a>
                                </li>
                            </ul>
                        </li>
                        
                        

                   
           

                          
                    </ul>
                </div>
            </div>


     </nav>
          <div id="page-wrapper">

    
    <div class="row">
        <div class = "col-lg-8 col-md-8 col-sm-8 col-xs-12">
            <fieldset>
                <legend>Editar Bodega : <%= request.getAttribute("id") %></legend>
       
               <form action="UpdateBodega" method="post">
                   
            <input type="hidden" name="idP" value="<%= request.getAttribute("id") %>">
            <div class="form-group">
                <label for="nombre">Nombre: </label>
                <input type="text" name="nombre" value="<%= request.getAttribute("nombre") %>">
            </div>
                   
   
            <div class="form-group">
                <button class="btn btn-primary" type="submit">Guardar</button>
                <button class="btn btn-danger" type="reset">Cancelar</button>
            </div>
               </form>
            </fieldset>
        </div>
    </div>


        </div>
    </div>
    
    

</body>

</html>

