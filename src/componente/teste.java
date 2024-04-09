package componente;


	import java.util.ArrayList;
	import java.util.Scanner;

	// Interface geral para métodos de Pagamento e PagamentoOnline
	interface PagamentoGeral extends Pagamento {
	    // Métodos comuns para ambas as interfaces
	}

	// Interface para definir métodos básicos de pagamento
	interface Pagamento {
	    double pagamentoPix(double valor);
	    double pagamentoCartao(double valor);
	    double pagamentoBoleto(double valor);
	}

	// Implementação da interface PagamentoGeral que herda Pagamento e implementa PagamentoOnline
	class SistemaPagamento implements PagamentoGeral {
	    private ArrayList<Double> registrosPagamentos = new ArrayList<>();

	    public ArrayList<Double> getRegistrosPagamentos() {
	        return registrosPagamentos;
	    }

	    @Override
	    public double pagamentoPix(double valor) {
	        registrosPagamentos.add(valor);
	        return valor;
	    }

	    @Override
	    public double pagamentoCartao(double valor) {
	        double taxa = valor * 0.05;
	        double valorFinal = valor + taxa;
	        registrosPagamentos.add(valorFinal);
	        return valorFinal;
	    }

	    @Override
	    public double pagamentoBoleto(double valor) {
	        double taxa = valor * 0.05;
	        double valorFinal = valor + taxa;
	        registrosPagamentos.add(valorFinal);
	        return valorFinal;
	    }
	}

	public class teste {
	    public static void main(String[] args) {
	        SistemaPagamento sistemaPagamento = new SistemaPagamento();
	        Scanner sc = new Scanner(System.in);

	        boolean continuarComprando = true;

	        while (continuarComprando) {
	            System.out.println("Escolha o valor do pagamento");
	            double valor = sc.nextDouble();

	            System.out.println("Escolha um método de pagamento:");
	            System.out.println("1- Cartão");
	            System.out.println("2- PIX");
	            System.out.println("3- Boleto");

	            int escolha = sc.nextInt();

	            switch (escolha) {
	                case 1:
	                    double valorCartao = sistemaPagamento.pagamentoCartao(valor);
	                    System.out.println("PAGAMENTO REALIZADO NO VALOR " + valorCartao);
	                    break;
	                case 2:
	                    double valorPix = sistemaPagamento.pagamentoPix(valor);
	                    System.out.println("PAGAMENTO REALIZADO NO VALOR " + valorPix);
	                    break;
	                case 3:
	                    double valorBoleto = sistemaPagamento.pagamentoBoleto(valor);
	                    System.out.println("PAGAMENTO REALIZADO NO VALOR " + valorBoleto);
	                    break;
	                default:
	                    System.out.println("Escolha inválida");
	            }

	            System.out.println("Deseja fazer outra compra? (s/n)");
	            String resposta = sc.next();
	            if (!resposta.equalsIgnoreCase("s")) {
	                continuarComprando = false;
	            }
	        }

	        // Obtendo registros de pagamentos
	        ArrayList<Double> registros = sistemaPagamento.getRegistrosPagamentos();
	        System.out.println("\nRegistros de Pagamentos:");
	        for (Double registro : registros) {
	            System.out.println(registro);
	        }
	    }
	}

