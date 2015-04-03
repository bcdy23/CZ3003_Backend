     <!-- Content Wrapper. Contains page content -->
      <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>
            Edit Profile
          </h1>
          <ol class="breadcrumb">
            <li><a href="index.php?pg=dashboard"><i class="fa fa-dashboard"></i> Home</a></li>
            <li class="active">Edit Profile</li>
          </ol>
        </section>

        <section class="content">
          <div class="row">
            <!-- left column -->
            <div class="col-xs-12">
              <!-- general form elements -->
              <div class="box box-primary">
                <div class="box-header">
                  <h3 class="box-title">General Details</h3>
                </div><!-- /.box-header -->
                <!-- form start -->
                <form role="form">
                  <div class="box-body">
                    <!-- Profile Picture -->
                    <div class="form-group">
                      <label for="exampleInputFile">Profile Picture</label>
                      <input type="file" id="profile_picture_input">
                      <p class="help-block">Example block-level help text here.</p>
                    </div>
                    <!-- Full Name -->
                    <div class="form-group">
                      <label for="exampleInputEmail1">Full Name</label>
                      <input type="text" class="form-control" id="full_name_input" placeholder="Enter full name">
                    </div>
                    <!-- Email Address -->
                    <div class="form-group">
                      <label for="exampleInputEmail1">Email</label>
                      <input type="email" class="form-control" id="email_input" placeholder="Enter email">
                    </div>
                    <!-- Contact -->
                    <div class="form-group">
                      <label for="exampleInputEmail1">Contact</label>
                      <input type="text" class="form-control" id="contact_input" placeholder="Enter contact number">
                    </div>
                    <!-- Role: administrator, call operator -->
                    <div class="form-group">
                       <label>Role</label>
                        <select class="form-control" id="role_input">
                           <option value="Administrator">Administrator</option>
                           <option value="Call Operator">Call Operator</option>
                        </select>
                    </div>
                    <!-- Status: active, inactive -->
                    <div class="form-group">
                       <label>Status</label>
                        <select class="form-control" id="status_input">
                           <option value="Administrator">Active</option>
                           <option value="Call Operator">Inactive</option>
                        </select>
                    </div>

                    <div class="box-footer">
                    <button type="submit" class="btn btn-primary">Submit</button>
                  </div>
                </form>
              </div><!-- /.box -->
             </div><!--/.col (right) -->
          </div>   <!-- /.row -->
        </section><!-- /.content -->

        <section class="content">
            <div class="row">
            <!-- left column -->
              <!-- left column -->
            <div class="col-xs-12">
              <!-- general form elements -->
              <div class="box box-primary">
                <div class="box-header">
                  <h3 class="box-title">Reset Password</h3>
                </div><!-- /.box-header -->
                <!-- form start -->
                <form role="form">
                  <div class="box-body">
                    <div class="form-group">
                      <label for="exampleInputPassword1">Old Password</label>
                      <input type="password" class="form-control" id="old_password_input" placeholder="Enter old password">
                    </div>

                    <div class="form-group">
                      <label for="exampleInputPassword1">New Password</label>
                      <input type="password" class="form-control" id="new_password_input" placeholder="Enter new password">
                    </div>

                    <div class="form-group">
                      <label for="exampleInputPassword1">Confirm Password</label>
                      <input type="password" class="form-control" id="confirm_password_input" placeholder="Enter confirm password">
                    </div>
                    
                  
                  </div><!-- /.box-body -->

                  <div class="box-footer">
                    <button type="submit" class="btn btn-primary">Submit</button>
                  </div>
                </form>
              </div><!-- /.box -->
  
            </div><!--/.col (right) -->
          </div>   <!-- /.row -->
        </section><!-- /.content -->
      </div><!-- /.content-wrapper -->