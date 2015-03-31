      <link href="dist/css/formStyle.css" rel="stylesheet" type="text/css" />
      <script src="script/incidents.js"></script>

      <!-- ........................................COPY HERE........................................ -->
      <!-- Content Wrapper. Contains page content -->
      <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>
            Incident
            <small> to add, edit, or remove incident</small>
          </h1>
          <ol class="breadcrumb">
            <li><a href="index.php?pg=dashboard"><i class="fa fa-dashboard"></i> Home</a></li>
            <li><a href="#">Incidents</a></li>
            <li class="active">Incidents</li>
          </ol>
        </section>

        <!-- Main content -->
        <section class="content">
          <div style="width:200px; float:right; margin-top:10px; margin-bottom:10px; ">
            <button class="btn btn-block btn-success" id="add_incident_btn">Add Incident</button>
          </div>

          <div class="row">
            <div class="col-xs-12">
              <div class="box">
                <div class="box-header">
                  <h3 class="box-title">Incident</h3>
                  <div class="box-tools">
                    <div class="input-group">
                      <input type="text" name="table_search" class="form-control input-sm pull-right" style="width: 150px;" placeholder="Search"/>
                      <div class="input-group-btn">
                        <button class="btn btn-sm btn-default"><i class="fa fa-search"></i></button>
                      </div>
                    </div>
                  </div>
                </div><!-- /.box-header -->
                <div class="box-body table-responsive no-padding">
                  <table class="table table-hover">
                    <tr>
                      <th>No.</th>
                      <th>Incident</th>
                      <th>Date/Time</th>
                      <th>Location</th>
                      <th>Category</th>
                      <th>Status</th>
                      <th>Action</th>
                    </tr>
                    <?php 
                      foreach ($incidents as $i) {               
                          $status = $i->get('incidentStatus');
                          echo $this->Html->tableCells(
                              array(
                                  $i->get('incidentID'),
                                  $i->get('incidentTitle'),
                                  $i->get('incidentDateTime'),
                                  $i->get('address'),
                                  $i->get('incidentCategoryID'),
                                  "<span class=\"label ".($status ? "label-success\">" : "label-danger\">").$status."</span>",
                                  '<a href="#"> Edit </a> | <a href="#">Delete</a>'
                              )
                          );
                      }
                    ?>
                  </table>
                </div><!-- /.box-body -->
                <!-- footer pagination -->
                <div class="box-footer clearfix">
                  <ul class="pagination pagination-sm no-margin pull-right">
                    <li><a href="#">&laquo;</a></li>
                    <li><a href="#">1</a></li>
                    <li><a href="#">2</a></li>
                    <li><a href="#">3</a></li>
                    <li><a href="#">&raquo;</a></li>
                  </ul>
                </div>
                <!-- /.footer pagination -->
              </div><!-- /.box -->
            </div>
          </div>
        </section><!-- /.content -->
      </div><!-- /.content-wrapper -->

    <!-- Add Incident Form -->
    <div id="add_incident_field">
        <form role="form" id="add_incident_form">
            <div align="right" style="padding-top:20px"><a href="#" id='close_button'> &nbsp;</a></div>
            <h4>Add Incident</h4>
            <div class="box-body">
            <!-- Incident Title -->
            <div class="form-group">
                <label>Incident Title</label>
                <input type="text" class="form-control" id="incident_title_input" placeholder="Enter incident categories">
            </div>
            <!-- Date / Time -->
            <div class="form-group">
                <label>Date/Time</label>
                <div class="input-group">
                  <div class="input-group-addon"><i class="fa fa-calendar"></i></div>
                  <input type="text" class="form-control" id="incident_datetime_input" placeholder="yyyy-mm-dd HH:mm"/>
                </div><!-- /.input group -->
            </div><!-- /.form group -->
            <!-- Location -->
            <div class="form-group">
                <label>Location</label>
                <input type="text" class="form-control" id="incident_location_input" placeholder="Enter the location where the incident happened">
            </div>
            <!-- Incident Category -->
            <div class="form-group">
               <label>Incident Category</label>
                <select class="form-control" id="incident_category_id">
                   <option value="1">[Incident Category 1]</option>
                   <option value="2">[Incident Category 2]</option>
                </select>
            </div>
            <!-- Status : On-going, Closed -->
            <div class="form-group">
               <label>Status</label>
                <select class="form-control" id="incident_status">
                   <option value="ongoing">On-going</option>
                   <option value="closed">Closed</option>
                </select>
            </div>
            <!-- Remarks -->
            <div class="form-group">
                <label>Remarks</label>
                <textarea class="form-control" rows="3" placeholder="Enter remarks" style="resize:vertical"></textarea>
            </div>
            </div> <!--./box-body-->
            <div class="box-footer">
                 <button type="submit" class="btn btn-primary">Submit</button>
            </div>
        </form>
    </div>
 