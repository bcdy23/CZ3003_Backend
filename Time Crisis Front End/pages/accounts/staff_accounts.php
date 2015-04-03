      <link href="dist/css/formStyle.css" rel="stylesheet" type="text/css" />
      <script src="script/staff_accounts.js"></script>

      <!-- ........................................COPY HERE........................................ -->
      <!-- Content Wrapper. Contains page content -->
      <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>
            Accounts
            <small> to manage call operator and administrator accounts</small>
          </h1>
          <ol class="breadcrumb">
            <li><a href="index.php?pg=dashboard"><i class="fa fa-dashboard"></i> Home</a></li>
            <li><a href="#">Accounts</a></li>
            <li class="active">Staff Accounts</li>
          </ol>
        </section>

        <!-- Main content -->
        <section class="content">
          <div style="width:200px; float:right; margin-top:10px; margin-bottom:10px; ">
            <button class="btn btn-block btn-success" id="add_staff_accounts_btn">Add Account</button>
          </div>

          <div class="row">
            <div class="col-xs-12">
              <div class="box">
                <div class="box-header">
                  <h3 class="box-title">Staff Accounts</h3>
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
                      <th>Profile Picture</th>
                      <th>Full Name</th>
                      <th>Email</th>
                      <th>Contact</th>
                      <th>Role</th>
                      <th>Status</th>
                      <th>Action</th>
                    </tr>
                    <tr>
                      <td>1.</td>
                      <td><img src="dist/img/avatar5.png" class="img-circle" alt="User Image" width="80px" height="80px" /></td>
                      <td>[Staff name]</td>
                      <td>[Email address]</td>
                      <td>[Mobile phone]</td>
                      <td>[Administrator / Call Operator]</td>
                      <td><span class="label label-success">Active</span></td>
                      <td><a href="#"> Edit </a> | <a href="#">Delete</a></td>
                    </tr>
                    <tr>
                      <td>2.</td>
                      <td><img src="dist/img/avatar2.png" class="img-circle" alt="User Image" width="80px" height="80px" /></td>
                      <td>[Staff name]</td>
                      <td>[Email address]</td>
                      <td>[Mobile phone]</td>
                      <td>[Administrator / Call Operator]</td>
                      <td><span class="label label-danger">Inactive</span></td>
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


    <!-- Add Staff Accounts Form -->
    <div id="add_staff_accounts_field">
        <form role="form" id="add_staff_accounts_form">
            <div align="right" style="padding-top:20px"><a href="#" id='close_button'> &nbsp;</a></div>
            <h4>Add Staff Accounts</h4>
            <div class="box-body">
            <!-- Profile Picture -->
            <div class="form-group">
                <label>Profile Picture</label>
                <input type="file" id="profile_picture_inputfile">
            </div>
            <!-- Full Name -->
            <div class="form-group">
                <label>Full Name</label>
                <input type="text" class="form-control" id="full_name_input" placeholder="Enter full name">
            </div>
            <!-- Email -->
            <div class="form-group">
                <label>Email</label>
                <input type="email" class="form-control" id="email_input" placeholder="Enter email">
            </div>
            <!-- Contact -->
            <div class="form-group">
                <label>Contact</label>
                <div class="input-group">
                  <div class="input-group-addon"><i class="fa fa-phone"></i></div>
                  <input type="text" class="form-control" id="contact_input" placeholder="Enter contact no"/>
                </div>
            </div>
            <!-- Role : Administrator, Call Operator -->
            <div class="form-group">
               <label>Role</label>
                <select class="form-control" id="role_input">
                   <option value="Administrator">Administrator</option>
                   <option value="Call Operator">Call Operator</option>
                </select>
            </div>
            <!-- Status : Active, Inactive -->
            <div class="form-group">
               <label>Status</label>
                <select class="form-control" id="status_input">
                   <option value="Active">Active</option>
                   <option value="Inactive">Inactive</option>
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