package order;

import ticket.ITicket;

public class TicketOrderFactory {

    private IApiCaller apiCaller;

    public TicketOrderFactory(IApiCaller apiCaller){
        this.apiCaller = apiCaller;
    }

    public ITicketOrder createTicketOrder(ITicket ticket, int quantity, boolean purchasedInsurance) {
        if(purchasedInsurance)
            return new TicketOrderProxy(ticket, quantity, apiCaller);
        else
            return new TicketOrder(ticket, quantity, apiCaller);
    }
}
