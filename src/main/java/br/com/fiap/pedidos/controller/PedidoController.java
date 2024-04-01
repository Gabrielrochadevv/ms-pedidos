package br.com.fiap.pedidos.controller;

import br.com.fiap.pedidos.dto.PedidoDto;
import br.com.fiap.pedidos.dto.PedidoExibicaoDto;
import br.com.fiap.pedidos.service.PedidoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService service;

    @PostMapping
    public PedidoExibicaoDto criar(@RequestBody @Valid PedidoDto pedidoDto){
        return service.criar(pedidoDto);
    }

    @GetMapping("{numeroPedido}")
    public ResponseEntity<PedidoExibicaoDto> buscarPorNumeroPedido(@PathVariable Long numeroPedido){
        return ResponseEntity.ok(service.buscarPorNumeroPedido(numeroPedido));
    }

    @GetMapping
    public ResponseEntity<List<PedidoExibicaoDto>> exibirTodosOsPedidos(){
        return ResponseEntity.ok(service.exibirTodosOsPedidos());
    }

    @DeleteMapping("{numeroPedido}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long numeroPedido){
        service.excluir(numeroPedido);
    }

    @PutMapping
    public PedidoExibicaoDto atualizar(@RequestBody PedidoDto pedidoDto){
        return service.atualizar(pedidoDto);
    }

}
