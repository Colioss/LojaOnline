import java.util.Scanner;

public class LojaOnline {
    public static void main(String[] args) throws InterruptedException { //regra de segurança
        Scanner sc = new Scanner(System.in);
        Pedido meuPedido = new Pedido (101, 250.75);
        System.out.println("Bem-vindo à Loja Xopis");
        System.out.println("Seu pedido de R$ " + meuPedido.getValorTotal() + " está pronto para pagamento.");
        System.out.println("\nEscolha a forma de pagamento:");
        System.out.println("1- Cartão");
        System.out.println("2 - PIX");
        System.out.println("3 - Boleto"); //NOVO
        int escolha = sc.nextInt();

        ProcessadorPagamento processador = null; //inicialização de um objeto vazio

        if (escolha == 1) {
            System.out.println("Escolha o tipo de cartão: (1 - Crédito, 2 - Débito)");
            int tipoCarto = scanner.nextInt();
            if (tipoCartao == 1) {
                processador = new PagamentoCartao(TipoCartao.CREDITO);
            } else {
                processador = new PagamentoCartao(TipoCarto.DEBITO);
            }
        }else if (escolha == 2) {
            processador = new PagamentoPix();
        } else if (escolha == 3) {
            //NOVO: Instanciando nosso novo processador de boleto.
            }
        }


    }
}