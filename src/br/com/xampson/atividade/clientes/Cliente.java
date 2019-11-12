package br.com.xampson.atividade.clientes;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) throws IOException {

        System.out.println("--- Cliente ---");

        System.out.println("Escolha 1 para Financiamento ou 2 para Seguro:");
        Scanner scanner = new Scanner(System.in);
        int valor = scanner.nextInt();

        switch(valor) {
            case 1:
                // Financiamento de Veículos
                Socket soc = new Socket("localhost", 8000);
                DataInputStream recebe = new DataInputStream(soc.getInputStream());
                DataOutputStream envia = new DataOutputStream(soc.getOutputStream());

                while (true) {
                    System.out.println("Qual o valor do veículo?");
                    envia.writeUTF(new Scanner(System.in).nextLine());

                    System.out.println("Qual o valor de entrada?");
                    envia.writeUTF(new Scanner(System.in).nextLine());

                    System.out.println("Quantas parcelas (em meses)?");
                    envia.writeUTF(new Scanner(System.in).nextLine());
                    break;
                }
                System.out.println("Valor das parcelas: " + recebe.readUTF());
                break;

            case 2:
                // Seguro de Veículos
                Socket socket = new Socket("localhost", 8080);
                DataInputStream recebe2 = new DataInputStream(socket.getInputStream());
                DataOutputStream envia2 = new DataOutputStream(socket.getOutputStream());

                while (true) {
                    System.out.println("Qual o ano do veículo?");
                    envia2.writeUTF(new Scanner(System.in).nextLine());

                    System.out.println("Qual o valor do veículo?");
                    envia2.writeUTF(new Scanner(System.in).nextLine());
                    break;
                }
                System.out.println("Valor do seguro: " + recebe2.readUTF());
                break;
        }
    }
}
