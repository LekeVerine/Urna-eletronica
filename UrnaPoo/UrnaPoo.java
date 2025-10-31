package UrnaPoo;

import java.util.Scanner;

public class UrnaPoo {
    public static void main(String[] args) {

        Scanner obj = new Scanner(System.in);
        Poo votos = new Poo();

        int continuar;

        int[] vetorSenador = new int[13];      
        int[] vetorPresidente = new int[11]; 

        String[] nomeSenadores = {
            "Agenor (MDB)", 
            "Fabricio Rosa (PSOL)", 
            "Jorge Kagura (PRP)", 
            "Tácia Vánta (PSB)", 
            "Tua Cesar Bueno (PT)", 
            "Marconi Perillo (PSDB)",
            "Professor Alessandro Aquino (PCO)", 
            "Professora Geli (PT)", 
            "Professora Magda Borges (PCB)",
            "Santana Pires (Patriota)", 
            "Vanderian (PP)", 
            "Wilder Morais (DEM)", 
            "VOTO BRANCO"
        };

        String[] nomePresidentes = {
            "BOLSONARO - 17", 
            "HADDAD - 13", 
            "CIRO - 12", 
            "BOULOS - 50",
            "CABO DACIOLO - 51", 
            "MARINA SILVA - 18", 
            "GERALDO ALCKMIN - 45",
            "ÁLVARO DIAS - 19", 
            "HENRIQUE MEIRELLES - 15", 
            "JOAO AMOEDO - 30", 
            "VOTO BRANCO"
        };

        do {
            System.out.println("\n\t*************** URNA ELETRÔNICA ***************");
            System.out.println("\tVOTE EM 2 SENADORES (Não pode votar 2x no mesmo senador)\n");

            
            for (int i = 0; i < nomeSenadores.length; i++) {
                System.out.println((i+1) + " - " + nomeSenadores[i]);
            }


            System.out.print("\nVote no primeiro senador: ");
            votos.votoSenador1 = obj.nextInt();

            if(votos.votoSenador1 <= 0 || votos.votoSenador1 > 13) {
                System.out.println("Voto NULO!");
                votos.votarNulo();
            } else if(votos.votoSenador1 == 13) {
                votos.votarBranco();
            } else {
                votos.votarValido();
            }


            System.out.print("Vote no segundo senador: ");
            votos.votoSenador2 = obj.nextInt();

            if(votos.votoSenador2 <= 0 || votos.votoSenador2 > 13) {
                System.out.println("Voto NULO!");
                votos.votarNulo();
            }else if(votos.votoSenador2 == votos.votoSenador1 && votos.votoSenador1 != 13) {
                System.out.println("**** Não pode votar no mesmo senador, voto anulado! ****");
                votos.votarNulo();
                votos.votoSenador2 = 0; 
            }else if(votos.votoSenador2 == 13) {
                votos.votarBranco();
            }else {
                votos.votarValido();
            }

            for(int i = 0; i < 13; i++) {
                if(votos.votoSenador1 == i+1) vetorSenador[i]++;
                if(votos.votoSenador2 == i+1) vetorSenador[i]++;
            }

            System.out.println("\n\tVote para PRESIDENTE\n");
            for(int i = 0; i < nomePresidentes.length; i++) {
                System.out.println((i+1) + " - " + nomePresidentes[i]);
            }

            System.out.print("Voto: ");
            votos.votoPresidente = obj.nextInt();

            if(votos.votoPresidente <= 0 || votos.votoPresidente > 11) {
                System.out.println("Voto NULO!");
                votos.votarNulo();
            } else if(votos.votoPresidente == 11) {
                votos.votarBranco();
            } else {
                votos.votarValido();
            }


            for(int i = 0; i < nomePresidentes.length; i++) {
                if(votos.votoPresidente == i+1) vetorPresidente[i]++;
            }

            System.out.println("\nDeseja continuar votando? (1 - Sim / 2 - Não)");
            continuar = obj.nextInt();

        } while(continuar == 1);


        votos.calcularPorcentagens();


        System.out.println("\n\nRESULTADO PARA SENADORES");
        for(int i = 0; i < nomeSenadores.length - 1; i++) {
            System.out.println((i+1) + " - " + nomeSenadores[i] + " = " + vetorSenador[i] + " votos");
        }

        System.out.println("\nRESULTADO PARA PRESIDENTES");
        for(int i = 0; i < nomePresidentes.length - 1; i++) {
            System.out.println((i+1) + " - " + nomePresidentes[i] + " = " + vetorPresidente[i] + " votos");
        }

        System.out.println("\nVotos NULOS: " + votos.votosNulos);
        System.out.println("Votos BRANCOS: " + votos.votosBrancos);
        System.out.printf("Porcentagem de votos NULOS: %.2f%%\n", votos.porcentagemNulos);
        System.out.printf("Porcentagem de votos BRANCOS: %.2f%%\n", votos.porcentagemBrancos);
    }
}
