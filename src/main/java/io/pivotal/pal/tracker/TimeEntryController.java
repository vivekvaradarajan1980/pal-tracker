package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.util.List;


@RestController
public class TimeEntryController  {

    private TimeEntryRepository timeEntryRepository;



    public TimeEntryController(TimeEntryRepository timeEntryRepository){
       this.timeEntryRepository= timeEntryRepository;
    }

    @DeleteMapping("/time-entries/{timeEntryId}")
    public ResponseEntity<Void> delete(@PathVariable long timeEntryId) {

        this.timeEntryRepository.delete(timeEntryId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/time-entries/{timeEntryId}")
    public ResponseEntity<TimeEntry> update(@PathVariable  long timeEntryId, @RequestBody  TimeEntry timeEntryToUpdate) {
       TimeEntry obj= this.timeEntryRepository.update(timeEntryId,timeEntryToUpdate);
       if(obj!=null)
        return ResponseEntity.ok().body(obj);
       else
           return ResponseEntity.notFound().build();
    }

    @PostMapping("/time-entries")
    public ResponseEntity<TimeEntry> create(@RequestBody TimeEntry timeEntryToCreate) {
       TimeEntry obj=  this.timeEntryRepository.create(timeEntryToCreate);
        return ResponseEntity.status(HttpStatus.CREATED).body(obj);
    }

    @GetMapping("/time-entries/{id}")
    public ResponseEntity<TimeEntry> read(@PathVariable  long id) {

        TimeEntry obj=this.timeEntryRepository.find(id);
        if(obj!=null)
            return ResponseEntity.ok().body(obj);
        else return ResponseEntity.notFound().build();
    }

    @GetMapping("/time-entries")
    public ResponseEntity<List<TimeEntry>> list() {
      List<TimeEntry> timeEntryList =  this.timeEntryRepository.list();
      if(timeEntryList!=null)
        return ResponseEntity.ok().body(timeEntryList);
      else
          return ResponseEntity.notFound().build();

    }

}
