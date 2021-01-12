package com.thirdfoot.personalNotesManagementSystem.controller;

import com.thirdfoot.personalNotesManagementSystem.service.NoteService;
import com.thirdfoot.personalNotesManagementSystemModels.Model.Note;
import com.thirdfoot.personalNotesManagementSystemModels.ModelDto.NoteDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/notes")
public class NoteController {

    private NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/health")
    public String health() {
        return "up";
    }

    @GetMapping("/{uid}/archive")
    public List<Note> archiveNotes(@PathVariable("uid") int userId) {
        return noteService.archiveNotes(userId);
    }

    @GetMapping("/{uid}/unarchive")
    public List<Note> unarchiveNote(@PathVariable("uid") int userId)throws NullPointerException {
        return noteService.unarchiveNotes(userId);
    }


    @PatchMapping("/{nid}/archive")
    public ResponseEntity<?> archived(@PathVariable("nid") int id, @RequestParam("isArchive") boolean isArchive) {
        boolean archived = noteService.archived(id, isArchive);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }


    @PostMapping("/{id}")
    public ResponseEntity<?> initiate(@RequestBody NoteDto note, @PathVariable("id") int userId) throws Exception {
        Note savedNote = noteService.initiate(note, userId);
        if (savedNote == null)
            return new ResponseEntity<>("failed", HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }

    @PutMapping("/{nid}")
    public ResponseEntity<?> updateNote(@RequestBody NoteDto note, @PathVariable("nid") int noteId) {
        Note updatedNote = noteService.update(note, noteId);
        if (updatedNote != null)
            return new ResponseEntity<>("success", HttpStatus.OK);
        return new ResponseEntity<>("failed", HttpStatus.BAD_REQUEST);
    }
}
