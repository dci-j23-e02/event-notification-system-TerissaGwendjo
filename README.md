# Assignment: Building an Event Notification System using Consumers and BiConsumers

## Assignment Overview

In this assignment, you will develop an Event Notification System that notifies subscribers about various events, such as order updates, system alerts, or custom messages. This system will leverage Java's functional programming capabilities, specifically the `Consumer` and `BiConsumer` interfaces, to handle different types of notifications. Your task is to design and implement a flexible notification mechanism that can send email notifications, SMS, or perform other notification actions based on the event type.

### Part 1: Designing the Notification Handlers

#### Objective

Create notification handlers using `Consumer` and `BiConsumer` interfaces to process different types of events. Each handler will represent a specific notification action, such as sending an email or an SMS.

#### Task Breakdown

1. **Notification Handler for Emails**:
   - Implement a `Consumer<Event>` that simulates sending an email notification. The consumer should print a message to the console indicating that an email has been sent, including the event details.

2. **Notification Handler for SMS**:
   - Implement a `Consumer<Event>` that simulates sending an SMS notification. Similar to the email handler, this consumer should print a message to the console indicating that an SMS has been sent with the event details.

3. **Generic Notification Handler**:
   - Implement a `BiConsumer<Event, String>` that takes an event and a custom message as input. This handler should print both the event details and the custom message to the console, simulating a generic notification action.

#### Code Snippet Example

```java
import java.util.function.Consumer;
import java.util.function.BiConsumer;

class Event {
    private String title;
    private String content;

    public Event(String title, String content) {
        this.title = title;
        this.content = content;
    }

    // Getters
    public String getTitle() { return title; }
    public String getContent() { return content; }
}

public class NotificationHandlers {
    public static void main(String[] args) {
        Consumer<Event> emailNotifier = event ->
            System.out.println("Email sent for event: " + event.getTitle() + " - " + event.getContent());

        Consumer<Event> smsNotifier = event ->
            System.out.println("SMS sent for event: " + event.getTitle() + " - " + event.getContent());

        BiConsumer<Event, String> genericNotifier = (event, message) ->
            System.out.println("Notification for event: " + event.getTitle() + " - " + event.getContent() + ". Message: " + message);

        // Example usage
        Event orderEvent = new Event("Order Update", "Your order has been shipped.");
        emailNotifier.accept(orderEvent);
        smsNotifier.accept(orderEvent);
        genericNotifier.accept(orderEvent, "Thank you for your purchase!");
    }
}
```

### Part 2: Implementing the Event Notification System

#### Objective

Using the notification handlers designed in Part 1, implement an Event Notification System that can register multiple handlers for different event types and notify all registered handlers when an event occurs.

#### Task Breakdown

1. **System Design**:
   - Design a system that allows registration of multiple notification handlers for different event types.
   - Implement a method to trigger notifications for an event, invoking all registered handlers for that event type.

2. **Event Triggering**:
   - Simulate the occurrence of different events (e.g., "Order Placed", "System Alert") and demonstrate how the system notifies all registered handlers for those events.

#### Submission Guidelines

- Ensure your code is well-commented, explaining the purpose and functionality of each component in your notification system.
- Test your system with various events and handlers to demonstrate its flexibility and effectiveness.
- Submit your source code, clearly indicating both parts of the assignment.

This assignment will challenge you to apply functional programming concepts in a practical scenario, enhancing your ability to design and implement flexible systems in Java. Good luck!
