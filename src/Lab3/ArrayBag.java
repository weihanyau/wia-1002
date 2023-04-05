package Lab3;


import java.lang.reflect.Array;

public class ArrayBag<T> implements BagInterface<T> {
    private T[] bag;
    private static final int DEFAULT_CAPACITY = 25;
    private int numberOfEntries = 0;

    public ArrayBag() {
        bag = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public ArrayBag(int capacity) {
        bag = (T[]) new Object[capacity];
    }

    @Override
    public int getCurrentSize() {
        return numberOfEntries;
    }

    @Override
    public boolean isFull() {
        return numberOfEntries == bag.length;
    }

    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    @Override
    public boolean add(T newEntry) {
        if (isFull()) {
            return false;
        }
        bag[numberOfEntries++] = newEntry;
        return true;
    }

    @Override
    public T remove() {
        if (isEmpty()) {
            return null;
        }
        return bag[numberOfEntries--];
    }

    @Override
    public boolean remove(T anEntry) {
        if (isEmpty()) {
            return false;
        }
        for (int i = 0; i < numberOfEntries; i++) {
            if (bag[i].equals(anEntry)) {
                bag[i] = bag[numberOfEntries - 1];
                bag[numberOfEntries - 1] = null;
                numberOfEntries--;
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        numberOfEntries = 0;
    }

    @Override
    public int getFrequencyOf(T anEntry) {
        int count = 0;
        for (int i = 0; i < numberOfEntries; i++) {
            if (bag[i].equals(anEntry)) {
                count++;
            }
        }
        return count;
    }

    @Override
    public boolean contains(T anEntry) {
        for (int i = 0; i < numberOfEntries; i++) {
            if (bag[i].equals(anEntry)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public T[] toArray() {
        T[] newArray = (T[]) new Object[numberOfEntries];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = bag[i];
        }
        return newArray;
    }

    @Override
    public BagInterface<T> union(BagInterface<T> second) {
        ArrayBag<T> secondBag = (ArrayBag<T>) second;
        BagInterface<T> unionBag = new ArrayBag<T>(this.getCurrentSize() + secondBag.numberOfEntries);
        for (int i = 0; i < numberOfEntries; i++) {
            unionBag.add(bag[i]);
        }
        for (int i = 0; i < secondBag.numberOfEntries; i++) {
            unionBag.add(secondBag.bag[i]);
        }

        return unionBag;
    }

    @Override
    public BagInterface<T> intersection(BagInterface<T> second) {
        ArrayBag<T> secondBag = (ArrayBag<T>) second;
        BagInterface<T> intersectionBag = new ArrayBag<T>(this.getCurrentSize() + secondBag.numberOfEntries);

        for (int i = 0; i < numberOfEntries; i++) {
            if (intersectionBag.contains(bag[i]))
                continue;
            if (secondBag.contains(bag[i])) {
                int count = Math.min(getFrequencyOf(bag[i]), secondBag.getFrequencyOf(bag[i]));
                for (int j = 0; j < count; j++) {
                    intersectionBag.add(bag[i]);
                }
            }
        }
        return intersectionBag;
    }

    @Override
    public BagInterface<T> difference(BagInterface<T> second) {
        ArrayBag<T> secondBag = (ArrayBag<T>) second;
        BagInterface<T> differenceBag = new ArrayBag<T>(this.getCurrentSize() + secondBag.numberOfEntries);

        for (int i = 0; i < numberOfEntries; i++) {
            if (differenceBag.contains(bag[i]))
                continue;
            if (!secondBag.contains(bag[i])) {
                int count = getFrequencyOf(bag[i]);
                for (int j = 0; j < count; j++) {
                    differenceBag.add(bag[i]);
                }
            } else {
                int count1 = getFrequencyOf(bag[i]);
                int count2 = secondBag.getFrequencyOf(bag[i]);
                for (int j = 0; j < Math.max(0, count1 - count2); j++) {
                    differenceBag.add(bag[i]);
                }
            }
        }
        return differenceBag;
    }
}
