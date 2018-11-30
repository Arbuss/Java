package ru.omsu.imit.course3.test.collections;

import org.junit.Test;
import ru.omsu.imit.course3.main.collections.CollectionsTestMethods;
import ru.omsu.imit.course3.main.collections.Group;
import ru.omsu.imit.course3.main.collections.GroupProcessor;
import ru.omsu.imit.course3.main.collections.Institute;
import ru.omsu.imit.course3.main.collections.exceptions.GroupException;
import ru.omsu.imit.course3.main.collections.exceptions.InstituteException;
import ru.omsu.imit.course3.main.first_task.trainee.Trainee;
import ru.omsu.imit.course3.main.first_task.trainee.TraineeException;

import java.util.*;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.*;
import static org.junit.Assert.*;

public class CollectionsTest {
    private final int MAX_NUM_COUNT = 99999;
    private final int MIN_NUM_COUNT = 9999;
    private final int CONST_FOR_BIT_SET_TEST = 1000000;

    @Test
    public void constructorTest() throws TraineeException, GroupException {
        Trainee[] trainees = {new Trainee("fn1", "sn1", 3),
                new Trainee("fn2", "sn2", 4)};
        Group group = new Group("mpb-603", trainees);
        assertArrayEquals(trainees, group.getTrainees());
    }

    @Test(expected = GroupException.class)
    public void groupConstructorWithExceptionTest() throws GroupException {
        Group group1 = new Group("mpb-603", null);
        assertEquals(null, group1.getTrainees());
    }

    @Test(expected = TraineeException.class)
    public void traineeConstructorWithException() throws TraineeException {
        Trainee trainee = new Trainee("", null, 0);
    }

    @Test
    public void sortByMarksTest() throws TraineeException, GroupException {
        Trainee[] trainees = {new Trainee("fn1", "sn1", 3),
                new Trainee("fn2", "sn2", 5),
                new Trainee("fn3", "sn3", 4),
        };

        Trainee[] sortedTrainees = {
                new Trainee("fn1", "sn1", 3),
                new Trainee("fn3", "sn3", 4),
                new Trainee("fn2", "sn2", 5)
        };

        Group group = new Group("mpb603", trainees);
        Group sortedGroup = GroupProcessor.sortByMarks(group);

        assertArrayEquals(new Group("mpb603", sortedTrainees).getTrainees(), sortedGroup.getTrainees());
    }

    @Test
    public void sortByNamesTest() throws TraineeException, GroupException {
        Trainee[] trainees = {new Trainee("fn1", "sn1", 3),
                new Trainee("fn2", "sn2", 5),
                new Trainee("fn3", "sn3", 4),
        };

        Trainee[] sortedTrainees = {
                new Trainee("fn1", "sn1", 3),
                new Trainee("fn2", "sn2", 5),
                new Trainee("fn3", "sn3", 4),

        };

        Group group = new Group("mpb603", trainees);
        Group sortedGroup = GroupProcessor.sortByNames(group);

        assertArrayEquals(new Group("mpb603", sortedTrainees).getTrainees(), sortedGroup.getTrainees());
    }

    @Test
    public void findTraineeTest() throws TraineeException, GroupException {
        Trainee[] trainees = {new Trainee("fn1", "sn1", 3),
                new Trainee("fn2", "sn2", 5),
                new Trainee("fn3", "sn3", 4),
        };
        Group group = new Group("mpb603", trainees);


        assertEquals(trainees[1], GroupProcessor.findTrainee(group, "fn2"));
    }

    @Test
    public void arrayListTest() throws TraineeException {
        List<Trainee> list = new LinkedList();
        Collections.addAll( list,
                new Trainee("fn1", "sn1", 3),
                new Trainee("fn2", "sn2", 5),
                new Trainee("fn3", "sn3", 4)
        );

        List<Trainee> finalList = new LinkedList();
        Collections.addAll( finalList,
                new Trainee("fn2", "sn2", 5),
                new Trainee("fn1", "sn1", 3),
                new Trainee("fn3", "sn3", 4)
        );

        assertEquals(finalList, CollectionsTestMethods.arrayListTestMethods(list));
        Collections.shuffle(list);
        assertNotEquals(finalList, list);
    }

