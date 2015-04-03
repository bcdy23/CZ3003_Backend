      <!-- ........................................COPY HERE........................................ -->
      <!-- Content Wrapper. Contains page content -->
      <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>
            Incident
            <small> to post or discard the incident reported by the public</small>
          </h1>
          <ol class="breadcrumb">
            <li><a href="index.php?pg=dashboard"><i class="fa fa-dashboard"></i> Home</a></li>
            <li><a href="#">Incidents</a></li>
            <li class="active">Report Incidents</li>
          </ol>
        </section>

        <!-- Main content -->
        <section class="content">

          <div style="width:200px; float:right; margin-top:10px; margin-bottom:10px; ">
            &nbsp;
          </div>

          <div class="row">
            <div class="col-xs-12">
              <div class="box">
                <div class="box-header">
                  <h3 class="box-title">Report Incidents </h3>
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
                    <tr>
                      <td>1</td>
                      <td>[Incident Title]</td>
                      <td>[Date, Time]</td>
                      <td>[Location]</td>
                      <td>Road/Traffic Accident</td>
                      <td><span class="label label-success">Posted</span></td>
                      <td><a href="#"> Edit </a> | <a href="#">Delete</a></td>
                    </tr>
                    <tr>
                      <td>2</td>
                      <td>[Incident Title]</td>
                      <td>[Date, Time]</td>
                      <td>[Location]</td>
                      <td>Fire Accident</td>
                      <td><span class="label label-warning">Pending</span></td>
                      <td><a href="#"> Edit </a> | <a href="#">Delete</a></td>
                    </tr>
                    <tr>
                      <td>3</td>
                      <td>[Incident Title]</td>
                      <td>[Date, Time]</td>
                      <td>[Location]</td>
                      <td>Fire Accident</td>
                      <td><span class="label label-info">Duplicates</span></td>
                      <td><a href="#"> Edit </a> | <a href="#">Delete</a></td>
                    </tr>
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