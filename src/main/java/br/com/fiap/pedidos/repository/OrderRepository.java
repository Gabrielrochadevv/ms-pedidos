package br.com.fiap.pedidos.repository;

import br.com.fiap.pedidos.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
