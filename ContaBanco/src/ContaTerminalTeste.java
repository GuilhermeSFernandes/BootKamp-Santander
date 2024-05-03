import java.util.Scanner;

public class ContaTerminalTeste {

    public static void main(String[] args) {
        Banco banco = new Banco();
        Scanner scanner = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("Escolha uma das Opcoes\n");
            System.out.println("1 - para cadastrar conta\n");
            System.out.println("2 - para depositar\n");
            System.out.println("3 - para sacar\n");
            System.out.println("4 - para imprimir dados da conta\n");
            System.out.println("0 - para sair\n");
            opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    cadastrarCliente(scanner, banco);
                    break;
                case 2:
                    depositar(scanner, banco);
                    break;
                case 3:
                    sacar(scanner, banco);
                    break;
                case 4:
                    System.out.println("Informe o numero da conta \n");
                    int numConta = scanner.nextInt();
                    imprimirConta(banco, numConta);
                    break;
                case 0:
                    break;
            }
        } while (opcao != 0);
        scanner.close();
    }
    public static void cadastrarCliente (Scanner scanner, Banco banco){
        System.out.println("Informe seu nome: \n");
        scanner.nextLine();
        String nomeClient = scanner.nextLine();
        System.out.println("Informe numero da conta: \n");
        int num = scanner.nextInt();
        System.out.println("Informe numero da Agencia: \n");
        scanner.nextLine();
        String agencia = scanner.nextLine();
        ContaTerminal c = new ContaTerminal(num, nomeClient, agencia);
        System.out.println("Ola " + nomeClient +
                ", obrigado por criar uma conta em nosso banco, sua agência é "
                + agencia + ", conta" + num + " e seu saldo " + c.getSaldo() + " ja esta disponivel para saque.\n");
        banco.addConta(c);
    }
    public static void depositar(Scanner scanner, Banco banco){
        System.out.println("Informe numero da conta para depositar: \n");
        int numContaDeposito = scanner.nextInt();
        ContaTerminal contaDeposito = banco.getConta(numContaDeposito);
        if(contaDeposito != null){
            System.out.println("Informe valor para deposito : \n");
            double deposito = scanner.nextDouble();
            contaDeposito.depositar(deposito);
        }else System.out.println("Conta nao encontrada\n");
    }
    public static void sacar(Scanner scanner, Banco banco){
        System.out.println("Informe o numero da conta para sacar: \n");
        int numContaSaque = scanner.nextInt();
        ContaTerminal contaSaque = banco.getConta(numContaSaque);
        if(contaSaque != null) {
            System.out.println("Valor disponivel: " + contaSaque.getSaldo());
            System.out.println("Informe valor para sarcar: \n");
            double valorSaque = scanner.nextDouble();
            if (valorSaque <= contaSaque.getSaldo()) {
                    contaSaque.sacar(valorSaque);
                    System.out.println("Saque efetuado com sucesso!\n");
            }else System.out.println("Saldo insuficiente");
        }else System.out.println("Conta nao encontrada!");
    }
    public static void imprimirConta(Banco banco, int numeroConta) {
        ContaTerminal conta = banco.getConta(numeroConta);
        if (conta != null) {
            System.out.println("Dados da Conta:");
            System.out.println("Número da conta: " + conta.getNumero());
            System.out.println("Nome do cliente: " + conta.getNomeCliente());
            System.out.println("Agência: " + conta.getAgencia());
            System.out.println("Saldo disponível: " + conta.getSaldo());
        } else {
            System.out.println("Conta não encontrada!");
        }
    }


}
