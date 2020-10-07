// https://leetcode.com/problems/design-parking-system/
// algorithms
// Easy (82.76%)
// Total Accepted: 7,051
// Total Submissions: 8,520
// beats 100.0% of java submissions


class ParkingSystem {

    private int bigNum;

    private int mediumNum;

    private int smallNum;

    public ParkingSystem(int big, int medium, int small) {
        this.bigNum = big;
        this.mediumNum = medium;
        this.smallNum = small;
    }

    public boolean addCar(int carType) {
        if (carType == 1) {
            if (bigNum <= 0) {
                return false;
            }
            bigNum--;
            return true;
        } else if (carType == 2) {
            if (mediumNum <= 0) {
                return false;
            }
            mediumNum--;
            return true;
        } else {
            if (smallNum <= 0) {
                return false;
            }
            smallNum--;
            return true;
        }
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small); boolean param_1 =
 * obj.addCar(carType);
 */