package io.pivotal.pal.tracker;

import java.util.*;

public class InMemoryTimeEntryRepository implements TimeEntryRepository{

    private TimeEntry timeEntry;
    Map<Long, TimeEntry> allEntries = new HashMap<Long, TimeEntry>();
    long idCounter = 1L;

    public TimeEntry create(TimeEntry timeEntry) {
        this.timeEntry = timeEntry;
        timeEntry.setId(idCounter);
        allEntries.put(idCounter,timeEntry);
        idCounter+=1l;
        return timeEntry;
    }


    public TimeEntry find(long timeEntryId) {
        return allEntries.get(timeEntryId);
    }


    public List<TimeEntry> list() {

        return new ArrayList<TimeEntry>(allEntries.values());
    }


    public TimeEntry update(long id, TimeEntry updated) {
        updated.setId(id);
        allEntries.put(id,updated);
        return allEntries.get(id);
    }

    public void delete(long timeEntryId) {
        allEntries.remove(timeEntryId);
    }
}
