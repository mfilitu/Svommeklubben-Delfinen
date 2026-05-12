package Code;

import java.util.ArrayList;

public class Tournament {
    private String name;
    private String date;
    private String time;
    private ArrayList<String> competitors;
    private ArrayList<String> results;

    public Tournament(String name, String date, String time, ArrayList<String> results) {
        this.name = name;
        this.date = date;
        this.time = time;
        this.competitors = new ArrayList<>();
        this.results = results;
    }

    public void addCompetitor(String competitor) {
        competitors.add(competitor);
    }

    public void addResult(String result) {
        results.add(result);
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public ArrayList<String> getCompetitors() {
        return competitors;
    }

    public ArrayList<String> getResults() {
        return results;
    }
}
