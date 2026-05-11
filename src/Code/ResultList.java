package Code;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ResultList {
    List<Result> results = new ArrayList<>();

    public ResultList(){
    }

    public void addResult(Result result){
        results.add(result);
    }
    public List<Result> getAllResults(){
        return results;
    }

    public List<Result> getTopFive(SwimmingDiscipline discipline){
        return results.stream()
                .filter(r -> r.getDiscipline() == discipline)
                .sorted(Comparator.comparingInt(Result::getTime))
                .limit(5)
                .collect(Collectors.toList());
    }
}



