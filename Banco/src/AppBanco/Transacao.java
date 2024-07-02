package AppBanco;

import java.time.LocalDate;
import java.util.ArrayList;

public class Transacao {
    private int cpfOrigem;
    private int cpfDestino;
    private double valor;
    private LocalDate data;

    public Transacao(int cpfOrigem, int cpfDestino, double valor) {
        this.cpfOrigem = cpfOrigem;
        this.cpfDestino = cpfDestino;
        this.valor = valor;
        this.data = LocalDate.now();
    }

    public int getCpfOrigem() {
        return cpfOrigem;
    }

    public int getCpfDestino() {
        return cpfDestino;
    }

    public double getValor() {
        return valor;
    }

    public LocalDate getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Transacao{" +
                "cpfOrigem=" + cpfOrigem +
                ", cpfDestino=" + cpfDestino +
                ", valor=" + valor + "R$" +
                ", data=" + data +
                '}';
    }

    public static void realizarTransacao(ArrayList<Acount> contas, int cpfOrigem, int cpfDestino, double valor) {
        try {
            Acount contaOrigem = null;
            Acount contaDestino = null;

            // Procurar a conta de origem e a conta de destino
            for (Acount conta : contas) {
                if (conta.getCPF() == cpfOrigem) {
                    contaOrigem = conta;
                }
                if (conta.getCPF() == cpfDestino) {
                    contaDestino = conta;
                }
            }
            if (contaOrigem != null && contaDestino != null) {

                if (contaOrigem.getSaldo() >= valor) {
                    contaOrigem.setSaldo(contaOrigem.getSaldo() - valor);
                    contaDestino.setSaldo(contaDestino.getSaldo() + valor);


                    Transacao transacao = new Transacao(cpfOrigem, cpfDestino, valor);
                    contaOrigem.adicionarTransacao(transacao);
                    contaDestino.adicionarTransacao(transacao);

                    System.out.println("Transferência realizada com sucesso.");
                } else {
                    System.out.println("Saldo insuficiente na conta de origem.");
                }
            } else {
                System.out.println("ERRO DE TRANSAÇÃO: Conta de origem ou destino não encontrada.");
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro na transação: " + e.getMessage());
        }
    }
}
