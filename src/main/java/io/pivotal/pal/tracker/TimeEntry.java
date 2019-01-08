package io.pivotal.pal.tracker;

import java.time.LocalDate;
import java.util.Objects;


public class TimeEntry {


    private long projectId;
    private long userId;
    private LocalDate date;
    private int hours;
    private long id;

    public void setId(long id){
        this.id = id;
    }

    public TimeEntry(long projectId, long userId, LocalDate parse, int hour) {

        this.projectId = projectId;
        this.userId = userId;
        this.date = parse;
        this.hours = hour;
    }

    public TimeEntry(long id, long projectId, long userId, LocalDate parse, int hour) {

        this.id = id;
        this.projectId = projectId;
        this.userId = userId;
        this.date = parse;
        this.hours = hour;
    }

    public TimeEntry() {
         projectId = 0;
        userId = 0;
        date = null;
        hours=0;
         id =0l ;
    }


    public long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimeEntry timeEntry = (TimeEntry) o;
        return projectId == timeEntry.projectId &&
                userId == timeEntry.userId &&
                hours == timeEntry.hours &&
                id == timeEntry.id &&
                date.equals(timeEntry.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectId, userId, date, hours, id);
    }


    @Override
    public String toString() {
        return "TimeEntry{" +
                "projectId=" + projectId +
                ", userId=" + userId +
                ", parse=" + date +
                ", hour=" + hours +
                ", id=" + id +
                '}';
    }

    public long getProjectId() {
        return projectId;
    }

    public long getUserId() {
        return userId;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getHours() {  
        return hours;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setHours(int hour) {
        this.hours = hour;
    }
}


