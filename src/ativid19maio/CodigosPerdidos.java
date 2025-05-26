package ativid19maio;

import java.util.Scanner;

public class CodigosPerdidos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("=== A ILHA DOS CÓDIGOS PERDIDOS ===");
        System.out.println("Este programa decodifica mensagens misteriosas!");
        System.out.println("Cada código deve ser um número seguido de uma letra (exemplo: 4H)");

        System.out.print("\nQuantos códigos você vai inserir? ");
        int quantidadeCodigos = sc.nextInt();
        sc.nextLine(); 
        
        String[] codigos = new String[quantidadeCodigos];
        
        System.out.println("\nDigite os códigos, um por um:");
        for (int i = 0; i < quantidadeCodigos; i++) {
            System.out.print("Código " + (i + 1) + ": ");
            codigos[i] = sc.nextLine();
        }
        
        String mensagemDecodificada = decodificarCodigos(codigos);
        
        System.out.println("\n=== MENSAGEM DECODIFICADA ===");
        System.out.println(mensagemDecodificada);
        
        sc.close();
    }
    
    
    private static String decodificarCodigos(String[] codigos) {
        StringBuilder mensagem = new StringBuilder();
        
        for (String codigo : codigos) {
            if (codigo.length() >= 2) {
                try {
                   
                    String numeroStr = codigo.substring(0, codigo.length() - 1);
                    char letra = codigo.charAt(codigo.length() - 1);
                    
                    
                    int repeticoes = Integer.parseInt(numeroStr);
                    
                   
                    for (int i = 0; i < repeticoes; i++) {
                        mensagem.append(letra);
                    }
                } catch (NumberFormatException e) {
                   
                    System.out.println("Código inválido: " + codigo);
                }
            } else {
                System.out.println("Código muito curto: " + codigo);
            }
        }
        
        return mensagem.toString();
    }
}
