// java
package org.doogleoss.order.internal;

import jakarta.enterprise.context.ApplicationScoped;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.doogleoss.order.domain.Order;

@ApplicationScoped
public class OrderRepository {

  private final Map<String, Order> store = new ConcurrentHashMap<>();

  public Order save(Order order) {
    store.put(order.id(), order);
    return order;
  }

  public Order findById(String id) {
    return store.get(id);
  }
}
