package algoexpert;

import java.util.Stack;

public class ValidStartingCity {
    public static void main(String args[]) {
        int[] dis = {5, 25, 15, 10, 15};
        int[] fuel = {1, 2, 1, 0, 3};
        int mpg = 10;

        // Solution 2 was proposed solution from ALgoExpert
        System.out.println(validStartingCitySol2(dis, fuel, mpg));
    }

    public static int validStartingCity(int[] distances, int[] fuel, int mpg) {
        // Write your code here.
        int distanceLen = distances.length;

        boolean isCycleDone = false;
        int index = -1;
        int k = 0;
        while (k < distanceLen) {
            Stack<Integer> extraGallons = new Stack<>();
            int leftOverIndex = distanceLen - k;
            int startIndex = k;
            for (int i = k; i < distanceLen; i++) {
                int dist = distances[i];
                int fuelAvailable = fuel[i];
                int mileageWithFuelIn = mpg * fuelAvailable;

                int extraFuel = mileageWithFuelIn - dist;

                if (extraFuel < 0) {
                    if (extraGallons.isEmpty()) {
                        break;
                    }
                    while (!extraGallons.isEmpty()) {
                        int gallon = extraGallons.pop();
                        extraFuel += gallon;
                        if (extraFuel > 0) {
                            extraGallons.push(extraFuel);
                        } else if (extraFuel == 0) {
                            break;
                        }
                    }

                } else {
                    extraGallons.push(extraFuel);
                }

                if (i == distanceLen - 1 && leftOverIndex >= 0) {
                    if (startIndex == i) {
                        index = startIndex;
                        break;
                    }
                    distanceLen = leftOverIndex;
                    i = 0;
                }
            }
            k++;
        }
        return index;
    }

    public static int validStartingCitySol2(int[] distances, int[] fuel, int mpg) {
        // Write your code here.
        int len = distances.length;
        int k = 0;
        while(k < len) {
            int milesRemain = 0;
            for(int i = k; i < len ; i++) {
                if(milesRemain < 0) {
                    continue;
                }
                int currentIdx = i % len;
                int fuelValue = fuel[currentIdx];
                int distValue = distances[currentIdx];

                milesRemain += fuelValue * mpg - distValue;
            }

            if(milesRemain >= 0 ) {
                return k;
            }
            k++;
        }
        return -1;
    }
}
