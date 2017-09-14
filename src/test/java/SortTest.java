import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class SortTest {
    private void assertSorts(List<Integer> unsorted, List<Integer> sorted) {
        assertThat(sort(unsorted), is(sorted));
    }

    private void assertSortsBigList(int n) {
        List<Integer> unsorted = new ArrayList<>();
        for (int i = 0; i < n; i++)
            unsorted.add((int) (Math.random() * 10000));
        List<Integer> sorted = sort(unsorted);
        for (int i = 0; i < sorted.size() - 1; i++)
            assertTrue(sorted.get(i) <= sorted.get(i + 1));
    }

    private List<Integer> intList(Integer... ints) {
        return Arrays.asList(ints);
    }

    @Test
    public void sort() throws Exception {
        assertSorts(intList(), intList());
        assertSorts(intList(1), intList(1));
        assertSorts(intList(2, 1), intList(1, 2));
    }

    private List<Integer> sort(List<Integer> list) {
        if (list.size() <= 1)
            return list;

        if (list.get(0) > list.get(1)) {
            int t = list.get(0);
            list.set(0, list.get(1));
            list.set(1, t);
        }

        return list;
    }
}
