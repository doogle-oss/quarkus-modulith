// java
package org.doogleoss.order.internal;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;
import org.doogleoss.order.domain.Order;
import org.doogleoss.order.events.OrderCreated;

@ApplicationScoped
public class OrderService {

  @Inject
  OrderRepository repo;

  @Inject
  Event<OrderCreated> orderCreatedEvent;

  public Order place(Order order) {
    repo.save(order);
    // fire async domain event (zero coupling)
    orderCreatedEvent.fireAsync(new OrderCreated(order.id()));
    return order;
  }
}
