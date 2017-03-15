/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activitat5u3;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 *
 * @author Eric
 */
public class ServidorUDPVector {
    
    public static final int PORT = 5487;
    
    public static void main(String[] args) throws SocketException, IOException, ClassNotFoundException{
        DatagramSocket socketServer = new DatagramSocket(PORT);
        
        byte[] cadena = new byte[1000];
        DatagramPacket dp = new DatagramPacket(cadena, cadena.length);
        socketServer.receive(dp);
        
        ByteArrayInputStream bais = new ByteArrayInputStream(dp.getData());
        ObjectInputStream ois = new ObjectInputStream(bais);
        Vector vector = (Vector) ois.readObject();
        
        for (String cadenas : vector.getCadena()) {
            System.out.println(cadenas);
        }
        
        byte[]resp = "OK".getBytes();
        DatagramPacket respuesta = new DatagramPacket(resp, resp.length, dp.getAddress(), dp.getPort());
        socketServer.send(respuesta);        
    }    
}