    @Test
    public void arrayListFindTest() throws TraineeException {
        List<Trainee> list = new LinkedList();
        Collections.addAll( list,
                new Trainee("fn1", "sn1", 3),
                new Trainee("fn2", "sn2", 5),
                new Trainee("fn3", "sn3", 4)
        );

        assertEquals(list.get(1), CollectionsTestMethods.findTraineeWithMaxMark(list));
        assertEquals(list.get(2), CollectionsTestMethods.findTraineeByName(list, "fn3"));
    }

    @Test
    public void ArrayListSortTest() throws TraineeException {
        List<Trainee> list = new LinkedList();
        Collections.addAll( list,
                new Trainee("fn1", "sn1", 3),
                new Trainee("fn2", "sn2", 5),
                new Trainee("fn3", "sn3", 4)
        );

        List<Trainee> sortedByMarksList = new LinkedList();
        Collections.addAll( sortedByMarksList,
                new Trainee("fn1", "sn1", 3),
                new Trainee("fn3", "sn3", 4),
                new Trainee("fn2", "sn2", 5)
        );

        List<Trainee> sortedByNamesList = new LinkedList();
        Collections.addAll( sortedByNamesList,
                new Trainee("fn1", "sn1", 3),
                new Trainee("fn2", "sn2", 5),
                new Trainee("fn3", "sn3", 4)
        );

        assertEquals(sortedByMarksList, CollectionsTestMethods.sortedByMarks(list));
        assertEquals(sortedByNamesList, CollectionsTestMethods.sortedByNames(list));
    }

    @Test
    public void comparingArrayAndLinkedList(){
        List<Integer> arrayList = new ArrayList();
        Collections.addAll(arrayList,
                0, 1, 2, 3, 4, 5, 6, 7);

        List<Integer> linkedList = new LinkedList();
        Collections.addAll(linkedList,
                0, 1, 2, 3, 4, 5, 6, 7);
        long startTime = System.nanoTime();
        arrayList.get(3);
        long arrayListFinalTime = System.nanoTime() - startTime;
        startTime = System.nanoTime();
        linkedList.get(3);
        long linkedListFinalTime = System.nanoTime() - startTime;

        assertTrue(arrayListFinalTime < linkedListFinalTime);
    }

    @Test
    public void comparingArrayAndLinkedList2() {
        List<Integer> arrayList = new ArrayList();
        for(int i = 0; i <= MAX_NUM_COUNT; i++){
            arrayList.add(i);
        }

        List<Integer> linkedList = new LinkedList();
        for(int i = 0; i <= MAX_NUM_COUNT; i++){
            linkedList.add(i);
        }
        Random rnd = new Random();

        long startTime = System.nanoTime();
        for(int i = 0; i <= MAX_NUM_COUNT; i++){
            arrayList.get(rnd.nextInt(MAX_NUM_COUNT + 1));
        }
        long arrayListFinalTime = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startTime);

