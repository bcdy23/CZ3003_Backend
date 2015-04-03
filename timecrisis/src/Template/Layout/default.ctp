<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>TIMECrisis | Admin Panel</title>
    <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
    <!-- Bootstrap 3.3.2 -->
    <link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css" />
    <!-- Font Awesome Icons -->
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.css" rel="stylesheet" type="text/css" />
    <!-- Ionicons -->
    <link href="http://code.ionicframework.com/ionicons/2.0.0/css/ionicons.min.css" rel="stylesheet" type="text/css" />
    <!-- Morris chart -->
    <link href="plugins/morris/morris.css" rel="stylesheet" type="text/css" />
    <!-- jvectormap -->
    <link href="plugins/jvectormap/jquery-jvectormap-1.2.2.css" rel="stylesheet" type="text/css" />
    <!-- Daterange picker -->
    <link href="plugins/daterangepicker/daterangepicker-bs3.css" rel="stylesheet" type="text/css" />
    <!-- Theme style -->
    <link href="dist/css/AdminLTE.css" rel="stylesheet" type="text/css" />
    <!-- AdminLTE Skins. Choose a skin from the css/skins 
         folder instead of downloading all of them to reduce the load. -->
    <link href="dist/css/skins/_all-skins.css" rel="stylesheet" type="text/css" />

    
    
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
  </head>
  <body class="skin-red">
    <div class="wrapper">
      
      <header class="main-header">
        <!-- Logo -->
        <a href="index.php" class="logo">
            <img src="dist/img/logo.png" width="40px" height="40px" style="margin-bottom:5px; margin-right:5px;" /><b>TIME</b>Crisis
        </a>
        <!-- Header Navbar: style can be found in header.less -->
        <nav class="navbar navbar-static-top" role="navigation">
          <!-- Sidebar toggle button-->
          <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
            <span class="sr-only">Toggle navigation</span>
          </a>
          <!-- Navbar Right Menu -->
          <div class="navbar-custom-menu">
            <ul class="nav navbar-nav">
             
               <!-- VISIT SITE LINK-->
              <li class="#">
                <a href="#">
                  <span class="hidden-xs">Visit Site</span>
                </a>
              </li>

              <!-- Notifications: style can be found in dropdown.less -->
              <!-- NOTIFICATION IS TO NOTIFY ABOUT PUBLIC INCIDENT REPORT-->
              <li class="dropdown notifications-menu">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                  <i class="fa fa-bell-o"></i>
                  <span class="label label-warning">11</span>
                </a>
                <ul class="dropdown-menu">
                  <li class="header">You have 1 notifications</li>
                  <li>
                    <!-- inner menu: contains the actual data -->
                    <ul class="menu">
                      <li>
                        <a href="#">
                          <i class="fa fa-users text-aqua"></i> 1 new pending incident report
                        </a>
                      </li>
                    </ul>
                  </li>
                  <li class="footer"><a href="#">View all</a></li>
                </ul>
              </li>
              
              <!-- User Account: style can be found in dropdown.less -->
              <!-- USER ACCOUNT : EDIT PROFILE & LOG OUT -->
              <li class="dropdown user user-menu">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                  <img src="dist/img/avatar5.png" class="user-image" alt="User Image"/>
                  <span class="hidden-xs">Alexander Pierce</span>
                </a>
                <ul class="dropdown-menu">
                  <!-- User image -->
                  <li class="user-header">
                    <img src="dist/img/avatar5.png" class="img-circle" alt="User Image" />
                    <p>
                      Alexander Pierce 
                      <small>[Job Role]</small>
                    </p>
                  </li>
                  <!-- Menu Footer-->
                  <li class="user-footer">
                    <div class="pull-left">
                      <a href="index.php?pg=edit_profile" class="btn btn-default btn-flat">Profile</a>
                    </div>
                    <div class="pull-right">
                      <a href="#" class="btn btn-default btn-flat">Sign out</a>
                    </div>
                  </li>
                </ul>
              </li>

            </ul>
          </div>
        </nav>
      </header>

      <!-- ..............................................................NAVIGATION................................................... -->
      <!-- Left side column. contains the logo and sidebar -->
      <aside class="main-sidebar">
        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">
          <!-- Sidebar user panel -->
          <div class="user-panel">
            <div class="pull-left image">
              <img src="dist/img/avatar5.png" class="img-circle" alt="User Image" />
            </div>
            <div class="pull-left info">
              <p>Alexander Pierce</p>
              <small>[Job Role]</small>
            </div>
          </div>
          
          <!-- sidebar menu: : style can be found in sidebar.less -->
          <ul class="sidebar-menu">
            <li class="header">MAIN NAVIGATION</li>
            <?php if ($page == "dashboard"){ ?>  <li class= "active treeview"> <?php }else{ ?> <li class= "treeview"> <?php }?>
              <a href="/">
                <i class="fa fa-dashboard"></i> <span>Dashboard</span> </i>
              </a>
            </li>

            <!-- MANAGE INCIDENTS-->
            <?php if ($page == "report_incident" || $page == "incidents" || $page == "incident_category"){ ?>  <li class= "active"> <?php }else{ ?> <li> <?php }?>
              <a href="#">
                <i class="fa fa-files-o"></i>
                <span>Incidents</span>
                <span class="label label-primary pull-right">3</span>
              </a>
              <ul class="treeview-menu">
                <?php if ($page == "report_incident"){ ?>  <li class= "active"> <?php }else{ ?> <li> <?php }?>
                    <a href="ReportIncident"><i class="fa fa-circle-o"></i>Report Incidents <span class="label label-primary pull-right">3</span></a>
                </li>
                <?php if ($page == "incidents"){ ?>  <li class= "active"> <?php }else{ ?> <li> <?php }?>
                    <a href="Incident"><i class="fa fa-circle-o"></i>Incidents</a>
                </li>
                <?php if ($page == "incident_category"){ ?>  <li class= "active"> <?php }else{ ?> <li> <?php }?>
                  <a href="IncidentCategory"><i class="fa fa-circle-o"></i>Incident Category</a>
                </li>
              </ul>
            </li>
            
            <!-- MANAGE EVENTS-->
            <?php if ($page == "haze" || $page == "dengue"){ ?>  <li class= "active"> <?php }else{ ?> <li> <?php }?>
              <a href="#">
                <i class="fa fa-share"></i>
                <span>Events</span>
                <i class="fa fa-angle-left pull-right"></i>
              </a>
              <ul class="treeview-menu">
                <?php if ($page == "dengue"){ ?>  <li class= "active"> <?php }else{ ?> <li> <?php }?>
                  <a href="Dengue"><i class="fa fa-circle-o"></i>Dengue</a>
                </li>
                <?php if ($page == "haze"){ ?>  <li class= "active"> <?php }else{ ?> <li> <?php }?>
                  <a href="Haze"><i class="fa fa-circle-o"></i>Haze</a>
                </li>
              </ul>
            </li>

            <!-- MANAGE CONTACTS -->
            <?php if ($page == "agency" || $page == "subscribers"){ ?>  <li class= "active"> <?php }else{ ?> <li> <?php }?>
              <a href="#">
                <i class="fa fa-envelope"></i>
                <span>Contacts</span>
                <i class="fa fa-angle-left pull-right"></i>
              </a>
              <ul class="treeview-menu">
                <?php if ($page == "agency"){ ?>  <li class= "active"> <?php }else{ ?> <li> <?php }?>
                  <a href="Agency"><i class="fa fa-circle-o"></i>Agency</a>
                </li>
                <?php if ($page == "subscribers"){ ?>  <li class= "active"> <?php }else{ ?> <li> <?php }?>
                  <a href="Subscriber"><i class="fa fa-circle-o"></i>Subscribers</a>
                </li>
              </ul>
            </li>

            <!-- MANAGE ACCOUNTS -->
            <?php if ($page == "staff_account"){ ?>  <li class= "active"> <?php }else{ ?> <li> <?php }?>
              <a href="#">
                <i class="fa fa-laptop"></i>
                <span>Accounts</span>
                <i class="fa fa-angle-left pull-right"></i>
              </a>
              <ul class="treeview-menu">
                <?php if ($page == "staff_account"){ ?>  <li class= "active"> <?php }else{ ?> <li> <?php }?>
                  <a href="StaffAccount"><i class="fa fa-circle-o"></i>Staff Account</a>
                </li>
              </ul>
            </li>

            <!-- GENERATE REPORTS -->
            <?php if ($page == "incident_report" || $page == "event_report"){ ?>  <li class= "active"> <?php }else{ ?> <li> <?php }?>
              <a href="#">
                <i class="fa fa-book"></i>
                <span>Reports</span>
                <i class="fa fa-angle-left pull-right"></i>
              </a>
              <ul class="treeview-menu">
                <?php if ($page == "incident_report"){ ?>  <li class= "active"> <?php }else{ ?> <li> <?php }?>
                  <a href="IncidentReport"><i class="fa fa-circle-o"></i>Incident Report</a>
                </li>
                <?php if ($page == "event_report"){ ?>  <li class= "active"> <?php }else{ ?> <li> <?php }?>
                  <a href="EventReport"><i class="fa fa-circle-o"></i>Event Report</a>
                </li>
              </ul>
            </li>
            
          </ul>
        </section>
        <!-- /.sidebar -->
      </aside>
      <!-- .............................................END OF NAVIGATION............................................. -->

      <?= $this->fetch('content') ?>


      <footer class="main-footer">
        <div class="pull-right hidden-xs">
          Admin Panel
        </div>
        <strong>Copyright &copy; 2015 <a href="#">TIMECrisis</a>.</strong> All rights reserved.
      </footer>

    </div><!-- ./wrapper -->
      
    <!-- jQuery 2.1.3 -->
    <script src="plugins/jQuery/jQuery-2.1.3.min.js"></script>
    <!-- Bootstrap 3.3.2 JS -->
    <script src="bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
    <!-- FastClick -->
    <script src='plugins/fastclick/fastclick.min.js'></script>
    <!-- AdminLTE App -->
    <script src="dist/js/app.min.js" type="text/javascript"></script>
    <!-- Sparkline -->
    <script src="plugins/sparkline/jquery.sparkline.min.js" type="text/javascript"></script>
    <!-- jvectormap -->
    <script src="plugins/jvectormap/jquery-jvectormap-1.2.2.min.js" type="text/javascript"></script>
    <script src="plugins/jvectormap/jquery-jvectormap-world-mill-en.js" type="text/javascript"></script>
    <!-- daterangepicker -->
    <script src="plugins/daterangepicker/daterangepicker.js" type="text/javascript"></script>
    <!-- datepicker -->
    <script src="plugins/datepicker/bootstrap-datepicker.js" type="text/javascript"></script>
    <!-- iCheck -->
    <script src="plugins/iCheck/icheck.min.js" type="text/javascript"></script>
    <!-- SlimScroll 1.3.0 -->
    <script src="plugins/slimScroll/jquery.slimscroll.min.js" type="text/javascript"></script>
    <!-- ChartJS 1.0.1 -->
    <script src="plugins/chartjs/Chart.min.js" type="text/javascript"></script>

    <!-- AdminLTE dashboard demo (This is only for demo purposes) -->
    <script src="dist/js/pages/dashboard2.js" type="text/javascript"></script>

    <!-- AdminLTE for demo purposes -->
    <script src="dist/js/demo.js" type="text/javascript"></script>

    <!-- InputMask -->
    <script src="plugins/input-mask/jquery.inputmask.js" type="text/javascript"></script>
    <script src="plugins/input-mask/jquery.inputmask.date.extensions.js" type="text/javascript"></script>
    <script src="plugins/input-mask/jquery.inputmask.extensions.js" type="text/javascript"></script>


  </body>
</html>

