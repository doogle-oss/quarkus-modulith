// java
package org.doogleoss;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.doogleoss.order.domain.Order;
import org.doogleoss.order.internal.OrderService;

@Path("/orders")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OrderResource {

  @Inject
  OrderService orderService;

  @POST
  public Response place(Order dto) {
    Order created = orderService.place(dto);
    return Response.ok(created).build();
  }
}
