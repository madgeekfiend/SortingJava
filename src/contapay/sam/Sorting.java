package contapay.sam;

import contapay.sam.thirdparty.StopWatch;
import sun.tools.jar.Main;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Sorting {

    	/**
	 * Sort the array by using bubble sort. Compare 2 elements in the array and swap it out.
	 *
	 * @param unsorted Array to sort
	 * @return The sorted array int[]
	 */
	public static int[] bubbleSort( int[] unsorted )
	{
        int[] newarray = unsorted.clone();
		boolean swapped = true;

		while ( swapped )
		{
			swapped = false;
			for ( int x = 0; x < newarray.length; ++x )
			{
				// Iterate and swap
				int storage = 0;
				if ( x != newarray.length - 1 )
				{
					if ( newarray[x] > newarray[x+1] )
					{
						// We need to swap
						storage = newarray[x];
						newarray[x] = newarray[x+1];
						newarray[x+1] = storage;
						swapped = true;
					}
				} // end of out of bounds check
			} // end of for loop
		} // end of while loop

		return newarray;
	}

    /**
     * Take an array and sort it using the selection sort algorithm. As defined on Wikipedia:
     *
     * "Selection sort is a sorting algorithm, specifically an in-place comparison sort. It has O(n2) time complexity, making it inefficient on large lists, and generally performs worse than the similar insertion sort. Selection sort is noted for its simplicity, and also has performance advantages over more complicated algorithms in certain situations, particularly where auxiliary memory is limited."
     * http://en.wikipedia.org/wiki/Selection_sort
     *
     * @param shuffled An Array of randomized shuffled
     * @return
     */
    public static int[] selectionsort(int[] shuffled)
    {
        int[] internal = shuffled.clone();
        int minIndex, x, y, storage;

        for ( x = 0; x < internal.length; ++x )
        {
            // Assume min index is one we are on now
            minIndex = x;
            // Now loop through the rest of the array
            for ( y = x + 1; y < internal.length; ++y)
                if ( internal[y] < internal[minIndex] )
                    minIndex = y;

            // Now swap it
            if ( minIndex != x )
            {
                storage = internal[x];
                internal[x] = internal[minIndex];
                internal[minIndex] = storage;
            }
        }
        return internal;
    }

    /**
     * Shuffle an array
     *
     * I copied this function from http://blog.ryanrampersad.com/2008/10/13/shuffle-an-array-in-java/
     *
     * @param unshuffled array before being shuffled
     * @return A shuffled array
     */
    public static int[] shuffleArray( int[] unshuffled ) {
        Random rgen = new Random();

        for (int i=0; i < unshuffled.length; i++) {
            int randomPosition = rgen.nextInt(unshuffled.length);
            int temp = unshuffled[i];
            unshuffled[i] = unshuffled[randomPosition];
            unshuffled[randomPosition] = temp;
        }
        return unshuffled;
    }

    public static void main(String[] args) {
        System.out.println("Testing sorting stuff");
        int[] array = new int[10000];
        StopWatch sw = new StopWatch();

        for( int x = 0; x < array.length; ++x )
        {
            array[x] = x;
        }
        System.out.println("Array is: " + Arrays.toString( array ));

        int[] shuffled = Sorting.shuffleArray( array );
        System.out.println("Shuffled array: " + Arrays.toString(shuffled));
        sw.start();
        System.out.println("Bubblesort: " + Arrays.toString(Sorting.bubbleSort(shuffled)));
        sw.stop();
        System.out.println("Time to run Bubble sort: " + sw.getElapsedTime());

        sw.start();
        Sorting.selectionsort(shuffled);
        sw.stop();
        System.out.println("Time Selection Sort: " + sw.getElapsedTime() );


    }
}
