package br.com.xampson.atividade.servidores;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SeguroServidor {

    public static void main(String[] args) throws IOException {

        System.out.println("--- Seguro de Veículos ---");

        ServerSocket serverSocket = new ServerSocket(8080);
        Socket socket = serverSocket.accept();

        DataInputStream inputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

        int ano = Integer.parseInt(inputStream.readUTF());
        double valor = Double.parseDouble(inputStream.readUTF());

        double assegura = assegura(ano, valor);

        outputStream.writeUTF(String.valueOf(assegura));
    }

    private static double assegura(int ano, double valor) {
        if(ano <= 2005) {
            return valor * 0.1;
        } else if(ano <= 2014) {
            return valor * 0.2;
        } else {
            return valor * 0.3;
        }
    }
}
