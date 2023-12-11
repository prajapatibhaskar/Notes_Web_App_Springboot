package com.bhaskar.practiceSpring.controller;

import com.bhaskar.practiceSpring.documents.NoteEntity;
import com.bhaskar.practiceSpring.repositories.NoteRepository;
import com.bhaskar.practiceSpring.utilities.DateTimeUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class NoteController {

    @Autowired
    private NoteRepository noteRepository;

    @GetMapping("/{user}/getNotes")
    public List<NoteEntity> getNotes(@PathVariable String user) {
        return this.noteRepository.findAllNotesByUser(user);
    }

    @PostMapping("/{user}/addNote")
    public NoteEntity addNote(@RequestBody String body, @PathVariable String user) {
        String id = DateTimeUtility.generateDateTimeId();
        NoteEntity noteEntity = new NoteEntity(body, id, user);
        NoteEntity savedNote = this.noteRepository.save(noteEntity); //saving the NoteEntity object in the List<NoteEntity>
        return savedNote;
    }

    @DeleteMapping("/{user}/deleteNote")
    public List<NoteEntity> delete(@RequestBody String id, @PathVariable String user) {
        this.noteRepository.deleteById(id);
        List<NoteEntity> noteList = this.noteRepository.findAllNotesByUser(user);
        return noteList;
    }

    @PutMapping("/editNote")
    public NoteEntity editNote(@RequestBody NoteEntity obj) {
         NoteEntity noteToEdit = this.noteRepository.findById(obj.getId()).get();
         noteToEdit.setText(obj.getText());
         NoteEntity editedNote = this.noteRepository.save(noteToEdit);
         return editedNote;
    }
}
