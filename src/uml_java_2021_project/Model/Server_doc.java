/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uml_java_2021_project.Model;

import GUI.Doctor_webpage;
import GUI.Test_interface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author Fadwa
 */
public class Server_doc extends Thread {

    private ServerSocket serverSocket;
    boolean is_confirmed_by_client = false;
    int port;

    public Server_doc(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("The connection port is: " + serverSocket.getLocalPort());
                Socket soc = serverSocket.accept();
                System.out.println("Connected to the patient " + soc.getRemoteSocketAddress());
                System.out.println("I accepted one client");
                System.out.println("Client accepted... ");
                InputStream flux2 = soc.getInputStream();
                BufferedReader entree = new BufferedReader(new InputStreamReader(flux2));
                PrintWriter out = new PrintWriter(soc.getOutputStream(), true);
                while (!entree.ready()) {
                    System.out.println("No message from client");
                }
                String nickname = entree.readLine();
                System.out.println(nickname);
                JOptionPane.showMessageDialog(null, nickname, "A patient has arrived !", JOptionPane.INFORMATION_MESSAGE);
                String confirm_state = entree.readLine();
                if (confirm_state == null) {
                    JOptionPane.showMessageDialog(null, "I received nothing yet!");
                }
                System.out.println(confirm_state);
                if (Boolean.parseBoolean(confirm_state)) {
                    is_confirmed_by_client = true;
                    Test_interface t = new Test_interface();
                    t.setVisible(true);
                    t.setLocationRelativeTo(null);
                    t.setResizable(false);
                    t.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//                    if (Test_interface.accept_patient_is_clicked) {
//                        out.println("You've been accepted by the doc\n");
//                        out.flush();
//                    } else if (Test_interface.refuse_patient_is_clicked) {
//                        out.println("You should go take more test in the covid testing building\n");
//                        out.flush();
//                    }
                } else {
                    is_confirmed_by_client = false;
                }
            } catch (IOException ex) {
                Logger.getLogger(Doctor_webpage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void main(String[] args) {
        int port = 2020;
        try {
            Thread t = new Server_doc(port);
            t.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
