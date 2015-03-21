<?php

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Description of CNetworkMgr
 *
 * @author Bryden
 */
class CNetworkMgr {

    private $objSocket;

    function __construct() {
        $this->objSocket = socket_create(AF_INET, SOCK_STREAM, SOL_TCP);
    }

    function sendData($pObjValue) {

        socket_connect($this->objSocket, '127.0.0.1', '3003');

        socket_write($this->objSocket, $pObjValue . "\n");


        
        while ($out = socket_read($this->objSocket, 2048)) {
            echo "Result : " . $out;
        }

        socket_close($this->objSocket);
    }

}
