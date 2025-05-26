package ativid19maio;


import java.util.Scanner;
import java.util.Random;


public class CalculadoraComErro {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        
        System.out.println("=== CALCULADORA COM ERRO DE PRECISÃO ===");
        System.out.println("Esta calculadora tem um erro de até 1% nos resultados.\n");
        
        boolean continuar = true;
        
        while (continuar) {
            System.out.print("Digite o primeiro número: ");
            double numero1 = sc.nextDouble();
            
            System.out.print("Digite a operação (+, -, *, /): ");
            sc.nextLine(); 
            String operacao = sc.nextLine();
            
            System.out.print("Digite o segundo número: ");
            double numero2 = sc.nextDouble();
            
            double resultadoCorreto = calcular(numero1, numero2, operacao);
            
            if (!Double.isNaN(resultadoCorreto)) {
                double erro = calcularErro(resultadoCorreto, random);
                double resultadoComErro = resultadoCorreto + erro;
                
                System.out.println("\nResultado matematicamente correto: " + resultadoCorreto);
                System.out.println("Resultado desta calculadora: " + resultadoComErro);
                System.out.println("Erro adicionado: " + erro + " (" + 
                                  String.format("%.4f", (erro/resultadoCorreto)*100) + "%)");
            }
            
            System.out.print("\nDeseja fazer outro cálculo? (S/N): ");
            sc.nextLine(); 
            String resposta = sc.nextLine().toUpperCase();
            continuar = resposta.equals("S") || resposta.equals("SIM");
            
            System.out.println(); 
        }
        
        System.out.println("Obrigado por usar a Calculadora com Erro!");
        sc.close();
    }
    
    
    private static double calcular(double num1, double num2, String operacao) {
        switch (operacao) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num2 == 0) {
                    System.out.println("Erro: Divisão por zero não é permitida!");
                    return Double.NaN; 
                }
                return num1 / num2;
            default:
                System.out.println("Operação não reconhecida. Use +, -, * ou /");
                return Double.NaN;
        }
    }
    
   
    private static double calcularErro(double resultado, Random random) {
        double valorAbsoluto = Math.abs(resultado);
        
        double erroMaximo = valorAbsoluto * 0.01;
        
        double percentualAleatorio = random.nextDouble(); 
        double erroAleatorio = erroMaximo * percentualAleatorio;
        
        if (random.nextBoolean()) {
            return erroAleatorio;
        } else {
            return -erroAleatorio;
        }
    }
}