package order;

import org.junit.jupiter.api.Test;
import ticket.ITicket;
import ticket.TicketBuilder;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TicketOrderTest {

    @Test
    public void testSubmitTicketOrderMakesProperApiCall(){

        // Arrange
        final DataRecorder dataRecorder = new DataRecorder();
        TicketOrderFactory ticketOrderFactory = new TicketOrderFactory((url, dataJson)
                -> dataRecorder.apiCalls.add(new ApiCall(url, dataJson)));
        TicketBuilder tb = new TicketBuilder();
        ITicket ticket = tb.addTicket("Pearl Jam", 80)
                .addBonusPackage()
                .getTicket();

        ITicketOrder ticketOrder = ticketOrderFactory.createTicketOrder(ticket, 3, false);

        // Act
        ticketOrder.submitTicketOrder();

        // Assert
        assertEquals(1, dataRecorder.apiCalls.size());
        ApiCall apiCall = dataRecorder.apiCalls.get(0);
        assertEquals("www.ticketorder.com/api/submitOrder", apiCall.url);
        assertEquals("{showName: \"Pearl Jam + Bonus Package\", quantity: 3}", apiCall.dataJson);
    }

    @Test
    public void testSubmitTicketOrderProxyMakesProperApiCall(){

        // Arrange
        final DataRecorder dataRecorder = new DataRecorder();
        TicketOrderFactory ticketOrderFactory = new TicketOrderFactory((url, dataJson)
                -> dataRecorder.apiCalls.add(new ApiCall(url, dataJson)));
        TicketBuilder tb = new TicketBuilder();
        ITicket ticket = tb.addTicket("Pearl Jam", 80)
                .addBonusPackage()
                .getTicket();

        ITicketOrder ticketOrder = ticketOrderFactory.createTicketOrder(ticket, 3, true);

        // Act
        ticketOrder.submitTicketOrder();

        // Assert
        assertEquals(2, dataRecorder.apiCalls.size());
        ApiCall apiCall = dataRecorder.apiCalls.get(0);
        assertEquals("www.ticketorder.com/api/submitOrder", apiCall.url);
        assertEquals("{showName: \"Pearl Jam + Bonus Package\", quantity: 3}", apiCall.dataJson);
        apiCall = dataRecorder.apiCalls.get(1);
        assertEquals("www.ticketinsurance.com/api/addInsurance", apiCall.url);
        assertEquals("{\"orderNumber\": \"" + ticketOrder.getOrderNumber() + "\"}", apiCall.dataJson);
    }

    class DataRecorder {
        List<ApiCall> apiCalls = new ArrayList<>();
    }
    class ApiCall {
        String url;
        String dataJson;

        ApiCall(String url, String dataJson){
            this.url = url;
            this.dataJson = dataJson;
        }
    }
}
