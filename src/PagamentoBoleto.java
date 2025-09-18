public class PagamentoBoleto implements ProcessadorPagamento {
    private boolean boletoFoiPago = false;
    @Override
    public String iniciarPagamento(Pedido pedido) {
        System.out.println("Processando Boleto para o pedido " + pedido.getId() + " no valor de R$ " + pedido.getValorTotal());
        System.out.println("Código de Barras: 23793.38128 60082.232402 02402.024013 1 9845000025075");
        System.out.println("Boleto gerado com vencimento para 3 dias úteis.");
        System.out.println("Aguardando pagamento...");
        return "BOLETO_" + new java.util.Random().nextInt(10000);
    }

    @Override
    public StatusPagamento verificarStatus(String idTransacao) {
        System.out.println("Consultando sistema de compensação para o boleto: " + idTransacao);

        //Simulação: A cada verificação, existe uma chance de 30% do boleto ter sido pago.
        if (!this.boletoFoiPago && Math.random() < 0.3) {
            this.boletoFoiPago = true;
        }

        if (this.boletoFoiPago) {
            return StatusPagamento.APROVADO;
        }else{
            return StatusPagamento.PENDENTE;
        }
    }
}
