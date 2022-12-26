package ma.azehaf.inventoryservice.commonapi.events;

public class BaseEvent<T> {
    private T id;

    public BaseEvent(T id) {
        this.id = id;
    }

    public T getId() {
        return id;
    }
}

