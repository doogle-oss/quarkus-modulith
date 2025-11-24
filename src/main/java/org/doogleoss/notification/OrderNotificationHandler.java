package org.doogleoss.notification;


import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.ObservesAsync;
import org.doogleoss.order.events.OrderCreated;

@ApplicationScoped
public class OrderNotificationHandler {

  void onOrderCreated(@ObservesAsync OrderCreated event) {
    // lightweight example: send notification
    Log.infof("Notify customer for order %s", event.orderId());
  }
}
