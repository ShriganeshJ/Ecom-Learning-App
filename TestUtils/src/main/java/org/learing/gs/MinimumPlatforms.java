package org.learing.gs;

import java.util.Arrays;

public class MinimumPlatforms {

    public static int findMinPlatforms(int[] arrivals, int[] departures) {
        Arrays.sort(arrivals);
        Arrays.sort(departures);

        int platformsNeeded = 0;
        int minPlatforms = 0;
        int i = 0; // pointer for arrivals
        int j = 0; // pointer for departures

        while (i < arrivals.length && j < departures.length) {
            if (arrivals[i] <= departures[j]) {
                // A train has arrived and is occupying a platform
                platformsNeeded++;
                i++;
            } else {
                // A train has departed, and a platform is freed up
                platformsNeeded--;
                j++;
            }

            // Update the minimum platforms needed
            minPlatforms = Math.max(minPlatforms, platformsNeeded);
        }

        return minPlatforms;
    }

    public static void main(String[] args) {
        int[] arrivals = {100, 140, 150, 200, 215, 400};
        int[] departures = {110, 300, 220, 230, 315, 600};

        int minPlatforms = findMinPlatforms(arrivals, departures);
        System.out.println("Minimum platforms needed: " + minPlatforms);
    }
}