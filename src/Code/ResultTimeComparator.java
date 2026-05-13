package Code;

import java.util.Comparator;

public class ResultTimeComparator implements Comparator<Result> {
    public int compare(Result a, Result b) {
        return Integer.compare(a.getTime(), b.getTime());
    }
}
