public class Banco {
    private ContaTerminal[] contas;
    private int numContas;

    public Banco() {
        contas = new ContaTerminal[100];
        numContas = 0;
    }

    public void addConta(ContaTerminal conta) {
        contas[numContas] = conta;
        numContas++;
    }

    public ContaTerminal getConta(int numConta) {
        for (int i = 0; i < numContas; i++) {
            if (contas[i].getNumero() == numConta) {
                return contas[i];
            }
        }
        return null;
    }

}
