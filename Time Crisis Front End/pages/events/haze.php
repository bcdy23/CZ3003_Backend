      <link href="dist/css/formStyle.css" rel="stylesheet" type="text/css" />
      <script src="script/haze.js"></script>

      <!-- ........................................COPY HERE........................................ -->
      <!-- Content Wrapper. Contains page content -->
      <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>
            Events
            <small> List of all haze records</small>
          </h1>
          <ol class="breadcrumb">
            <li><a href="index.php?pg=dashboard"><i class="fa fa-dashboard"></i> Home</a></li>
            <li><a href="#">Events</a></li>
            <li class="active">Haze</li>
          </ol>
        </section>

        <!-- Main content -->
        <section class="content">
          <div class="row">
            <div class="col-xs-12">
              <div class="box">
                <div class="box-header">
                  <h3 class="box-title">Haze</h3>
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
                      <th>Region</th>
                      <th>PSI Value</th>
                      <th>Air Quality Descriptor</th>
                      <th>Date/Time</th>
                    </tr>
                    <tr>
                      <td>1.</td>
                      <td>[Region in Singapore]</td>
                      <td>[PSI Value]</td>
                      <td><span class="label label-success">Good</span></td>
                      <td>[Date/Time]</td>
                    </tr>
                    <tr>
                      <td>2.</td>
                      <td>[Region in Singapore]</td>
                      <td>[PSI Value]</td>
                      <td><span class="label label-info">Moderate</span></td>
                      <td>[Date/Time]</td>
                    </tr>
                    <tr>
                      <td>3.</td>
                      <td>[Region in Singapore]</td>
                      <td>[PSI Value]</td>
                      <td><span class="label label-warning">Unhealthy</span></td>
                      <td>[Date/Time]</td>
                    <tr>
                      <td>4.</td>
                      <td>[Region in Singapore]</td>
                      <td>[PSI Value]</td>
                      <td><span class="label label-danger">Hazardous</span></td>
                      <td>[Date/Time]</td>
                    </tr>
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


      <!-- Add PSI Readings - Haze Form -->
    <div id="add_haze_field">
        <form role="form" id="add_haze_form">
            <div align="right" style="padding-top:20px"><a href="#" id='close_button'> &nbsp;</a></div>
            <h4>Add PSI Readings</h4>
            <div class="box-body">
            <!-- Region -->
            <div class="form-group">
                <label>Region</label>
                <input type="text" class="form-control" id="region_input" placeholder="Enter region in Singapore">
            </div>
            <!-- PSI Value -->
            <div class="form-group">
                <label>PSI Value</label>
                <input type="text" class="form-control" id="psi_value_input" placeholder="Enter PSI value of the region">
            </div>
            <!-- Air Quality Descriptor : Good, Moderate, Unhealthy, Hazardous -->
            <div class="form-group">
               <label>Air Quality Descriptor</label>
                <select class="form-control" id="severity_input">
                   <option value="good">Good</option>
                   <option value="moderate">Moderate</option>
                   <option value="unhealthy">Unhealthy</option>
                   <option value="hazardous">Hazardous</option>
                </select>
            </div>
            <!-- Date / Time -->
            <div class="form-group">
                <label>Date/Time</label>
                <div class="input-group">
                  <div class="input-group-addon"><i class="fa fa-calendar"></i></div>
                  <input type="text" class="form-control" id="datetime_input" placeholder="yyyy-mm-dd HH:mm"/>
                </div>
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