     
      <link href="dist/css/formStyle.css" rel="stylesheet" type="text/css" />
      <script src='script/incident_categories.js'></script>
      
      <!-- ........................................COPY HERE........................................ -->
      <!-- Content Wrapper. Contains page content -->
      <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>
            Incident
            <small> to add, edit, or remove incident category</small>
          </h1>
          <ol class="breadcrumb">
            <li><a href="index.php?pg=dashboard"><i class="fa fa-dashboard"></i> Home</a></li>
            <li><a href="#">Incidents</a></li>
            <li class="active">Incident Category</li>
          </ol>
        </section>

        <!-- Main content -->
        <section class="content">
          <div style="width:200px; float:right; margin-top:10px; margin-bottom:10px; ">
            <button class="btn btn-block btn-success" id="add_incident_categories_btn">Add Incident Category</button>
          </div>

          <div class="row">
            <div class="col-xs-12">
              <div class="box">
                <div class="box-header">
                  <h3 class="box-title">Incident Categories</h3>
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
                      <th>Incident Category</th>
                      <th>Description</th>
                      <th>Action</th>
                    </tr>
                    <tr>
                      <td>1</td>
                      <td>Fire Incident</td>
                      <td>[Description of incident category , who to report to if this happened]</td>
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

    
    <!-- Add Categories Form -->
    <div id="add_incident_categories_field">
        <form role="form" id="add_incident_categories_form">
            <div align="right" style="padding-top:20px"><a href="#" id='close_button'> &nbsp;</a></div>
            <h4>Add Incident Categories</h4>
            <div class="box-body">
            <!-- Incident Category -->
            <div class="form-group">
                <label>Incident Category</label>
                <input type="text" class="form-control" id="incident_category_input" placeholder="Enter incident categories">
            </div>
            <!-- Incident Category Description -->
            <div class="form-group">
                <label>Description</label>
                <textarea id="incident_category_description_input" class="form-control" rows="3" placeholder="Enter incident category description" style="resize:vertical"></textarea>
            </div>
            </div><!-- /.box-body -->

            <div class="box-footer">
                 <button type="submit" class="btn btn-primary">Submit</button>
            </div>
        </form>
    </div>



 
 


    
