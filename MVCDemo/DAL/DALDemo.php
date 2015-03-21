<?php

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Description of DALDemo
 *
 * @author Bryden
 */

include_once '../Network/CNetworkMgr.php';

class DALDemo {

    function __construct() {
        
    }

    function addNewValue($pStrValue) {
        $NetworkMgr = new CNetworkMgr();
        $NetworkMgr->sendData($pStrValue);
    }

    public function validateValue($pStrValue) {
        return true;
    }

}
