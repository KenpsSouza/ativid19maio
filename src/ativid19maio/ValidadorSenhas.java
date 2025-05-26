package ativid19maio;


import java.util.Scanner;


public class ValidadorSenhas {
    public static void main(String[] args) {

    	Scanner sc = new Scanner(System.in);
        System.out.println("Olá, vamos verificar a senha!");
        System.out.println("=== VALIDADOR DE SENHAS INCOMUNS ===");
        System.out.println("\nRegras para senha válida:");
        System.out.println("1. Pelo menos uma letra maiúscula");
        System.out.println("2. Pelo menos um número primo (2, 3, 5, 7, etc.)");
        System.out.println("3. Pelo menos um caractere especial (!, @, #, $, %, etc.)");
        System.out.println("4. Não pode conter vogais duplicadas seguidas (aa, ee, ii, oo, uu)");
        
        boolean continua = true;
        
        while (continua) {
            System.out.print("\nDigite uma senha para validar: ");
            String senha = sc.nextLine();
            
            boolean temLetraMaiuscula = verificarLetraMaiuscula(senha);
            boolean temNumeroPrimo = verificarNumeroPrimo(senha);
            boolean temCaractereEspecial = verificarCaractereEspecial(senha);
            boolean naoTemVogaisDuplicadas = verificarVogaisDuplicadas(senha);
            
            System.out.println("\nResultado da validação:");
            System.out.println("- Letra maiúscula: " + (temLetraMaiuscula ? "SIM" : "NÃO"));
            System.out.println("- Número primo: " + (temNumeroPrimo ? "SIM" : "NÃO"));
            System.out.println("- Caractere especial: " + (temCaractereEspecial ? "SIM" : "NÃO"));
            System.out.println("- Sem vogais duplicadas: " + (naoTemVogaisDuplicadas ? "SIM" : "NÃO"));
            
            if (temLetraMaiuscula && temNumeroPrimo && temCaractereEspecial && naoTemVogaisDuplicadas) {
                System.out.println("\nV Senha VÁLIDA! Atende a todos os requisitos.");
            } else {
                System.out.println("\nX Senha INVÁLIDA! Não atende a todos os requisitos.");
            }
            
         
            System.out.print("\nDeseja verificar outra senha? (S/N): ");
            String resposta = sc.nextLine().toUpperCase();
            continua = resposta.equals("S") || resposta.equals("SIM");
        }
        
        System.out.println("\nObrigado por usar o validador de senhas!");
        sc.close();
    }
    
   
     //Verifica se a senha contém pelo menos uma letra maiúscula
     
    private static boolean verificarLetraMaiuscula(String senha) {
        // Percorre cada caractere verificando se algum é maiúsculo
        for (char c : senha.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return true;
            }
        }
        return false;
    }
    
     //Verifica se a senha contém pelo menos um número primo
     
    private static boolean verificarNumeroPrimo(String senha) {
        // Percorre cada caractere verificando se é um dígito e se é primo
        for (char c : senha.toCharArray()) {
            if (Character.isDigit(c)) {
                int numero = Character.getNumericValue(c);
                if (ehPrimo(numero)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    
     //Verifica se um número é primo
    
    private static boolean ehPrimo(int numero) {
        // 0 e 1 não são primos
        if (numero <= 1) {
            return false;
        }
        
        // 2 e 3 são primos
        if (numero <= 3) {
            return true;
        }
        
        // Verificar divisibilidade por números até a raiz quadrada
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        
        return true;
    }
    
    
     //Verifica se a senha contém pelo menos um caractere especial
     
    private static boolean verificarCaractereEspecial(String senha) {
        // Caracteres especiais comuns
        String caracteresEspeciais = "!@#$%^&*()_+-=[]{}|;:'\",.<>/?`~";
        
        // Percorre cada caractere verificando se é um caractere especial
        for (char c : senha.toCharArray()) {
            if (caracteresEspeciais.indexOf(c) != -1) {
                return true;
            }
        }
        return false;
    }
    
    
     //Verifica se a senha NÃO contém vogais duplicadas seguidas
     
    private static boolean verificarVogaisDuplicadas(String senha) {
        // Converte para minúsculo para simplificar a verificação
        senha = senha.toLowerCase();
        
        // Verifica se existe alguma sequência de vogais duplicadas
        if (senha.contains("aa") || senha.contains("ee") || 
            senha.contains("ii") || senha.contains("oo") || 
            senha.contains("uu")) {
            return false;
        }
        
        return true;
    }
}


