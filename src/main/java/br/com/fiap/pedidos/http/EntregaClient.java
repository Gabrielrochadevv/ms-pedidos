package br.com.fiap.pedidos.http;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//requisição
@FeignClient("entregas-ms")
public interface EntregaClient {

    //pedido de atualização do status do pedido de entrega
    @RequestMapping(method = RequestMethod.PUT, value = "/entregas/{id}/transporte")
    void atualizaEntrega(@PathVariable Long id);

}
