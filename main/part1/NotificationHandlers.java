package part1;
import java.util.function.Consumer;
import java.util.function.BiConsumer;
public class NotificationHandlers {
    public static void main(String[] args) {
        // Notification handler for emails
        Consumer<Event> emailNotifier = event ->
                System.out.println("Email sent for event: " + event.getTitle() + " - " + event.getContent());

        // Notification handler for SMS
        Consumer<Event> smsNotifier = event ->
                System.out.println("SMS sent for event: " + event.getTitle() + " - " + event.getContent());

        // Generic notification handler
        BiConsumer<Event, String> genericNotifier = (event, message) ->
                System.out.println("Notification for event: " + event.getTitle() + " - " + event.getContent() + ". Message: " + message);

        // Example usage
        Event orderEvent = new Event("Order Update", "Your order has been shipped.");
        emailNotifier.accept(orderEvent);
        smsNotifier.accept(orderEvent);
        genericNotifier.accept(orderEvent, "Thank you for your purchase!");
    }
}

