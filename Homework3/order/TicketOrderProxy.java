package order;

import ticket.ITicket;

public class TicketOrderProxy implements ITicketOrder {
    private final TicketOrder ticketOrder;
    private final IApiCaller apiCaller;

    public TicketOrderProxy(ITicket ticket, int quantity, IApiCaller apiCaller) {
        ticketOrder = new TicketOrder(ticket, quantity, apiCaller);
        this.apiCaller = apiCaller;
    }

    @Override
    public void submitTicketOrder() {
        ticketOrder.submitTicketOrder();
        apiCaller.callApi("www.ticketinsurance.com/api/addInsurance",
                "{\"orderNumber\": \"" + ticketOrder.getOrderNumber() + "\"}");
    }

    @Override
    public String getOrderNumber() {
        return ticketOrder.getOrderNumber();
    }
}
