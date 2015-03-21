<?php

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Description of CController
 *
 * @author Bryden
 */
abstract class CController {

    abstract protected function doPOST();

    abstract protected function doGET();

    public final function handleRequest() {
        if ($_SERVER['REQUEST_METHOD'] === 'POST') {
            $this->doPOST();
        } else {
            $this->doGET();
        }
    }

}
