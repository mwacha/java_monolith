package tk.mwacha.gateway;

import tk.mwacha.domain.Order;

import java.util.UUID;

public interface CheckoutGateway {

    void addOrder(Order order);
    Order findOrder(UUID id);
}
