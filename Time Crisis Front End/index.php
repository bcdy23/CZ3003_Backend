<?php
    #Dynamically change the page based on the URL
    if(isset($_GET['pg'])) {
      $page=$_GET['pg'];
    } else {
      $page='dashboard';
    }
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
    
    
    <!-- START OF GOOGLE MAPS API -->

    <script src="https://maps.googleapis.com/maps/api/js?v=3.exp&signed_in=true"></script>
    <script>
// This example displays a marker at the center of Singapore.
// When the user clicks the marker, an info window opens.

function initialize() {
  var myLatlng = new google.maps.LatLng(1.337831, 103.832363);
  var myLatlng2 = new google.maps.LatLng(1.349641, 103.682941);
  var mapOptions = {
    zoom: 11,
    center: myLatlng
  };

  var map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);

  var contentString = '<div id="content">'+
      '<div id="siteNotice">'+
      '</div>'+
      '<h4 id="firstHeading" class="firstHeading">Fire Outbreak (Blk 236 Bishan St 81)</h4>'+
      '<div id="bodyContent">'+
      '<p>A fire outbreak at Blk 236 Bishan Street 81 #02-492 has occurred.</p>'+
      '<p><a href="https://en.wikipedia.org/w/index.php?title=Uluru&oldid=297882194" target="_blank">'+
      'More Details</a></p>'+
      '</div>'+
      '</div>';
      
  var infowindow = null;

  var marker = new google.maps.Marker({
      position: myLatlng,
      map: map,
      //Hover pop up description
      title: 'Fire Outbreak (Bishan)'
  });
  
  google.maps.event.addListener(marker, 'click', function() {
    
    if (infowindow) {
      infowindow.close();
    }
    
    infowindow = new google.maps.InfoWindow({
      content: contentString
    });
    
    infowindow.open(map, marker);
    
  });
  
  var contentString2 = '<div id="content">'+
    '<div id="siteNotice">'+
    '</div>'+
    '<h4 id="firstHeading" class="firstHeading">Road Accident (LWN Bus Stop)</h4>'+
    '<div id="bodyContent">'+
    '<p>A road accident at NTU LWN Bus Stop has occurred.</p>'+ 
    '<p><a href="#" target="_blank">'+
    'More Details</a></p>'+
    '</div>'+
    '</div>';

  var marker2 = new google.maps.Marker({
      position: myLatlng2,
      map: map,
      //Hover pop up description
      title: 'Road Accident (NTU)'
  });
  
  google.maps.event.addListener(marker2, 'click', function() {
    
    if (infowindow) {
      infowindow.close();
    }
    
    infowindow = new google.maps.InfoWindow({
      content: contentString2
    });
    
    infowindow.open(map, marker2);
  });
  
}

