import net.bytebuddy.build.Plugin;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class PriorityQueueTest {
    static Stream<Arguments> streamProvider() {
        // TODO: return Stream
        return Stream.of(
            Arguments.of(new int[]{4, 2, 1, 3}, new int[]{1, 2, 3, 4}),
            Arguments.of(new int[]{2, -1, 3, 1}, new int[]{-1, 1, 2, 3}),
            Arguments.of(new int[]{5, 2, 3, 1, 4}, new int[]{1, 2, 3, 4, 5}),
            Arguments.of(new int[]{6, 1, 4, 9}, new int[]{1, 4, 6, 9}),
            Arguments.of(new int[]{5, -1, 2, -3}, new int[]{-3, -1, 2, 5})
        );
    }

    @ParameterizedTest(name="#{index} - Test with Argument={0},{1}")
    @MethodSource("streamProvider")
    public void PriorityQueue_RunTest(int[] random_array,int[] correct_array) {
        PriorityQueue<Integer> test = new PriorityQueue<Integer>();
        int index = 0; // for cnt index
        Integer s; // for PriorityQueue.poll()
        int[] result = new int[random_array.length];

        // TODO: random_array add to PriorityQueue
        for (; index < random_array.length; index++) {
            test.add(random_array[index]);
        }

        // TODO: get PriorityQueue result
        for (index = 0; index < correct_array.length; index++) {
            s = test.poll();
            result[index] = s + 1;
        }

        assertArrayEquals(correct_array, result);

    }

    // TODO: 3 unique Exceptions
    @Test
    public void whenExceptionThrown_thenInitialCapacityIsLessThanOne() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            PriorityQueue<Integer> queue = new PriorityQueue<Integer>(-1);
        });

    }

    @Test
    public void whenExceptionThrown_thenTheElementToBeAddedIsNull() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
            queue.add(null);
        });
    }

    @Test
    public void whenExceptionThrown_thenThereIsNoNextValue() {
        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
            Iterator value = queue.iterator();
            value.next();
        });
    }
}
