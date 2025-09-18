public class PagamentoCartao implements ProcessadorPagamento {
    //Atributo para guardar o tipo do cartão.
    private  final TipoCartao tipo;
    private StatusPagamento statusAtual = Status.Pagamento.PENDENTE;
    //O construtorexige que o tipo do cartão seja informado.
    public PagamentoCartao(TipoCartao tipo) {
        this.tipo = tipo;
    }

    @Override
    public String iniciarPagamento(Pedido pedido) {
        System.out.println("Processando Cartão de " + this.tipo + " para o pedido " + pedido.getId() + " no valor de R$ " + pedido.getValorTotal());
        String numeroCartaoSimulado = "4444-5555-6666-1234";
        if (numeroCartaoSimulado.endsWith("1234")) { //verifica a veracidade do número do cartão
            System.out.println("Validação inicial do cartão OK. Aguardando confirmação da operadora...");
            this.statusAtual = StatusPagamento.APROVADO;
        } else {
            System.out.println("Dados do cartão inválidos.");
            this.statusAtual = StatusPagamento.REPROVADO;
        }
        return "Cartao_" + new java.util.Random().nextInt(1000); // gerador de números aleatórios
    }
    @Override
    public StatusPagamento verificarStatus(String idTransacao) {
        System.out.println("Verificando status da transação de cartão (" + this.tipo + "): " + idTransacao);
        return this.statusAtual;

    }



}
