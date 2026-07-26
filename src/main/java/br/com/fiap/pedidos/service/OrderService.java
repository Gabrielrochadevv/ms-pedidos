package br.com.fiap.pedidos.service;

import br.com.fiap.pedidos.dto.OrderRequestDto;
import br.com.fiap.pedidos.dto.OrderResponseDto;
import br.com.fiap.pedidos.exception.OrderNotFoundException;
import br.com.fiap.pedidos.http.DeliveryClient;
import br.com.fiap.pedidos.model.Order;
import br.com.fiap.pedidos.model.DeliveryStatus;
import br.com.fiap.pedidos.repository.OrderRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public OrderResponseDto create(OrderRequestDto orderDto) {
        Order order = new Order();
        BeanUtils.copyProperties(orderDto, order);

        order.setDeliveryStatus(DeliveryStatus.IN_SEPARATION);
        Order orderCreate = orderRepository.save(order);

        return new OrderResponseDto(orderCreate);

    }

    public OrderResponseDto update(OrderRequestDto orderDto) {
        Order order = new Order();
        BeanUtils.copyProperties(orderDto, order);
        Order updatedOrder = orderRepository.save(order);
        return new OrderResponseDto(updatedOrder);
    }

    public void delete(Long orderNumber) {
        Optional<Order> orderOptional = orderRepository.findById(orderNumber);

        if (orderOptional.isPresent()) {
            orderRepository.delete(orderOptional.get());
        } else {
            throw new OrderNotFoundException(String.format("Pedido %s não existe!", orderNumber));
        }
        Order order = new Order();
    }

    public OrderResponseDto searchByOrderNumber(Long orderNumber) {
        Optional<Order> orderOptional = orderRepository.findById(orderNumber);

        if (orderOptional.isPresent()) {
            return new OrderResponseDto(orderOptional.get());
        } else {
            throw new OrderNotFoundException(String.format("Pedido %s não existe!", orderNumber));
        }
    }
}
