      <link href="dist/css/formStyle.css" rel="stylesheet" type="text/css" />
      <script src="script/agency.js"></script>

      <!-- ........................................COPY HERE........................................ -->
      <!-- Content Wrapper. Contains page content -->
      <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>
            Contacts
            <small> to manage email and contacts of agencies for dispatching of notifications</small>
          </h1>
          <ol class="breadcrumb">
            <li><a href="index.php?pg=dashboard"><i class="fa fa-dashboard"></i> Home</a></li>
            <li><a href="#">Contacts</a></li>
            <li class="active">Agencies</li>
          </ol>
        </section>

        <!-- Main content -->
        <section class="content">
          <div style="width:200px; float:right; margin-top:10px; margin-bottom:10px; ">
            <button class="btn btn-block btn-success" id="add_agency_btn">Add Agency Contact</button>
          </div>

          <div class="row">
            <div class="col-xs-12">
              <div class="box">
                <div class="box-header">
                  <h3 class="box-title">Agencies</h3>
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
                      <th>Agency</th>
                      <th>Contact</th>
                      <th>Type of Incident</th>
                      <th>Action</th>
                    </tr>
                    <tr>
                      <td>1.</td>
                      <td>[Agency Name]</td>
                      <td>[Contact]</td>
                      <td>[Incident Category]</td>
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


      <!-- Add Agency Form -->
    <div id="add_agency_field">
        <form role="form" id="add_agency_form">
            <div align="right" style="padding-top:20px"><a href="#" id='close_button'> &nbsp;</a></div>
            <h4>Add Agency</h4>
            <div class="box-body">
            <!-- Agency -->
            <div class="form-group">
                <label>Agency</label>
                <input type="text" class="form-control" id="agency_input" placeholder="Enter agency">
            </div>
            <!-- Contact -->
            <div class="form-group">
                <label>Contact</label>
                <div class="input-group">
                  <div class="input-group-addon"><i class="fa fa-phone"></i></div>
                  <input type="text" class="form-control" id="contact_input" placeholder="Enter contact no"/>
                </div>
            </div>
            <!-- Incident Category -->
            <div class="form-group">
               <label>Type of Incident</label>
                <select class="form-control" id="incident_category_id">
                   <option value="1">[Incident Category 1]</option>
                   <option value="2">[Incident Category 2]</option>
                </select>
            </div>
            </div> <!--./box-body-->
            <div class="box-footer">
                 <button type="submit" class="btn btn-primary">Submit</button>
            </div>
        </form>
    </div>