// https://leetcode-cn.com/problems/animal-shelter-lcci/
// algorithms
// Easy (59.01%)
// Total Accepted: 969
// Total Submissions: 1,642


class AnimalShelf {
    
    private static final int CAT = 0;
    private static final int DOG = 1;
    private LinkedList<Integer> catQueue;
    private LinkedList<Integer> dogQueue;

    public AnimalShelf() {
        this.catQueue = new LinkedList<>();
        this.dogQueue = new LinkedList<>();
    }
    
    public void enqueue(int[] animal) {
        if (animal[1] == CAT) {
            catQueue.offerLast(animal[0]);
        } else {
            dogQueue.offerLast(animal[0]);
        }
    }
    
    public int[] dequeueAny() {
        if (dogQueue.isEmpty()) {
            return dequeueCat();
        } else if (catQueue.isEmpty()) {
            return dequeueDog();
        }
        
        int dogNum = dogQueue.peekFirst();
        int catNum = catQueue.peekFirst();
        if (catNum <= dogNum) {
            return dequeueCat();
        }
        
        return dequeueDog();
    }
    
    public int[] dequeueDog() {
        if (!dogQueue.isEmpty()) {
            int dogNum = dogQueue.pollFirst();
            return new int[]{dogNum, DOG};
        }
        
        return new int[]{-1, -1};
    }
    
    public int[] dequeueCat() {
        if (!catQueue.isEmpty()) {
            int catNum = catQueue.pollFirst();
            return new int[]{catNum, CAT};
        }
        
        return new int[]{-1, -1};
    }
}

/**
 * Your AnimalShelf object will be instantiated and called as such:
 * AnimalShelf obj = new AnimalShelf();
 * obj.enqueue(animal);
 * int[] param_2 = obj.dequeueAny();
 * int[] param_3 = obj.dequeueDog();
 * int[] param_4 = obj.dequeueCat();
 */