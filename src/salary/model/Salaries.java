package salary.model;

import java.time.LocalDate;

/**
 * Created by danawacomputer on 2017-04-20.
 */
public class Salaries {

    // 필드
    private LocalDate yearID;
    private String teamID;
    private String lgID;
    private String playerID;
    private int salary;

    // 생성자
    public Salaries() {
    }

    public Salaries(LocalDate yearID, String teamID, String lgID, String playerID, int salary) {
        this.yearID = yearID;
        this.teamID = teamID;
        this.lgID = lgID;
        this.playerID = playerID;
        this.salary = salary;
    }

    // 메소드
    public LocalDate getYearID() {
        return yearID;
    }

    public void setYearID(LocalDate yearID) {
        this.yearID = yearID;
    }

    public String getTeamID() {
        return teamID;
    }

    public void setTeamID(String teamID) {
        this.teamID = teamID;
    }

    public String getLgID() {
        return lgID;
    }

    public void setLgID(String lgID) {
        this.lgID = lgID;
    }

    public String getPlayerID() {
        return playerID;
    }

    public void setPlayerID(String playerID) {
        this.playerID = playerID;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Salaries{" +
                "yearID=" + yearID +
                ", teamID='" + teamID + '\'' +
                ", lgID='" + lgID + '\'' +
                ", playerID='" + playerID + '\'' +
                ", salary=" + salary +
                '}';
    }
}
