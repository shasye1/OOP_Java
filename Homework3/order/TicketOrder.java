package order;

import ticket.ITicket;

import java.util.Random;

public class TicketOrder implements ITicketOrder {

    private ITicket ticket;
    private int quantity;
    private String orderNumber;
    private final IApiCaller apiCaller;

    public TicketOrder(ITicket ticket, int quantity, IApiCaller apiCaller) {
        this.apiCaller = apiCaller;
        this.quantity = quantity;
        this.ticket = ticket;
        orderNumber = Integer.toString(new Random().nextInt(Integer.MAX_VALUE));
    }

    @Override
    public void submitTicketOrder() {
        apiCaller.callApi("www.ticketorder.com/api/submitOrder",
                "{showName: \"" + ticket.getSummary() + "\", quantity: " + quantity + "}");
        Integer orderNumberInt = new Random().nextInt();
        orderNumber = orderNumberInt.toString();
    }

    public String getOrderNumber(){
        return orderNumber;
    }
}
