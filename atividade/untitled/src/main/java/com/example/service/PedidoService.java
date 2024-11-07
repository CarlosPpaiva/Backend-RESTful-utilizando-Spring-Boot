package com.example.service;

import com.example.model.Pedido;
import com.example.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    public Pedido salvar(Pedido pedido) {
        if (pedido.getIdCliente() == null || pedido.getIdsProdutos() == null || pedido.getIdsProdutos().isEmpty()) {
            throw new IllegalArgumentException("Pedido deve conter id de cliente e produtos válidos");
        }
        return pedidoRepository.save(pedido);
    }

    public List<Pedido> listarTodos() {
        return pedidoRepository.findAll();
    }

    public Pedido buscarPorId(Long id) {
        return pedidoRepository.findById(id).orElse(null);
    }

    public List<Pedido> buscarPorIdCliente(Long idCliente) {
        return pedidoRepository.findByIdCliente(idCliente);
    }

    public List<Pedido> buscarPorIdProduto(Long idProduto) {
        return pedidoRepository.findByIdsProdutosContaining(idProduto);
    }
}
