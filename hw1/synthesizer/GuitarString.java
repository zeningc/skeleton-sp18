//package <package name>;
package synthesizer;

import java.util.HashSet;
import java.util.Set;

//Make sure this class is public
public class GuitarString {
    /**
     * Constants. Do not change. In case you're curious, the keyword final means
     * the values cannot be changed at runtime. We'll discuss this and other topics
     * in lecture on Friday.
     */
    private static final int SR = 44100;      // Sampling Rate
    private static final double DECAY = .996; // energy decay factor

    /* Buffer for storing sound data. */
    private BoundedQueue<Double> buffer;

    /* Create a guitar string of the given frequency.  */
    public GuitarString(double frequency) {
        buffer = new ArrayRingBuffer<>((int) Math.round(SR / frequency));
        while (!buffer.isFull()) {
            buffer.enqueue(0.0);
        }
    }


    /* Pluck the guitar string by replacing the buffer with white noise. */
    public void pluck() {
        //       Make sure that your random numbers are different from each other.
        Set<Double> d = new HashSet<>();
        if (buffer.isEmpty()) {
            return;
        }
        int c = buffer.fillCount();
        double r;
        while (c > 0) {
            buffer.dequeue();
            r = Math.random() - 0.5;
            while (d.contains(r)) {
                r = Math.random() - 0.5;
            }
            d.add(r);
            buffer.enqueue(r);
            c--;
        }
    }

    /* Advance the simulation one time step by performing one iteration of
     * the Karplus-Strong algorithm.
     */
    public void tic() {
        double d, p;
        d = buffer.dequeue();
        p = buffer.peek();
        buffer.enqueue(.998 * (d + p) / 2);
    }

    /* Return the double at the front of the buffer. */
    public double sample() {
        return buffer.peek();
    }
}
