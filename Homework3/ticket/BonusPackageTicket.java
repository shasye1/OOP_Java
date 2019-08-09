package ticket;

public class BonusPackageTicket implements ITicket {
    private final ITicket ticket;

    public BonusPackageTicket(ITicket ticket) {

        this.ticket = ticket;
    }

    @Override
    public int getPrice() {
        return ticket.getPrice() + 50;
    }

    @Override
    public String getSummary() {
        return ticket.getSummary() + " + Bonus Package";
    }
}
