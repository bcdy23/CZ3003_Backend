class GetRestParamRoute extends CakeRoute {
function parse($url) {
    $params = parent::parse($url);

    if(count($_GET) > 1){


        $obj = new stdClass();
        foreach($_GET as $get_var_name => $get_var_value){

            if($get_var_name == "url") continue;

            $obj->$get_var_name = $get_var_value;
        }


        $params['pass'][] = $obj;
    }

    return $params;
}