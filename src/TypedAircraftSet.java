import java.util.*;

/**
 * Типізована колекція, що реалізує інтерфейс Set і має двозв'язний список як внутрішню структуру.
 * @param <T> Тип елементів колекції, що є підкласами Aircraft.
 */
public class TypedAircraftSet<T extends Aircraft> implements Set<T> {
    /**
     * Внутрішній двозв’язний список для зберігання елементів.
     */
    private final LinkedList<T> list;

    /**
     * Порожній конструктор.
     */
    public TypedAircraftSet() {
        list = new LinkedList<>();
    }

    /**
     * Конструктор, який приймає один об'єкт.
     * @param aircraft Об'єкт типу T.
     */
    public TypedAircraftSet(T aircraft) {
        this();
        add(aircraft);
    }

    /**
     * Конструктор, який приймає стандартну колекцію.
     * @param collection Колекція об'єктів типу T.
     */
    public TypedAircraftSet(Collection<? extends T> collection) {
        this();
        addAll(collection);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return list.contains(o);
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }

    @Override
    public Object[] toArray() {
        return list.toArray();
    }

    @Override
    public <U> U[] toArray(U[] a) {
        return list.toArray(a);
    }

    @Override
    public boolean add(T t) {
        // Додаємо тільки унікальні елементи
        if (!list.contains(t)) {
            return list.add(t);
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return list.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return list.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        boolean modified = false;
        for (T element : c) {
            if (add(element)) {
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return list.retainAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return list.removeAll(c);
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (T item : list) {
            result.append(item).append("\n");
        }
        return result.toString();
    }
}
