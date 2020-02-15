// https://leetcode.com/problems/filter-restaurants-by-vegan-friendly-price-and-distance/
// algorithms
// Medium (52.46%)
// Total Accepted: 6,294
// Total Submissions: 11,998
// beats 100.0% of java submissions


class Solution {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        ArrayList<Restaurant> l = new ArrayList<>();

        for (int i = 0; i < restaurants.length; i++) {
            if (veganFriendly == 1 && restaurants[i][2] == 0) {
                continue;
            }
            if (restaurants[i][3] > maxPrice) {
                continue;
            }
            if (restaurants[i][4] > maxDistance) {
                continue;
            }

            l.add(new Restaurant(restaurants[i][0], restaurants[i][1]));
        }

        Collections.sort(l);

        List<Integer> res = new ArrayList<>();
        for (Restaurant r : l) {
            res.add(r.getId());
        }

        return res;
    }

    class Restaurant implements Comparable<Restaurant> {
        int id;
        int rating;

        Restaurant(int id, int rating) {
            this.id = id;
            this.rating = rating;
        }

        public int getId() {
            return this.id;
        }

        @Override
        public int compareTo(Restaurant r) {
            if (this.rating > r.rating) {
                return -1;
            } else if (this.rating < r.rating) {
                return 1;
            }

            return this.id > r.id ? -1 : 1;
        }
    }
}