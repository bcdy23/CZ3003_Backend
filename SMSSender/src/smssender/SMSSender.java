/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smssender;

import jssc.SerialPort;
import jssc.SerialPortException;

/**
 *
 * @author Bryden
 */
public class SMSSender {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {

        String strNumber = "+6596730427";

        char EOF = 26;

        SerialPort serialPort = new SerialPort("COM5");
        try {
            serialPort.openPort();//Open serial port
            serialPort.setParams(SerialPort.BAUDRATE_9600,
                    SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE);//Set params. Also you can set params by this string: serialPort.setParams(9600, 8, 1, 0);

            for (int i = 0; i < 20; i++) {
                serialPort.writeBytes("AT+CMGF=1\r\n".getBytes());

                byte[] buffer = serialPort.readBytes(10);//Read 10 bytes from serial port

                System.out.println(new String(buffer));

                Thread.sleep(100);

                serialPort.writeBytes(("AT+CMGS=\"" + strNumber + "\"\r\n").getBytes());//Write data to port

                Thread.sleep(100);

                buffer = serialPort.readBytes(10);//Read 10 bytes from serial port

                System.out.println(new String(buffer));

                serialPort.writeBytes(("SHOUBI and VICKY GO Japan TOGETHER " + i + " Times" + EOF + "\r\n").getBytes());

                Thread.sleep(100);

                buffer = serialPort.readBytes(1000);//Read 10 bytes from serial port

                System.out.println(new String(buffer));

            }

            serialPort.closePort();
        } catch (SerialPortException ex) {
            System.out.println(ex);
        } finally {
            System.out.println("done");
        }

    }

}