        startTime = System.nanoTime();
        for(int i = 0; i <= MAX_NUM_COUNT; i++){
            linkedList.get(rnd.nextInt(MAX_NUM_COUNT + 1));
        }
        long linkedListFinalTime = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startTime);

        assertTrue(arrayListFinalTime < linkedListFinalTime);
    }

    @Test
    public void queueTest() throws TraineeException {
        Queue<Trainee> queue = new PriorityQueue<>();
        Collections.addAll(queue,
                new Trainee("fn1", "sn1", 3),
                new Trainee("fn2", "sn2", 5),
                new Trainee("fn3", "sn3", 4)
                );

        queue.poll();
        queue.poll();
        queue.poll();

        assertEquals(0, queue.size());
    }

    @Test
    public void hashSetTest() throws TraineeException {
        Set<Trainee> hashSet = new HashSet<>();
        Collections.addAll( hashSet,
                new Trainee("fn1", "sn1", 3),
                new Trainee("fn2", "sn2", 5),
                new Trainee("fn3", "sn3", 4)
        );

        assertTrue(hashSet.contains(new Trainee("fn2", "sn2", 5)));

        for (Trainee trainee : hashSet) {
            System.out.println(trainee.toString());
        }
    }

    @Test
    public void treeSetTest() throws TraineeException {
        Set<Trainee> treeSet = new TreeSet<>();

        treeSet.add(new Trainee("fn1", "sn1", 3));
        treeSet.add(new Trainee("fn2", "sn2", 5));
        treeSet.add(new Trainee("fn3", "sn3", 4));

        assertTrue(treeSet.contains(new Trainee("fn2", "sn2", 5)));

        treeSet.forEach(System.out::println);
    }

    @Test
    public void treeSetTest2() throws TraineeException {
        Set<Trainee> treeSet = new TreeSet<>();
        Collections.addAll(treeSet,
                new Trainee("fn1", "sn1", 3),
                new Trainee("fn2", "sn2", 5),
                new Trainee("fn3", "sn3", 4)
        );

        treeSet.forEach(System.out::println);
    }

    @Test
    public void treeSetSortTest() throws TraineeException {
        Set<Trainee> treeSet = new TreeSet<>();

        treeSet.add(new Trainee("fn2", "sn2", 5));
        treeSet.add(new Trainee("fn1", "sn1", 3));
        treeSet.add(new Trainee("fn3", "sn3", 4));

        Set<Trainee> sortedSet = ((TreeSet<Trainee>) treeSet).descendingSet();
        sortedSet.add(new Trainee("fn4", "sn4", 3));

        assertTrue(sortedSet.contains(new Trainee("fn4", "sn5", 3)));
        sortedSet.forEach(System.out::println);
    }

    @Test
    public void comparingArrayListAndSet(){
        List<Integer> arrayList = new ArrayList();
        for(int i = 0; i <= MAX_NUM_COUNT; i++){
            arrayList.add(i);
        }

        Random rnd = new Random();
        long startTime = System.nanoTime();

        for(int i = 0; i <= MAX_NUM_COUNT; i++){
            arrayList.contains(rnd.nextInt(MAX_NUM_COUNT + 1));
        }
        long arrayListFinalTime = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startTime);

        Set<Integer> hashSet = new HashSet<>();
        for(int i = 0; i <= MAX_NUM_COUNT; i++){
            hashSet.add(i);
        }

        startTime = System.nanoTime();
        for(int i = 0; i <= MAX_NUM_COUNT; i++){
            hashSet.contains(rnd.nextInt(MAX_NUM_COUNT + 1));
        }
        long hashSetFinalTime = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startTime);

        Set<Integer> treeSet = new TreeSet<>();
        for(int i = 0; i <= MAX_NUM_COUNT; i++){
            treeSet.add(i);
        }

        startTime = System.nanoTime();
        for(int i = 0; i <= MAX_NUM_COUNT; i++){
            treeSet.contains(rnd.nextInt(MAX_NUM_COUNT + 1));
        }
        long treeSetFinalTime = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startTime);

        assertTrue(arrayListFinalTime > hashSetFinalTime);
        assertTrue(arrayListFinalTime > treeSetFinalTime);
        assertTrue(treeSetFinalTime > hashSetFinalTime);
    }

    @Test
    public void hashMapTest() throws TraineeException, InstituteException {
        Map<Trainee, Institute>  hashMap = new HashMap();

        hashMap.put(new Trainee("fn2", "sn2", 5), new Institute("IMIT", "Omsk"));
        hashMap.put(new Trainee("fn1", "sn1", 3), new Institute("IMIT", "Omsk"));
        hashMap.put(new Trainee("fn3", "sn3", 4), new Institute("Not IMIT", "Omsk"));

        assertEquals(new Institute("Not IMIT", "Omsk"),
                hashMap.get(new Trainee("fn3", "sn3", 4)));

        hashMap.keySet().forEach(System.out::println);
    }

    @Test
    public void treeMapTest() throws TraineeException, InstituteException {
        Map<Trainee, Institute>  treeMap = new TreeMap();

        treeMap.put(new Trainee("fn2", "sn2", 5), new Institute("IMIT", "Omsk"));
        treeMap.put(new Trainee("fn1", "sn1", 3), new Institute("IMIT", "Omsk"));
        treeMap.put(new Trainee("fn3", "sn3", 4), new Institute("Not IMIT", "Omsk"));

        assertEquals(new Institute("Not IMIT", "Omsk"),
                treeMap.get(new Trainee("fn3", "sn3", 4)));

        treeMap.keySet().forEach(System.out::println);
        treeMap.entrySet().forEach(System.out::println);
    }

    @Test
    public void treeMapTest2() throws TraineeException, InstituteException {
        Map<Trainee, Institute>  treeMap = new TreeMap();
        treeMap.put(new Trainee("fn2", "sn2", 5), new Institute("IMIT", "Omsk"));
        treeMap.put(new Trainee("fn1", "sn1", 3), new Institute("IMIT", "Omsk"));
        treeMap.put(new Trainee("fn3", "sn3", 4), new Institute("Not IMIT", "Omsk"));

        ((TreeMap<Trainee, Institute>) treeMap).descendingMap();

        treeMap.put(new Trainee("fn4", "sn4", 4), new Institute("Not IMIT", "Omsk"));
        assertTrue(treeMap.containsKey(new Trainee("fn4", "sn5", 4)));

        treeMap.keySet().forEach(System.out::println);
        treeMap.entrySet().forEach(System.out::println);
    }

    @Test
    public void bitSetTest(){
        BitSet bitSet = new BitSet();
        bitSet.set(0, 10);

        assertTrue(bitSet.get(5));
        bitSet.clear(5);

        assertFalse(bitSet.get(5));
    }

    @Test
    public void comparingSetsTest(){
        BitSet bitSet = new BitSet();

        long startTime = System.nanoTime();
        bitSet.set(0, CONST_FOR_BIT_SET_TEST);
        long bitSetFinalTime = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startTime);

        Set<Integer> hashSet = new HashSet<>();
        startTime = System.nanoTime();
        for(int i = 0; i <= CONST_FOR_BIT_SET_TEST; i++){
            hashSet.add(i);
        }
        long hashSetFinalTime = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startTime);

        Set<Integer> treeSet = new TreeSet<>();
        startTime = System.nanoTime();
        for(int i = 0; i <= CONST_FOR_BIT_SET_TEST; i++){
            treeSet.add(i);
        }
        long treeSetFinalTime = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startTime);

        assertTrue(bitSetFinalTime < hashSetFinalTime);
        assertTrue(bitSetFinalTime < treeSetFinalTime);
        assertTrue(hashSetFinalTime < treeSetFinalTime);
    }

    enum Color{
        RED, GREEN, BLUE, ANY_OTHER
    }

    @Test
    public void enumSetTest(){
        EnumSet<Color> enumAll = EnumSet.allOf(Color.class);
        EnumSet<Color> enumOne = EnumSet.of(Color.BLUE);
        EnumSet<Color> enumRange = EnumSet.range(Color.GREEN, Color.ANY_OTHER);
        EnumSet<Color> enumEmpty = EnumSet.noneOf(Color.class);

        assertTrue(enumAll.contains(Color.RED));
        assertTrue(enumOne.contains(Color.BLUE));
        assertTrue(enumRange.contains(Color.GREEN));

        assertFalse(enumOne.contains(Color.GREEN));
        assertFalse(enumRange.contains(Color.RED));
        assertFalse(enumEmpty.contains(Color.RED));
    }

    @Test
    public void findSetOfSameStrings(){
        int[][] matrix = {{1, 2, 3}, {3, 2, 1}, {4, 2, 1}};
        Set<Set<Integer>> set = CollectionsTestMethods.findSetOfSameStrings(matrix);
        Set<Set<Integer>> sameStringsSet = new HashSet<>();
        Set<Integer> firstStringSet = new HashSet<>();
        Collections.addAll(firstStringSet, 1, 2, 3);
        Set<Integer> secondStringSet = new HashSet<>();
        Collections.addAll(secondStringSet, 1, 2, 4);
        Collections.addAll(sameStringsSet, firstStringSet, secondStringSet);

        assertEquals(sameStringsSet, set);
    }
}
