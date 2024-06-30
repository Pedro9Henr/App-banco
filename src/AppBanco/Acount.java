package AppBanco;

import java.util.ArrayList;

public class Acount {
    private String nome;
    private int cpf;
    private int senha;
    private int idade;
    private double saldo;
    private ArrayList<Transacao> historicoTransacoes;

    // Construtores e outros métodos



    public Acount(String nome, int cpf, int senha, int idade) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.idade = idade;
        this.saldo = 0;
        this.historicoTransacoes = new ArrayList<>();
    }

    // Getters e setters

    public int getCPF() {
        return cpf;
    }

    public int getSenha() {
        return senha;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public ArrayList<Transacao> getHistoricoTransacoes() {
        return historicoTransacoes;
    }

    public void adicionarTransacao(Transacao transacao) {
        this.historicoTransacoes.add(transacao);
    }

    public void exibirHistorico() {
        if (historicoTransacoes.isEmpty()) {
            System.out.println("Nenhuma transação encontrada.");
        } else {
            for (Transacao transacao : historicoTransacoes) {
                System.out.println(transacao);
            }
        }
    }
}
