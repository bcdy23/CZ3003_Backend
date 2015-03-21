<?php

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Description of MgrDemo
 *
 * @author Bryden
 */

include_once '../DAL/DALDemo.php';

class MgrDemo {

    function __construct() {
        
    }

    function insertValue($pStrValue) {
        $DALDEmo = new DALDemo();

        //May require validation e.g duplicate
        if ($DALDEmo->validateValue($pStrValue)) {
            $DALDEmo->addNewValue($pStrValue);
        }
    }

}
