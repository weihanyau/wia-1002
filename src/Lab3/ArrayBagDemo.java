package Lab3;

public class ArrayBagDemo {
    public static void main(String[] args) {
        ArrayBag<String> bag1 = new ArrayBag<>();
        ArrayBag<String> bag2 = new ArrayBag<>();

        String[] contentsOfBag1 = {"A", "A", "B", "A", "C", "A"};
        String[] contentsOfBag2 = {"A", "B", "A", "C", "B", "C", "D", "another string"};

        System.out.println("bag1");
        testAdd(bag1, contentsOfBag1);
        displayBag(bag1);

        System.out.println("\nbag2");
        testAdd(bag2, contentsOfBag2);
        displayBag(bag2);

        BagInterface<String> bag3 = bag1.union(bag2);
        System.out.println("\nbag3, test the method union of bag1 and bag2:");
        displayBag(bag3);

        BagInterface<String> bag4 = bag1.intersection(bag2);
        System.out.println("\nbag4, test the method intersection of bag1 and bag2:");
        displayBag(bag4);

        BagInterface<String> bag5 = bag1.difference(bag2);
        System.out.println("\nbag5, test the method difference of bag1 and bag2:");
        displayBag(bag5);

    }

    private static void testAdd(BagInterface<String> aBag, String[] content) {
        System.out.print("Adding ");
        for (int i = 0; i < content.length; i++) {
            aBag.add(content[i]);
            System.out.print(content[i] + " ");
        }
        System.out.println("");
    }

    private static void displayBag(BagInterface<String> aBag) {
        System.out.printf("The bag contains %d string(s), as follows: \n", aBag.getCurrentSize());
        Object[] temp = aBag.toArray();
        for (int i = 0; i < aBag.getCurrentSize(); i++) {
            System.out.print(temp[i] + " ");
        }
        System.out.println("");
    }
}

