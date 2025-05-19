package ativid19maio;

import java.util.Scanner;
import java.util.Random;

public class JogoPePaTeLaSp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        // Array com as opções de jogada
        String[] opcoes = {"Pedra", "Papel", "Tesoura", "Lagarto", "Spock"};
        
        System.out.println("===== JOGO DE PEDRA, PAPEL, TESOURA, LAGARTO E SPOCK =====");
        System.out.println("Regras:");
        System.out.println("- Tesoura corta Papel");
        System.out.println("- Papel cobre Pedra");
        System.out.println("- Pedra esmaga Lagarto");
        System.out.println("- Lagarto envenena Spock");
        System.out.println("- Spock quebra Tesoura");
        System.out.println("- Tesoura decapita Lagarto");
        System.out.println("- Lagarto come Papel");
        System.out.println("- Papel refuta Spock");
        System.out.println("- Spock vaporiza Pedra");
        System.out.println("- Pedra amassa Tesoura");
        
        boolean jogarNovamente = true;
        
        while (jogarNovamente) {
            System.out.println("\nEscolha sua jogada:");
            System.out.println("1 - Pedra");
            System.out.println("2 - Papel");
            System.out.println("3 - Tesoura");
            System.out.println("4 - Lagarto");
            System.out.println("5 - Spock");
            System.out.print("Digite o número da sua escolha: ");
            
            int escolhaUsuario = scanner.nextInt() - 1; // Subtrai 1 para corresponder ao índice do array
            
            // Validação da entrada
            if (escolhaUsuario < 0 || escolhaUsuario >= opcoes.length) {
                System.out.println("Opção inválida! Por favor, escolha um número entre 1 e 5.");
                continue;
            }
            
            // Escolha aleatória do computador
            int escolhaComputador = random.nextInt(opcoes.length);
            
            System.out.println("\nVocê escolheu: " + opcoes[escolhaUsuario]);
            System.out.println("O computador escolheu: " + opcoes[escolhaComputador]);
            
            // Determinar o vencedor
            String resultado = determinarVencedor(escolhaUsuario, escolhaComputador);
            System.out.println("\n" + resultado);
            
            // Perguntar se deseja jogar novamente
            System.out.print("\nDeseja jogar novamente? (S/N): ");
            String resposta = scanner.next();
            jogarNovamente = resposta.equalsIgnoreCase("S");
        }
        
        System.out.println("Obrigado por jogar!");
        scanner.close();
    }
    
    public static String determinarVencedor(int escolhaUsuario, int escolhaComputador) {
        // 0=Pedra, 1=Papel, 2=Tesoura, 3=Lagarto, 4=Spock
        
        // Se as escolhas forem iguais, é empate
        if (escolhaUsuario == escolhaComputador) {
            return "Empate!";
        }
        
        // Lógica para determinar o vencedor
        boolean usuarioVence = false;
        String explicacao = "";
        
        switch (escolhaUsuario) {
            case 0: // Pedra
                if (escolhaComputador == 2) { // Tesoura
                    usuarioVence = true;
                    explicacao = "Pedra amassa Tesoura!";
                } else if (escolhaComputador == 3) { // Lagarto
                    usuarioVence = true;
                    explicacao = "Pedra esmaga Lagarto!";
                } else if (escolhaComputador == 1) { // Papel
                    explicacao = "Papel cobre Pedra!";
                } else { // Spock
                    explicacao = "Spock vaporiza Pedra!";
                }
                break;
                
            case 1: // Papel
                if (escolhaComputador == 0) { // Pedra
                    usuarioVence = true;
                    explicacao = "Papel cobre Pedra!";
                } else if (escolhaComputador == 4) { // Spock
                    usuarioVence = true;
                    explicacao = "Papel refuta Spock!";
                } else if (escolhaComputador == 2) { // Tesoura
                    explicacao = "Tesoura corta Papel!";
                } else { // Lagarto
                    explicacao = "Lagarto come Papel!";
                }
                break;
                
            case 2: // Tesoura
                if (escolhaComputador == 1) { // Papel
                    usuarioVence = true;
                    explicacao = "Tesoura corta Papel!";
                } else if (escolhaComputador == 3) { // Lagarto
                    usuarioVence = true;
                    explicacao = "Tesoura decapita Lagarto!";
                } else if (escolhaComputador == 0) { // Pedra
                    explicacao = "Pedra amassa Tesoura!";
                } else { // Spock
                    explicacao = "Spock quebra Tesoura!";
                }
                break;
                
            case 3: // Lagarto
                if (escolhaComputador == 1) { // Papel
                    usuarioVence = true;
                    explicacao = "Lagarto come Papel!";
                } else if (escolhaComputador == 4) { // Spock
                    usuarioVence = true;
                    explicacao = "Lagarto envenena Spock!";
                } else if (escolhaComputador == 0) { // Pedra
                    explicacao = "Pedra esmaga Lagarto!";
                } else { // Tesoura
                    explicacao = "Tesoura decapita Lagarto!";
                }
                break;
                
            case 4: // Spock
                if (escolhaComputador == 0) { // Pedra
                    usuarioVence = true;
                    explicacao = "Spock vaporiza Pedra!";
                } else if (escolhaComputador == 2) { // Tesoura
                    usuarioVence = true;
                    explicacao = "Spock quebra Tesoura!";
                } else if (escolhaComputador == 1) { // Papel
                    explicacao = "Papel refuta Spock!";
                } else { // Lagarto
                    explicacao = "Lagarto envenena Spock!";
                }
                break;
        }
        
        if (usuarioVence) {
            return "Você venceu! " + explicacao;
        } else {
            return "Computador venceu! " + explicacao;
        }
    }
}