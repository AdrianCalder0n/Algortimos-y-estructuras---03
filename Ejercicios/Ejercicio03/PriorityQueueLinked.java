package Ejercicio03;

import java.util.ArrayList;

public class PriorityQueueLinked<E, P extends Comparable> implements PriorityQueue<E, P> {

    public class EntryData {

        private E data;
        private P prio;

        public EntryData(E data, P prioridad) {
            this.data = data;
            this.prio = prioridad;
        }

        public String toString() {
            return data + "";
        }
    }

    private ArrayList<QueueLink<EntryData>> array;
    private int tamano;

    public PriorityQueueLinked(int n) {
        this.array = new ArrayList<>();
        this.tamano = n;
    }

    @Override
    public void enqueue(E x, P pr) throws ExceptionIsEmpty {
        if (isFull() && isPriority(pr) == -1) {
            throw new RuntimeException("Esta LLeno");
        } else {
            EntryData data = new EntryData(x, pr);
            int pos = isPriority(pr);
            if (pos == -1) {
                QueueLink<EntryData> cola = new QueueLink<EntryData>();
                cola.enqueue(data);
                array.add(cola);
                for (int i = 0; i < array.size() - 1; i++) {
                    for (int j = 0; j < array.size() - i - 1; j++) {
                        QueueLink<EntryData> aux = array.get(j);
                        if (array.get(j).back().prio.compareTo(array.get(j + 1).back().prio) > 0) {
                            array.set(j, array.get(j + 1));
                            array.set(j + 1, aux);

                        }
                    }
                }
            } else {
                array.get(pos).enqueue(data);
            }
        }
    }

    public ArrayList<QueueLink<EntryData>> getArray() {
        return array;
    }

    public void setArray(ArrayList<QueueLink<EntryData>> array) {
        this.array = array;
    }

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }

    @Override
    public E dequeue() throws ExceptionIsEmpty {
        E eliminarData = array.get(0).front().data;
        array.remove(0);
        return eliminarData;
    }

    @Override
    public E front() throws ExceptionIsEmpty {
        return array.get(0).front().data;
    }

    @Override
    public E back() throws ExceptionIsEmpty {
        return array.get(array.size() - 1).back().data;
    }

    @Override
    public boolean isEmpty() {
        return tamano == 0;
    }

    public boolean isFull() {
        return tamano == array.size();
    }

    public int isPriority(P pri) throws ExceptionIsEmpty {
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i).back().prio.compareTo(pri) == 0) {
                return i;
            }
        }
        return -1;
    }

    public String toString() {
        String f = "";
        for (QueueLink<EntryData> g : array) {
            f = f + g;
        }
        return f;
    }

}
