package br.com.fiap.pedidos.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "tbl_orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_number")
    private Long orderNumber;

    @Size(min = 3, max = 100)
    @Column(name = "client_name", nullable = false)
    private String clientName;

    @Column(name = "order_date", nullable = false)
    private LocalDate orderDate;

    @Positive
    @Column(nullable = false)
    private BigDecimal value;

    @Enumerated(EnumType.STRING)
    @Column(name = "delivery_status", nullable = false)
    private DeliveryStatus deliveryStatus;
}
