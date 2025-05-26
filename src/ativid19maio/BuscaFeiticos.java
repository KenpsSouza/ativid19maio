package ativid19maio;


import java.util.Scanner;


public class BuscaFeiticos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("=== BIBLIOTECA MÁGICA DE HOGWARTS ===");
        System.out.println("Sistema de Busca de Feitiços\n");
        
        String[] feiticos = {
            "Accio", "Alohomora", "Avada Kedavra", "Crucio", "Defensio",
            "Expecto Patronum", "Expelliarmus", "Finite Incantatem", "Imperius", 
            "Lumos", "Nox", "Obliviate", "Petrificus Totalus", "Riddikulus", "Wingardium Leviosa"
        };
        
        System.out.println("Lista de feitiços disponíveis:");
        for (int i = 0; i < feiticos.length; i++) {
            System.out.println((i+1) + ". " + feiticos[i]);
        }
        
        System.out.print("\nQual feitiço você deseja encontrar? ");
        String feiticoBuscado = sc.nextLine();
        
        int posicao = buscaBinaria(feiticos, feiticoBuscado);
        
        if (posicao != -1) {
            System.out.println("\nFeitiço encontrado na posição " + posicao);
            System.out.println("O feitiço '" + feiticos[posicao] + "' está na prateleira " + (posicao + 1) + "!");
        } else {
            System.out.println("\nO feitiço '" + feiticoBuscado + "' não foi encontrado em nossa biblioteca.");
            System.out.println("Talvez você queira consultar a Seção Restrita?");
        }
        
        sc.close();
    }
    
   
    private static int buscaBinaria(String[] feiticos, String feiticoBuscado) {
        System.out.println("\nIniciando busca mágica...");
        
        int inicio = 0;                  
        int fim = feiticos.length - 1;   
        int tentativas = 0;               

        while (inicio <= fim) {
            
            tentativas++;
            
            int meio = (inicio + fim) / 2;
            
            System.out.println("Tentativa " + tentativas + ": Verificando posição " + meio + 
                              " (" + feiticos[meio] + ")");
            
            int resultadoComparacao = feiticoBuscado.compareToIgnoreCase(feiticos[meio]);
            
            if (resultadoComparacao == 0) {
                System.out.println("Feitiço encontrado após " + tentativas + " tentativas!");
                return meio;
            }
            
            if (resultadoComparacao < 0) {
                System.out.println("O feitiço deve estar antes. Buscando na primeira metade...");
                fim = meio - 1;
            } 

            else {
                System.out.println("O feitiço deve estar depois. Buscando na segunda metade...");
                inicio = meio + 1;
            }
        }
        
        System.out.println("Busca concluída após " + tentativas + " tentativas. Feitiço não encontrado.");
        return -1;
    }
}