
<?php
    #Dynamically change the page based on the URL
    $page=$_GET['pg'];
?>
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
              <a href="index.php?pg=dashboard">
                <i class="fa fa-dashboard"></i> <span>Dashboard</span> </i>
              </a>
            </li>

            <!-- MANAGE INCIDENTS-->
            <?php if ($page == "report_incidents" || $page == "incidents" || $page == "incident_category"){ ?>  <li class= "active"> <?php }else{ ?> <li> <?php }?>
              <a href="#">
                <i class="fa fa-files-o"></i>
                <span>Incidents</span>
                <span class="label label-primary pull-right">3</span>
              </a>
              <ul class="treeview-menu">
                <?php if ($page == "report_incidents"){ ?>  <li class= "active"> <?php }else{ ?> <li> <?php }?>
                    <a href="index.php?pg=report_incidents"><i class="fa fa-circle-o"></i>Report Incidents <span class="label label-primary pull-right">3</span></a>
                </li>
                <?php if ($page == "incidents"){ ?>  <li class= "active"> <?php }else{ ?> <li> <?php }?>
                    <a href="index.php?pg=incidents"><i class="fa fa-circle-o"></i>Incidents</a>
                </li>
                <?php if ($page == "incident_category"){ ?>  <li class= "active"> <?php }else{ ?> <li> <?php }?>
                  <a href="index.php?pg=incident_category"><i class="fa fa-circle-o"></i>Incident Category</a>
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
                  <a href="index.php?pg=dengue"><i class="fa fa-circle-o"></i>Dengue</a>
                </li>
                <?php if ($page == "haze"){ ?>  <li class= "active"> <?php }else{ ?> <li> <?php }?>
                  <a href="index.php?pg=haze"><i class="fa fa-circle-o"></i>Haze</a>
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
                  <a href="index.php?pg=agency"><i class="fa fa-circle-o"></i>Agency</a>
                </li>
                <?php if ($page == "subscribers"){ ?>  <li class= "active"> <?php }else{ ?> <li> <?php }?>
                  <a href="index.php?pg=subscribers"><i class="fa fa-circle-o"></i>Subscribers</a>
                </li>
              </ul>
            </li>

            <!-- MANAGE ACCOUNTS -->
            <?php if ($page == "staff_accounts"){ ?>  <li class= "active"> <?php }else{ ?> <li> <?php }?>
              <a href="#">
                <i class="fa fa-laptop"></i>
                <span>Accounts</span>
                <i class="fa fa-angle-left pull-right"></i>
              </a>
              <ul class="treeview-menu">
                <?php if ($page == "staff_accounts"){ ?>  <li class= "active"> <?php }else{ ?> <li> <?php }?>
                  <a href="index.php?pg=staff_accounts"><i class="fa fa-circle-o"></i>Staff Account</a>
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
                  <a href="index.php?pg=incident_report"><i class="fa fa-circle-o"></i>Incident Report</a>
                </li>
                <?php if ($page == "event_report"){ ?>  <li class= "active"> <?php }else{ ?> <li> <?php }?>
                  <a href="index.php?pg=event_report"><i class="fa fa-circle-o"></i>Event Report</a>
                </li>
              </ul>
            </li>
            
          </ul>
        </section>
        <!-- /.sidebar -->
      </aside>
      <!-- .............................................END OF NAVIGATION............................................. -->


     <?php
            if ($page == "report_incidents"){
               include "pages/incidents/report_incidents.php";
            } else if ($page == "incidents"){
               include "pages/incidents/incidents.php";
            } else if ($page == "incident_category"){
               include "pages/incidents/incident_category.php";
            } else if ($page == "haze"){
               include "pages/events/haze.php";
            } else if ($page == "dengue"){
               include "pages/events/dengue.php";  
            } else if ($page == "agency"){
               include "pages/contacts/agency.php";
            } else if ($page == "subscribers"){
               include "pages/contacts/subscribers.php"; 
            } else if ($page == "staff_accounts"){
               include "pages/accounts/staff_accounts.php";
            } else if ($page == "incident_report"){
               include "pages/reports/incident_report.php";
            } else if ($page == "event_report"){
               include "pages/reports/event_report.php";
            } else if ($page == "edit_profile"){
               include "pages/edit_profile.php";
            } else {
      ?>
      <!-- ...................................... MAIN CONTENT ................................................. -->
      <!-- DASHBOARD -->
      <!-- Content Wrapper. Contains page content -->
      <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>
            Dashboard
          </h1>
          <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
            <li class="active">Dashboard</li>
          </ol>
        </section>

        <!-- Main content -->
        <section class="content">
        
          <!-- Main row -->
          <div class="row">
            <!-- Left col -->
            <div class="col-md-8">
              <!-- MAP & BOX PANE -->
              <div class="box box-success">
                <div class="box-header with-border">
                  <h3 class="box-title">Map Overview</h3>
                  <div class="box-tools pull-right">
                    <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                    <button class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                  </div>
                </div><!-- /.box-header -->
                <div class="box-body no-padding">
                  <div class="row">
                    <div class="col-md-9 col-sm-8">
                      <div class="pad">
                        <!-- Map will be created here -->
                        <div id="world-map-markers" style="height: 325px;"><img src="dist/img/sample_map.gif" width="540px" height="325"></div>
                      </div>
                    </div><!-- /.col -->
                   <div class="col-md-3 col-sm-4">
                      <div class="pad box-pane-right bg-green" style="min-height: 280px">
                        <div class="description-block margin-bottom">
                          <div class="sparkbar pad" data-color="#fff"><u>PSI READING</u></div>
                          <h5 class="description-header">58</h5>
                        </div><!-- /.description-block -->
                        <div class="description-block margin-bottom">
                          <div class="sparkbar pad" data-color="#fff"><u>DATE / TIME</u></div>
                          <h5 class="description-header">16 March 2015</h5>
                          <span class="description-text">13:00</span>
                        </div><!-- /.description-block -->
                        <div class="description-block">
                          <div class="sparkbar pad" data-color="#fff"><u>AIR QUALITY</u></div>
                          <h5 class="description-header">Moderate</h5>
                        </div><!-- /.description-block -->
                      </div>
                    </div><!-- /.col -->	
                  </div><!-- /.row -->
                </div><!-- /.box-body -->
              </div><!-- /.box -->

            </div><!-- /.col -->

            <!-- INCIDENT CATEGORIES -->
            <div class='col-md-4'>
              <div class="box box-default">
                <div class="box-header with-border">
                  <h3 class="box-title">Incident Categories</h3>
                  <div class="box-tools pull-right">
                    <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                    <button class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                  </div>
                </div><!-- /.box-header -->
                <div class="box-footer no-padding">
                  <ul class="nav nav-pills nav-stacked">
                    <li><a href="#">Road-Traffic Accident <span class="pull-right text-green"> 12% </span></a></li>
                    <li><a href="#">Gas Incident  <span class="pull-right text-green"> 5% </span></a></li>
                    <li><a href="#">Construction Incident <span class="pull-right text-green"> 0% </span></a></li>
                    <li><a href="#">Suicide and Self-Harm Incident  <span class="pull-right text-green"> 12% </span></a></li>
                    <li><a href="#">Fire Incident  <span class="pull-right text-green"> 5% </span></a></li>
                    <li><a href="#">Physical Injuries <span class="pull-right text-green"> 0% </span></a></li>
                    <li><a href="#">Workplace Accidents  <span class="pull-right text-green"> 5% </span></a></li>
                    <li><a href="#">Others  <span class="pull-right text-green"> 5% </span></a></li>
                  </ul>
                </div><!-- /.footer -->
              </div><!-- /.box -->
            </div><!-- /.col -->
          </div><!-- /.row -->

          <!-- EVENTS -->
          <div class="row">
            <div class="col-md-8">
              <!-- TABLE: LATEST PSI READINGS -->
              <div class="box box-info">
                <div class="box-header with-border">
                  <h3 class="box-title">Dengue Cases</h3>
                  <div class="box-tools pull-right">
                    <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                    <button class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                  </div>
                </div><!-- /.box-header -->
                <div class="box-body">
                  <div class="table-responsive">
                    <table class="table no-margin">
                      <thead>
                        <tr>
                          <th>Region</th>
                          <th>No of people infected</th>
                          <th>Severity</th>
                          <th>Date / Time Record</th>
                        </tr>
                      </thead>
                      <tbody>
                        <tr>
                          <td>Central Area</td>
                          <td>15 people</td>
                          <td><span class="label label-danger">Alert</span></td>
                          <td><div class="sparkbar" data-color="#00a65a" data-height="20">16 March 2015 - 13:00</div></td>
                        </tr>
                        <tr>
                          <td>NorthEast Area</td>
                          <td>20 people</td>
                          <td><span class="label label-danger">Alert</span></td>
                          <td><div class="sparkbar" data-color="#f39c12" data-height="20">16 March 2015 - 13:00</div></td>
                        </tr>
                        <tr>
                          <td>NorthWest Area</td>
                          <td>3 people</td>
                          <td><span class="label label-info">Info</span></td>
                          <td><div class="sparkbar" data-color="#f56954" data-height="20">16 March 2015 - 13:00</div></td>
                        </tr>
                        <tr>
                          <td>SouthEast Area</td>
                          <td>9 people</td>
                          <td><span class="label label-warning">Warning</span></td>
                          <td><div class="sparkbar" data-color="#00c0ef" data-height="20">16 March 2015 - 13:00</div></td>
                        </tr>
                        <tr>
                          <td>SouthWest Area</td>
                          <td>10 people</td>
                          <td><span class="label label-warning">Warning</span></td>
                          <td><div class="sparkbar" data-color="#f39c12" data-height="20">16 March 2015 - 13:00</div></td>
                        </tr>
                        <tr>
                          <td>Cluster</td>
                          <td>10 people</td>
                          <td><span class="label label-warning">Warning</span></td>
                          <td><div class="sparkbar" data-color="#f56954" data-height="20">16 March 2015 - 13:00</div></td>
                        </tr>
                       
                      </tbody>
                    </table>
                  </div><!-- /.table-responsive -->
                </div><!-- /.box-body -->
                <div class="box-footer clearfix">
                  <a href="javascript::;" class="btn btn-sm btn-info btn-flat pull-left">Update Records</a>
                  <a href="javascript::;" class="btn btn-sm btn-default btn-flat pull-right">View Reports</a>
                </div><!-- /.box-footer -->
              </div><!-- /.box -->
            </div><!-- /.col -->

             <!-- RECENTLY ADDED INCIDENTS -->
            <div class="col-md-4">
              <div class="box box-primary">
                <div class="box-header with-border">
                  <h3 class="box-title">Recently Added Incidents</h3>
                  <div class="box-tools pull-right">
                    <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                    <button class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                  </div>
                </div><!-- /.box-header -->
                <div class="box-body">
                  <ul class="products-list product-list-in-box">
                    <li class="item">
                      <div class="product-img">
                        <img src="http://placehold.it/50x50/d2d6de/ffffff" alt="Product Image"/>
                      </div>
                      <div class="product-info">
                        <a href="javascript::;" class="product-title">[Incident Title] <span class="label label-success pull-right">On-Going</span></a>
                        <span class="product-description">
                          [Location / Address of the Incident]
                        </span>
                      </div>
                    </li><!-- /.item -->
                  </ul>
                </div><!-- /.box-body -->
                <div class="box-footer text-center">
                  <a href="javascript::;" class="uppercase">View All Incidents</a>
                </div><!-- /.box-footer -->
              </div><!-- /.box -->
            </div><!-- /.col -->
          </div><!-- /.row -->

        </section><!-- /.content -->
       
      </div><!-- /.content-wrapper -->
      <!-- ...................................... END OF MAIN CONTENT................................................. -->
      <?php } ?>


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

