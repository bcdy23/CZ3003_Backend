<?php

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Description of CtrlDemo
 *
 * @author Bryden
 */
include_once 'CController.php';
include_once '../Manager/MgrDemo.php';

class CtrlDemo extends CController {

    protected function doGET() {
        
    }

    protected function doPOST() {
        $strValue = $_POST['txtValue'];

        //Need to validate input for blacklist chars etc
        if (!preg_match("/[^a-zA-Z0-9]+/", $strValue)) {

                       
            $Mgr = new MgrDemo();
            $Mgr->insertValue($strValue);
        } else {
            echo("Invalid Input");
        }
    }

}

$x = new CtrlDemo();
$x->handleRequest();

