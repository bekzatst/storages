package interfaces;

public interface CustomArrayList<E> {
    void put(E item);
    int get(int index);
    void delete(int index);
    void resize(int newSize);
}
