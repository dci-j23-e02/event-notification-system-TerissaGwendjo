package part2;

import part1.Event;

import java.util.function.Consumer;

public class EventNotificationSystemDemo {

    public static void main(String[] args) {
        // Create an instance of the EventNotificationSystem
        EventNotificationSystem notificationSystem = new EventNotificationSystem();

        // Register notification handlers for different event types
        Consumer<Event> emailNotifier = event ->
                System.out.println("Email sent for event: " + event.getTitle() + " - " + event.getContent());

        Consumer<Event> smsNotifier = event ->
                System.out.println("SMS sent for event: " + event.getTitle() + " - " + event.getContent());

        Consumer<Event> genericNotifier = event ->
                System.out.println("Notification for event: " + event.getTitle() + " - " + event.getContent());

        notificationSystem.registerHandler("Order Placed", emailNotifier);
        notificationSystem.registerHandler("Order Placed", smsNotifier);
        notificationSystem.registerHandler("System Alert", genericNotifier);

        // Triggering events
        Event orderPlacedEvent = new Event("Order Placed", "New order has been placed.");
        Event systemAlertEvent = new Event("System Alert", "Disk space running low.");

        notificationSystem.triggerEvent("Order Placed", orderPlacedEvent);
        notificationSystem.triggerEvent("System Alert", systemAlertEvent);
    }
}

