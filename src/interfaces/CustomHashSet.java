package interfaces;

public interface CustomHashSet<E> {
    void put(E item);
    boolean contains(E item);
    E delete(E item);
    void resize(int newSize);
    void iterate();
}
