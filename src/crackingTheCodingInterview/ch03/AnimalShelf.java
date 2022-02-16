package crackingTheCodingInterview.ch03;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 面试题 03.06. 动物收容所
 * @author xinchan
 * @version 1.0.1 2022-02-11
 */
public class AnimalShelf {
    private Deque<int[]> deque;
    private Deque<int[]> assistDeque;

    public AnimalShelf() {
        deque = new ArrayDeque<>();
        assistDeque = new ArrayDeque<>();
    }

    public void enqueue(int[] animal) {
        deque.add(animal);
    }

    public int[] dequeueAny() {
        if (!deque.isEmpty()) {
            return deque.remove();
        }
        return new int[] {-1, -1};
    }

    public int[] dequeueDog() {
        return dequeue(1);
    }

    public int[] dequeueCat() {
        return dequeue(0);
    }

    public int[] dequeue(int a) {
        int[] ans = new int[] {-1, -1};
        while (!deque.isEmpty()) {
            if (deque.peek()[1] == a) {
                ans = deque.remove();
                if (!deque.isEmpty()) {
                    break;
                }
            }
            assistDeque.add(deque.remove());
        }
        while (!assistDeque.isEmpty()) {
            deque.add(assistDeque.remove());
        }
        return ans;
    }
}

class AnimalShelf1 {
    private Deque<int[]> dequeCat;
    private Deque<int[]> dequeDog;

    public AnimalShelf1() {
        dequeCat = new ArrayDeque<>();
        dequeDog = new ArrayDeque<>();
    }

    public void enqueue(int[] animal) {
        if (animal[1] == 0) {
            dequeCat.add(animal);
        } else {
            dequeDog.add(animal);
        }
    }

    public int[] dequeueAny() {
        if (!dequeCat.isEmpty() || !dequeDog.isEmpty()) {
            if (dequeCat.isEmpty()) {
                return dequeDog.remove();
            }
            if (dequeDog.isEmpty()) {
                return dequeCat.remove();
            }
            if (dequeCat.peek()[0] < dequeDog.peek()[0]) {
                return dequeCat.remove();
            } else {
                return dequeDog.remove();
            }
        }
        return new int[] {-1, -1};
    }

    public int[] dequeueDog() {
        if (!dequeDog.isEmpty()) {
            return dequeDog.remove();
        }
        return new int[] {-1, -1};
    }

    public int[] dequeueCat() {
        if (!dequeCat.isEmpty()) {
            return dequeCat.remove();
        }
        return new int[] {-1, -1};
    }
}

class AnimalShelf2 {
    private Deque<int[]> deque;

    public AnimalShelf2() {
        deque = new ArrayDeque<>();
    }

    public void enqueue(int[] animal) {
        deque.add(animal);
    }

    public int[] dequeueAny() {
        if (!deque.isEmpty()) {
            return deque.remove();
        }
        return new int[] {-1, -1};
    }

    public int[] dequeueDog() {
        return dequeue(1);
    }

    public int[] dequeueCat() {
        return dequeue(0);
    }

    public int[] dequeue(int a) {
        if (!deque.isEmpty()) {
            for (int[] animal : deque) {
                if (animal[1] == a) {
                    deque.remove(animal);
                    return animal;
                }
            }
        }
        return new int[] {-1, -1};
    }
}