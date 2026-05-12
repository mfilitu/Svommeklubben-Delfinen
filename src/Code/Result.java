package Code;

public class Result {
    private Member member;
    private SwimmingDiscipline discipline;
    private int timeMilliseconds;

    public Result(Member member, SwimmingDiscipline discipline, int timeMilliseconds) {
        this.member = member;
        this.discipline = discipline;
        this.timeMilliseconds = timeMilliseconds;
    }


    public Member getMember() {
        return member;
    }

    public SwimmingDiscipline getDiscipline() {
        return discipline;
    }

    public int getTime() {
        return timeMilliseconds;
    }


    public int getTimeMilliseconds() {
        return timeMilliseconds;
    }

    @Override
    public String toString() {
        return member + " - " + discipline + " - " + timeMilliseconds + " ms";
    }
}



