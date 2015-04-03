      <!-- ........................................COPY HERE........................................ -->
      <!-- Content Wrapper. Contains page content -->
      <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>
            Report An Incident
            <small> Submit a incident report of what's happening in your area</small>
          </h1>
          <ol class="breadcrumb">
            <li><a href="index.php?pg=dashboard"><i class="fa fa-dashboard"></i> Home</a></li>
            <li><a href="#">Incidents</a></li>
            <li class="active">Report An Incident</li>
          </ol>
        </section>

        <!-- Main content -->
        <section class="content">

          <div class="row">
            <div class="col-xs-8">
              <div class="box">
                  <form role="form" id="add_incident_form">
                    <div class="box-body">
                    <!-- Incident Title -->
                    <div class="form-group">
                        <label>Incident Title</label>
                        <input type="text" class="form-control" id="incident_title_input" placeholder="Enter incident categories">
                    </div>
                    
                    <!-- Details -->
                    <div class="form-group">
                        <label>Details</label>
                        <textarea class="form-control" id="incident_details_input" rows="3" placeholder="Enter details" style="resize:vertical"></textarea>
                    </div>
                    
                    <!-- Date / Time -->
                    <div class="form-group">
                        <label>Date/Time</label>
                        <div class="input-group">
                          <div class="input-group-addon"><i class="fa fa-calendar"></i></div>
                          <input type="text" class="form-control" id="incident_datetime_input" placeholder="yyyy-mm-dd HH:mm"/>
                        </div><!-- /.input group -->
                    </div><!-- /.form group -->
                    
                    <!-- Address -->
                    <div class="form-group">
                        <label>Address</label>
                        <input type="text" class="form-control" id="incident_postal_input" placeholder="Enter the address of where the incident happened">
                    </div>
                    
                    <!-- Postal -->
                    <div class="form-group">
                        <label>Postal Code</label>
                        <input type="text" class="form-control" id="incident_postal_input" maxlength="7" placeholder="Enter the postal code of where the incident happened">
                    </div>
                    
                    <div class="form-group">
                        <label>Name</label>
                        <input type="text" class="form-control" id="incident_pname_input" placeholder="Enter your name">
                    </div>
                    
                    <div class="form-group">
                        <label>Contact</label>
                        <input type="text" class="form-control" id="incident_pcontact_input" placeholder="Enter your contact number">
                    </div>
                    
                    </div> <!--./box-body-->
                    <div class="box-footer">
                         <button type="submit" class="btn btn-primary">Submit</button>
                    </div>
                </form>
              </div><!-- /.box -->
            </div>
          </div>
        </section><!-- /.content -->
      </div><!-- /.content-wrapper -->