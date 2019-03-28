package java8;

public class StaffPublic {
    private String name;
    private String extra;
    private Integer score;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "StaffPublic{" +
                "name='" + name + '\'' +
                ", extra='" + extra + '\'' +
                ", score=" + score +
                '}';
    }
}
