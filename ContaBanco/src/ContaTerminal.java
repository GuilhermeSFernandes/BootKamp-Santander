public class ContaTerminal {
    private int numero;
    private double saldo;
    private String nomeCliente;
    private String agencia;
    public ContaTerminal(int numero, String nomeCliente, String agencia){
        this.numero = numero;
        this.nomeCliente = nomeCliente;
        this.agencia = agencia;
        this.saldo = 0.0;
    }
    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }
    public void depositar(double n){
        this.saldo += n;
        System.out.println("Valor " +  n + " depositado com sucesso!\n");
    }
    public void sacar(double n){
        if (n > saldo){
            System.out.println("Saldo indisponivel\n");
        }else{
            saldo -= n;
            System.out.println("Valor " + n + " sacado com sucesso!\n");
        }
    }
    public void cadastrar(int numero, String nomeCliente, String agencia){
        this.numero = numero;
        this.nomeCliente = nomeCliente;
        this.agencia = agencia;
    }
    public void imprimirDadosConta() {
        System.out.println("Número da conta: " + this.numero);
        System.out.println("Nome do cliente: " + this.nomeCliente);
        System.out.println("Agência: " + this.agencia);
        System.out.println("Saldo disponível: " + this.saldo);
    }

}
