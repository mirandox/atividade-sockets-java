package br.com.xampson.atividade.servidores;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class FinanciamentoServidor {

    public static void main(String[] args) throws IOException {

        System.out.println("--- Financiamento de Veículos ---");

        ServerSocket serverSocket = new ServerSocket(8000);
        Socket socket = serverSocket.accept();

        DataInputStream inputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

        double preco = Double.parseDouble(inputStream.readUTF());
        double entrada = Double.parseDouble(inputStream.readUTF());
        int meses = Integer.parseInt(inputStream.readUTF());

        double financia = financia(preco, entrada, meses);

        outputStream.writeUTF(String.valueOf(financia));
    }

    private static double financia(double preco, double entrada, int meses) {
        if(entrada >= (preco * 0.5)) {
            double valorFinanciado = preco - entrada;
            valorFinanciado = valorFinanciado * 1.2;
            double parcelas = valorFinanciado / meses;
            System.out.println("Valor das parcelas: " + parcelas);
            return parcelas;
        } else {
            double valorFinanciado = preco - entrada;
            valorFinanciado = valorFinanciado * 1.5;
            double parcelas = valorFinanciado / meses;
            System.out.println("Valor das parcelas: " + parcelas);
            return parcelas;
        }
    }
}
