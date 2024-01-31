package part2;

import part1.Event;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class EventNotificationSystem {

    // Map to store event type and corresponding list of handlers
    private Map<String, List<Consumer<Event>>> eventHandlers;

    public EventNotificationSystem() {
        eventHandlers = new HashMap<>();
    }

    // Method to register a handler for a specific event type
    public void registerHandler(String eventType, Consumer<Event> handler) {
        eventHandlers.computeIfAbsent(eventType, k -> new LinkedList<>()).add(handler);
    }

    // Method to trigger notifications for a specific event type
    public void triggerEvent(String eventType, Event event) {
        List<Consumer<Event>> handlers = eventHandlers.getOrDefault(eventType, new LinkedList<>());
        handlers.forEach(handler -> handler.accept(event));
    }
}


}
