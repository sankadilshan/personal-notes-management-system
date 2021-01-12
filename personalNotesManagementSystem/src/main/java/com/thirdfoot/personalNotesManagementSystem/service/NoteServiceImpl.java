package com.thirdfoot.personalNotesManagementSystem.service;

import com.thirdfoot.personalNotesManagementSystem.repository.NoteRepository;
import com.thirdfoot.personalNotesManagementSystemModels.Model.Note;
import com.thirdfoot.personalNotesManagementSystemModels.ModelDto.NoteDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Transactional
@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private ModelMapper modelMapper;


    private NoteRepository noteRepository;

    @Autowired
    public NoteServiceImpl(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public Note initiate(NoteDto noteDto, int userId) {
        Note note = modelMapper.map(noteDto, Note.class);
        note.setUserId(userId);
        return noteRepository.save(note);
    }

    @Override
    public Note update(NoteDto noteDto, int noteId) {
        Note note = checkNoteById(noteId);
        if (note != null) {
            Note note1 = modelMapper.map(noteDto, Note.class);
            note1.setId(note.getId());
            note1.setArchived(note.isArchived());
//            noteRepository.deleteById(noteId);
            return noteRepository.save(note1);
        }
        return null;
    }

    @Override
    public boolean archived(int id, boolean isArchive) throws RuntimeException {
        Note note = checkNoteById(id);
        if (isArchive) {
            note.setArchived(isArchive);
            noteRepository.save(note);
            return true;
        }else{
            note.setArchived(isArchive);
            noteRepository.save(note);
            return true;
        }
    }


    @Override
    public List<Note> archiveNotes(int userId) throws RuntimeException {
        return noteRepository.findAllByUserId(userId);

    }

    @Override
    public List<Note> unarchiveNotes(int userId) throws RuntimeException {
        List<Note> notes = noteRepository.findAllByUserId(userId);
        return notes.stream().filter(n -> n.isArchived() == false).collect(Collectors.toList());
    }

    private Note checkNoteById(int id) throws NoSuchElementException {
        Optional<Note> note = noteRepository.findById(id);
        System.out.println(note.get());
        return note.get();
    }


}
