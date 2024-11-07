package com.example.controller;

import com.example.model.Pedido;
import com.example.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<Pedido> salvar(@RequestBody Pedido pedido) {
        return ResponseEntity.ok(pedidoService.salvar(pedido));
    }

    @GetMapping
    public ResponseEntity<List<Pedido>> listarTodos() {
        return ResponseEntity.ok(pedidoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(pedidoService.buscarPorId(id));
    }

    @GetMapping("/cliente/{idCliente}")
    public ResponseEntity<List<Pedido>> buscarPorIdCliente(@PathVariable Long idCliente) {
        return ResponseEntity.ok(pedidoService.buscarPorIdCliente(idCliente));
    }

    @GetMapping("/produto/{idProduto}")
    public ResponseEntity<List<Pedido>> buscarPorIdProduto(@PathVariable Long idProduto) {
        return ResponseEntity.ok(pedidoService.buscarPorIdProduto(idProduto));
    }
}
