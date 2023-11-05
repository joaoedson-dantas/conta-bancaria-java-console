import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       cadastro();
    }

    public static void cadastro() {
        Scanner leitura = new Scanner(System.in);

        System.out.println("Digite seu nome: ");
        String nome = leitura.nextLine();

        System.out.println("Qual tipo de conta você deseja abrir? ");
        System.out.println(" 1 - Abrir conta Poupança ");
        System.out.println(" 2 - Abrir conta corrente ");
        System.out.println(" 3 - Sair, não quero criar conta ");
        int tipoContaOpcao = leitura.nextInt();
        String tipoConta = "";

        switch (tipoContaOpcao) {
            case 1: tipoConta = "Poupança"; break;
            case 2: tipoConta = "Corrente"; break;
            case 3: System.exit(0); break;
            default:
                System.out.println("O numero digito é inválido, escolha uma das opções acima: "); break;
        }

        System.out.println("Qual o depósito inicial? ");
        double saldo = leitura.nextDouble();

        dadosCliente(nome, tipoConta, saldo);
        operacoes(nome, tipoConta, saldo);
    }

    public static void dadosCliente(String nome, String tipoConta, double saldo) {
        System.out.println("**********************************");
        System.out.println("\nDados iniciais do cliente: ");
        System.out.println("\nNome:                 " + nome);
        System.out.println("Tipo de conta:        " + tipoConta);
        System.out.println("Saldo inicial:        " + saldo);
        System.out.println("\n**********************************");
        operacoes(nome, tipoConta, saldo);
    }

    public static void operacoes(String nome, String tipoConta, double saldo) {
        Scanner leitura = new Scanner(System.in);
        System.out.println(" ");
        System.out.println("Operações: ");

        System.out.println(" 1 - Consultar o saldo ");
        System.out.println(" 2 - Receber valor ");
        System.out.println(" 3 - Transferir valor  ");
        System.out.println(" 4 - Dados do cliente ");
        System.out.println(" 5 - Sair ");

        System.out.println(" ");
        System.out.println("Digite a opção desejada: ");
        int opcao = leitura.nextInt();

        if (opcao == 1) {

            System.out.println("O saldo atual da sua conta é de: " + saldo);
            operacoes(nome, tipoConta, saldo);

        } else if (opcao == 2) {

            System.out.println("Informe o valor a receber: ");
            double valorRecebido = leitura.nextInt();
            saldo += valorRecebido;
            System.out.println("O saldo atualizado é de R$" + saldo);
            operacoes(nome, tipoConta, saldo);

        } else if (opcao == 3) {

            System.out.println("Informe o valor que deseja transferir: ");
            double valorTrasferir = leitura.nextDouble();
            if (valorTrasferir > saldo) {
                System.out.println("Não foi possível fazer a transferência, SALDO INSUFICIENTE ");
                operacoes(nome, tipoConta, saldo);
            }
            saldo -= valorTrasferir;
            System.out.println("Valor de " + valorTrasferir + " transferido com SUCESSO!");
            operacoes(nome, tipoConta, saldo);

        } else if (opcao == 4) {
            dadosCliente(nome, tipoConta, saldo);
        } else if (opcao == 5) {
            System.out.println("Obrigado por utilizado nosso banco, tenha um exelente dia! ");
            System.exit(0);
        } else {
            System.out.println("O valor digitado é incorreto, digite um valor válido: ");
            operacoes(nome, tipoConta, saldo);
        }



    }

}
