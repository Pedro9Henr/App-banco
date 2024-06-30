package AppBanco;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    private ArrayList<Acount> contas;
    private Scanner entrada;

    public static void main(String args[]) {
        Menu menu = new Menu();
        menu.iniciarMenu();
    }

    public Menu() {
        entrada = new Scanner(System.in);
        contas = new ArrayList<Acount>();
        Acount teste1 = new Acount("pedro",9090, 123,20); // Conta de teste
        contas.add(teste1);
        teste1.setSaldo(10000);
        Acount teste2 = new Acount("teste",1234, 123,19); // Conta de teste
        contas.add(teste2);
        teste2.setSaldo(100);
    }

    public void iniciarMenu() {
        while (true) {
            System.out.println("Menu: ");
            System.out.println("1- Login");
            System.out.println("2- Cadastrar nova Conta");
            System.out.println("3 - Encerrar programa");
            int opcao = entrada.nextInt();
            entrada.nextLine();

            switch (opcao) {
                case 1:
                    login();
                    break;
                case 2:
                    cadastrar();
                    break;
                case 3:
                    System.out.println("Programa encerrado!!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }

    private void login() {
        System.out.println("Login");
        System.out.print("CPF: ");
        int cpf = entrada.nextInt();
        System.out.print("Senha: ");
        int senha = entrada.nextInt();

        boolean verificar = false;

        for (Acount conta : contas) {
            if (conta.getCPF() == cpf && conta.getSenha() == senha) {
                verificar = true;

                System.out.println("Login sucedido com sucesso");
                System.out.println();
                boolean voltar = false;
                while (!voltar) {
                    System.out.println("1 - Consultar saldo");
                    System.out.println("2 - Informações pessoais");
                    System.out.println("3-  Realizar transação");
                    System.out.println("4 - Histórico de transações ");
                    System.out.println("5 - Voltar ao Menu");
                    int opcao = entrada.nextInt();

                    switch (opcao) {
                        case 1:
                            System.out.println("Saldo disponível : " + conta.getSaldo() + "R$");
                            aguardarEnter();
                            break;
                        case 2:
                            System.out.println("Nome: " + conta.getNome());
                            System.out.println("CPF: " + conta.getCPF());
                            System.out.println("Idade: " + conta.getIdade());
                            aguardarEnter();
                            break;
                        case 3:
                            System.out.println("Digite o número da conta destino: ");
                            int numeroContaDestino = entrada.nextInt();
                            System.out.println("Digite o valor da transferência: ");
                            int valor = entrada.nextInt();

                            Transacao.realizarTransacao(contas, conta.getCPF(), numeroContaDestino, valor);
                            aguardarEnter();
                            break;
                        case 4 :
                            conta.exibirHistorico();
                            aguardarEnter();
                            break;
                            case 5:
                            voltar = true;
                            break;
                        default:
                            System.out.println("Opção inválida. Tente novamente.");
                            break;
                    }
                }
            }
        }

        if (!verificar) {
            System.out.println("Usuário não encontrado");
        }
    }

    private void cadastrar() {
        System.out.println("Cadastro");
        System.out.println("Informe os dados abaixo:");

        System.out.print("Nome: ");
        String nome = entrada.nextLine();

        System.out.print("CPF(4 digitos): ");
        int cpf = entrada.nextInt();
        System.out.print("Senha (de apenas 3 dígitos): ");
        int senha = entrada.nextInt();
        System.out.print("Idade: ");
        int idade = entrada.nextInt();

        Acount novaConta = new Acount(nome, cpf, senha, idade);
        contas.add(novaConta);

        System.out.println("Conta cadastrada com sucesso!");
    }



    private void aguardarEnter() {
        System.out.println("Pressione Enter para continuar...");
        try {
            System.in.read();
        } catch (Exception e) {
        }
    }
}
