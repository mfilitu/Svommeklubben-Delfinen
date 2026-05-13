package Code;

import java.util.*;
import java.util.stream.Collectors;

public class ResultList {
    private List<Result> results = new ArrayList<>();

    public ResultList() {
    }

    public void addResult(Result result) {
        results.add(result);
    }

    public List<Result> getAllResults() {
        return results;
    }


    public List<Result> getTopFive(SwimmingDiscipline discipline) {
        List<Result> filtered = new ArrayList<>();

        for (Result r : results) {
            if (r.getDiscipline() == discipline) {
                filtered.add(r);
            }
        }
        filtered.sort(new ResultTimeComparator());

        return filtered.subList(0, Math.min(5, filtered.size()));
    }

    @Override
    public String toString() {
        String res = "";
        for (Result result : results){
            res += result.getMember().getName() + " " + result.getTimeMilliseconds() +" ms" + "\n";
        }
        return res;
    }
}



