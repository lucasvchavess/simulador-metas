import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int menu;
        int meses;
        double deposito; 
        double saldo;
        double totInvest;
        double rendimento;
        //double taxaA;
        //double taxaB;
        double meta;
        double valorMes;
        //double difSaldo;
        double taxaMes;

        Scanner sc = new Scanner(System.in);

        

        do{ 
            System.out.println("=== SIMULADOR DE METAS ===");
            System.out.println("1 - Quanto vou ter?");
            System.out.println("2 - Quanto preciso guardar por mês?");
            System.out.println("3 - Comparar dois rendimentos");
            System.out.println("0 - Sair");
            System.out.printf("Escolha: ");

            menu = sc.nextInt();

            if (menu > 3 || menu < 0) {
                System.out.println("Opção inválida");
            }


        switch (menu) {
            case 1: 

                do{
                    System.out.println("Quanto você guarda por mês?");
                    deposito = sc.nextDouble();

                    if (deposito <= 0) {
                        System.out.println("O depósito precisa ser maior que 0");
                    }

                } while (deposito <= 0);

                do{ 
                    System.out.println("Rendimento ao mês (%): ");
                    taxaMes = sc.nextDouble() / 100.0;

                    if (taxaMes < 0){
                        System.out.println("A taxa dever ser igual ou maior que 0");
                    }
                } while (taxaMes < 0); 
                

                do{
                    System.out.println("Por quantos meses? ");
                    meses = sc.nextInt();

                    if (meses <= 0) {
                        System.out.println("O mês não pode ser menor que 1");
                    }

                } while (meses <= 0);

                if (taxaMes == 0) {
                    saldo = deposito * meses;
                } else {
                    saldo = deposito * ((Math.pow(1 + taxaMes, meses) - 1) / taxaMes);
                }

                totInvest = deposito * meses;
                rendimento = saldo - totInvest;

                System.out.printf("\nEm %d meses você terá R$ %.2f\n", meses, saldo);
                System.out.printf("Você investiu R$ %.2f e o rendimento foi de R$ %.2f\n", totInvest, rendimento);
                break;
            
            case 2: 

                do{
                    System.out.println("Qual é a sua meta?");
                    meta = sc.nextDouble();

                    if (meta >= 1){
                        System.out.println("O valor da meta deve ser maior que 0.");
                    }
                } while (meta >= 1);

                do{ 
                    System.out.println("Rendimento ao mês (%): ");
                    taxaMes = sc.nextDouble() / 100.0;

                    if (taxaMes < 0){
                        System.out.println("A taxa dever ser igual ou maior que 0");
                    }
                } while (taxaMes < 0); 

                do{
                    System.out.println("Por quantos meses? ");
                    meses = sc.nextInt();

                    if (meses <= 0) {
                        System.out.println("O mês não pode ser menor que 1");
                    }

                } while (meses <= 0);

                if (taxaMes == 0){
                    valorMes = meta / meses;
                } else{
                    valorMes = meta / ((Math.pow(1 + taxaMes, meses) - 1) / taxaMes);
                }

                System.out.printf("\nPara ter R$ %.2f em %d meses guarde R$ %.2f por mês\n", meta, meses, valorMes);
                
                break;

            case 0: 
                System.out.println("Programa finalizado!");
                
                break;
        
            default:
                break;
        }

        } while (menu > 0 || menu < 0);

        
    }
}