google.maps.event.addDomListener(window, 'load', initialize);
    <!-- END OF GOOGLE MAPS API -->
    </script>
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
                <a href="http://www.facebook.com/" target="_blank">
                  <span class="hidden-xs">Facebook</span>
                </a>
              </li>
	      
	      <li class="#">
                <a href="http://www.twitter.com/" target="_black">
                  <span class="hidden-xs">Twitter</span>
                </a>
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

          
          <!-- sidebar menu: : style can be found in sidebar.less -->
          <ul class="sidebar-menu">
            <li class="header">MAIN NAVIGATION</li>
            <?php if ($page == "dashboard"){ ?>  <li class= "active treeview"> <?php }else{ ?> <li class= "treeview"> <?php }?>
              <a href="index.php?pg=dashboard">
                <i class="fa fa-dashboard"></i> <span>Home</span> </i>
              </a>
            </li>
	    
	    <?php if ($page == 'about') { ?>
	      <li class="active treeview"> <?php } else { ?> <li class="treeview"> <?php } ?>
	      <a href="index.php?pg=about">
		<i class="fa fa-dashboard"></i> <span>About</span>
	      </a>
	    </li>

            <!-- MANAGE INCIDENTS-->
            <?php if ($page == "report_incidents" || $page == "incidents" || $page == "incident_category"){ ?>  <li class= "active"> <?php }else{ ?> <li> <?php }?>
              <a href="#">
                <i class="fa fa-files-o"></i>
                <span>Incidents</span>
		<i class="fa fa-angle-left pull-right"></i>
              </a>
              <ul class="treeview-menu">
                <?php if ($page == "report_incidents"){ ?>  <li class= "active"> <?php }else{ ?> <li> <?php }?>
                    <a href="index.php?pg=report_incidents"><i class="fa fa-circle-o"></i>Report An Incident</a>
                </li>
                <?php if ($page == "incidents"){ ?>  <li class= "active"> <?php }else{ ?> <li> <?php }?>
                    <a href="index.php?pg=incidents"><i class="fa fa-circle-o"></i>Incidents</a>
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
            <?php if ($page == "contact"){ ?>  <li class= "active"> <?php }else{ ?> <li> <?php }?>
              <a href="index.php?pg=contact">
                <i class="fa fa-envelope"></i>
                <span>Contact</span>
              </a>
            </li>
	    
	    <!-- MANAGE SUBSCRIBE -->
            <?php if ($page == "subscribe"){ ?>  <li class= "active"> <?php }else{ ?> <li> <?php }?>
              <a href="index.php?pg=subscribe">
                <i class="fa fa-envelope"></i>
                <span>Subscribe</span>
              </a>
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
	    } else if ($page == "about"){
	       include "pages/about/about.php";
	    } else if ($page == "contact") {
	       include "pages/contacts/contact.php";
            } else if ($page == "subscribe") {
	       include "pages/subscribe/subscribe.php";
            }else {
      ?>
      <!-- ...................................... MAIN CONTENT ................................................. -->
      <!-- DASHBOARD -->
      <!-- Content Wrapper. Contains page content -->
      <div class="content-wrapper">

        <!-- Main content -->
        <section class="content">
	  
	  <div id="map-canvas" style="width: 100%; height: 400px; box-shadow: 0px 0px 1px #999999; margin-bottom: 20px;"></div>
        
          <!-- Main row -->
          <div class="row">
            <!-- Left col -->
            <div class="col-md-8">
              <!-- TABLE: LATEST DENGUE READINGS -->
              <div class="box box-info">
                <div class="box-header with-border">
                  <h3 class="box-title">Recent Incidents</h3>
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
                          <th>Incident</th>
                          <th>Date/Time</th>
                          <th>Location</th>
                          <th>Status</th>
                        </tr>
                      </thead>
                      <tbody>
                        <tr>
                          <td><a href="#">[Incident Title]</a></td>
			  <td><div class="sparkbar" data-color="#00a65a" data-height="20">16 March 2015 - 13:00</div></td>
                          <td>[Location]</td>
                          <td><span class="label label-success">On-going</span></td>
                        </tr>
                        <tr>
                          <td><a href="#">[Incident Title]</a></td>
			  <td><div class="sparkbar" data-color="#f39c12" data-height="20">16 March 2015 - 13:00</div></td>
                          <td>[Location]</td>
                          <td><span class="label label-danger">Alert</span></td>
                        </tr>
                        <tr>
                          <td><a href="#">[Incident Title]</a></td>
			  <td><div class="sparkbar" data-color="#f56954" data-height="20">16 March 2015 - 13:00</div></td>
                          <td>[Location]</td>
                          <td><span class="label label-info">Info</span></td>
                        </tr>
                        <tr>
                          <td><a href="#">[Incident Title]</a></td>
			  <td><div class="sparkbar" data-color="#00c0ef" data-height="20">16 March 2015 - 13:00</div></td>
                          <td>[Location]</td>
                          <td><span class="label label-warning">Warning</span></td>
                        </tr>
                        <tr>
                          <td><a href="#">[Incident Title]</a></td>
			  <td><div class="sparkbar" data-color="#f39c12" data-height="20">16 March 2015 - 13:00</div></td>
                          <td>[Location]</td>
                          <td><span class="label label-warning">Warning</span></td>
                        </tr>
                        <tr>
                          <td><a href="#">[Incident Title]</a></td>
			  <td><div class="sparkbar" data-color="#f56954" data-height="20">16 March 2015 - 13:00</div></td>
                          <td>[Location]</td>
                          <td><span class="label label-warning">Warning</span></td>
                          
                        </tr>
                       
                      </tbody>
                    </table>
                  </div><!-- /.table-responsive -->
                </div><!-- /.box-body -->
                <div class="box-footer clearfix">
                  <a href="index.php?pg=incidents" class="btn btn-sm btn-info btn-flat pull-left">View All Incidents</a>
                </div><!-- /.box-footer -->
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
              <!-- TABLE: LATEST DENGUE READINGS -->
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

