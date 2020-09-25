package misc;

import java.io.*;
import java.util.*;

/*

    Asked Oracle Sept 24, 2020
 If the resource usage falls below 25%, we halve the number of VMs. If it goes above 75% we double the number of VMs.
 Between 25-75% no change is needed. Once a change is made to the number of VMs, we ignore the next 3 data points.

 Given the initial number of VMs, and the time-series data, determine the number of VMs at the end of the time
 */

class AutoScale {

    public static int getFinalNumberOfVMs(int initialVMs, int[] td) {

        int index = 0, vms = getVMCount(initialVMs, td[index]), nextIndex = index + 3;
        while (index < td.length) {
            if(index == nextIndex) {
                int newCount = getVMCount(initialVMs, td[index]);
                // once updated ignore next 3 data points
                if(vms != newCount) {
                    nextIndex += 3;
                    vms = newCount;
                } else
                    // if not updated, check on next data point
                    nextIndex++;
            }
            index++;
        }

        return vms;
    }

    private static int getVMCount(int noOfVms, int dataPoint) {
        return dataPoint < 25 ? noOfVms / 2 : (dataPoint > 75) ? noOfVms * 2 : noOfVms;
    }

    public static void main(String[] args) {
        System.out.println(getFinalNumberOfVMs(2, new int[]{20, 40, 45, 90, 92, 40, 90, 80, 40, 45})); //Result= 2
        System.out.println(getFinalNumberOfVMs(4, new int[]{90, 40, 45, 48, 22, 22, 44, 80, 90, 22})); //Result = 8
    }
}