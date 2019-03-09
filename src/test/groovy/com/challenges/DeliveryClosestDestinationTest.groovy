package com.challenges

import spock.lang.Specification

/*
Amazon Fresh is a grocery delivery service that offers consumers the option of purchasing their groceries online and schedule future deliveries of purchased groceries.
Amazon's backend system dynamically tracks each Amazon Fresh delivery truck and automatically assigns the next deliveries in a truck's plan.
To accomplish this, the system generates an optimized delivery plan with X destinations.
The most optimized plan would deliver to the closest X destinations from the start among all of the possible destinations in the plan.

Given an array of N possible delivery destinations, implement an algorithm to create the delivery plan for the closest X destinations.
 */

/*
3 SOLUTIONS to find the k smallest items:

1- Sorting: O(nlogn)
2- Selection Sort: O(nk)
3- Max Heap: runtime for the entire solution: O(k + (n-k) logk) -> max heap will be an efficient way to keep track of the largest value in the collection [][]
    [4,1,5]: 1- create a max heap with k items takes Big O(k) to find the largest value
             2- replace the current largest number in the given heap, to rearrange: 4,1,3 then will take Big O(logk) where k number of items in the heap
             3- print all the items in the given heap in the order that is not necessary sorted (ex: 4,1,3), it takes Big O(k) time.
 */

class DeliveryClosestDestinationTest extends Specification {

    def "Should calculate 2 closest delivery Plan"(){

        given: "3 destinations for the truck, allocated points with coordinates = [[1, 2], [3, 4], [1, -1]] and 2 deliveries"

            List<List<Integer>> points = [[1, 2], [3, 4], [1, -1]];
            Integer totalNumPossibleDestinations = points.size();
            Integer numDeliveriesInPlanX = 2;

        when: "Call Service"

            def closestXDestination = DeliveryService.closestXDestinations(totalNumPossibleDestinations, points, numDeliveriesInPlanX);

        then: "The 2 closest delivery destinations will be = [[1, -1], [1, 2]]"

            [[1, -1], [1, 2]] == closestXDestination;
    }

    def "Should calculate 3 closest delivery Plan"(){

        given: "5 destinations for the truck, allocated points with coordinates = [[1, 2], [3, 4], [1, -1], [5,5], [0,0]]; and 3 deliveries"

            List<List<Integer>> points = [[1, 2], [3, 4], [1, -1], [5,5], [0,0]];
            Integer totalNumPossibleDestinations = points.size();
            Integer numDeliveriesInPlanX = 3;

        when: "Call Service"

            def closestXDestination = DeliveryService.closestXDestinations(totalNumPossibleDestinations, points, numDeliveriesInPlanX);

        then: "The 2 closest delivery destinations will be = [[0, 0], [1, -1], [1, 2]"

            [[0, 0], [1, -1], [1, 2]] == closestXDestination
    }

    def "Should not throw error if coordinates are empty"(){

        given: "empty coordinates"

            List<List<Integer>> points = [][];
            Integer totalNumPossibleDestinations = 0;
            Integer numDeliveriesInPlanX = 0;

        when: "Call Service"

            def closestXDestination = DeliveryService.closestXDestinations(totalNumPossibleDestinations, points, numDeliveriesInPlanX);

        then: "The receive empty result"

            closestXDestination.isEmpty();
    }

}

class DeliveryService {
    static Integer valMultiplied = 0;
    static Integer pointX = 0, pointY = 0;

    static List<List<Integer>> closestXDestinations(Integer numDestinations,  List<List<Integer>> allLocations, Integer numDeliveries){

        //TreeMap provides guaranteed log(n) time cost for the containsKey, get, put and remove operations.
        TreeMap<Double, List<Integer>> sortedMap = new TreeMap<>();

        for (int i = 0; i < allLocations.size(); i++) {

            List<Integer> location = allLocations.get(i);

            if (!location.isEmpty()) {

                if (location.size() == 1) {
                    pointX = ((Integer) location.get(0)).intValue();
                    pointY = 0;
                } else if (location.size() == 2) {
                    pointX = ((Integer) location.get(0)).intValue();
                    pointY = ((Integer) location.get(1)).intValue();
                }

                valMultiplied = pointX * pointX + pointY * pointY;

                double sqrtResult = Math.sqrt(valMultiplied);

                //log(n)
                sortedMap.put(sqrtResult, location);

            }

        }

        ArrayList<List<Integer>> locationsSorted = new ArrayList<>(sortedMap.values());

        while (locationsSorted.size() > numDeliveries) {
            locationsSorted.remove(locationsSorted.size() - 1);
        }

        return locationsSorted;
    }

}
