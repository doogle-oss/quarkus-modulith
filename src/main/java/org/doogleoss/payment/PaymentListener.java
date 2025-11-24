// java
package org.doogleoss.payment;

import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Event;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import org.doogleoss.order.events.OrderCreated;
//import org.eclipse.microprofile.reactive.messaging.Incoming;

@ApplicationScoped
public class PaymentListener {

  @Inject
  Event<OrderCreated> orderCreatedEvent;

  void onOrderCreated(@Observes OrderCreated event) {
    Log.infof("Payment received for order %s", event.orderId());
  }

//    // example incoming payment topic -> translate to internal domain event
//    @Incoming("payments")
//    public void process(PaymentSuccess event) {
//        // transform extern event to internal domain event and publish
//        orderCreatedEvent.fireAsync(new OrderCreated(event.orderId()));
//    }

  public record PaymentSuccess(String orderId) {

  }
}
