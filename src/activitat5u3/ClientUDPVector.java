/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activitat5u3;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import javax.swing.JOptionPane;

/**
 *
 * @author Eric
 */
public class ClientUDPVector {
    
    final static String HOST = "localhost";
    final static int PORT = 5487;
    
    public static void main(String[] args) throws IOException{
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream os = new ObjectOutputStream(baos);
        String[] elements = new String[5];
        for (int i = 0; i < elements.length; i++) {
            elements[i] = JOptionPane.showInputDialog("Introdueix el element");
        }
        
        os.writeObject(new Vector(elements));
        os.flush();
        byte[] cadena = baos.toByteArray();
        InetAddress host = InetAddress.getByName(HOST);
        DatagramSocket clientSocket = new DatagramSocket();
        DatagramPacket dp = new DatagramPacket(cadena, cadena.length, host, PORT);
        clientSocket.send(dp);
        
        byte[] resposta = new byte[1000];
        DatagramPacket resp = new DatagramPacket(resposta, resposta.length);
        clientSocket.receive(resp);
        System.out.println("Rebut: " + new String(resp.getData()));
        clientSocket.close();
        
    }
    
    
}
