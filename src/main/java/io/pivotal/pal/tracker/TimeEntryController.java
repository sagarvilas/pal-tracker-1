package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class TimeEntryController {

    @Autowired
    private TimeEntryRepository timeEntryRepository;

    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository = timeEntryRepository;
    }

    @PostMapping("/time-entries")
    public ResponseEntity<TimeEntry> create(@RequestBody TimeEntry timeEntryToCreate) {
        TimeEntry timeEntry = this.timeEntryRepository.create(timeEntryToCreate);
        return  new ResponseEntity<TimeEntry>(timeEntry,HttpStatus.CREATED );
    }

    @GetMapping("/time-entries/{timeEntryId}")
    public ResponseEntity<TimeEntry> read(@PathVariable long timeEntryId) {
        TimeEntry timeEntry = this.timeEntryRepository.find(timeEntryId);
        if(timeEntry != null){
            return  new ResponseEntity<TimeEntry>(timeEntry,HttpStatus.OK );
        }
        return  new ResponseEntity<TimeEntry>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/time-entries")
    public ResponseEntity<List<TimeEntry>> list() {

        return  new ResponseEntity<List<TimeEntry>>(this.timeEntryRepository.list(),HttpStatus.OK );
    }

    @PutMapping("/time-entries/{timeEntryId}")
    public ResponseEntity update(@PathVariable long timeEntryId, @RequestBody TimeEntry updated) {
        TimeEntry timeEntry = this.timeEntryRepository.update(timeEntryId, updated);
        if(timeEntry != null){
            return  new ResponseEntity<TimeEntry>(timeEntry,HttpStatus.OK );
        }
        return  new ResponseEntity<TimeEntry>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/time-entries/{timeEntryId}")
    public ResponseEntity<TimeEntry> delete(@PathVariable long timeEntryId) {
        this.timeEntryRepository.delete(timeEntryId);
        return  new ResponseEntity<TimeEntry>(HttpStatus.NO_CONTENT);
    }
}
