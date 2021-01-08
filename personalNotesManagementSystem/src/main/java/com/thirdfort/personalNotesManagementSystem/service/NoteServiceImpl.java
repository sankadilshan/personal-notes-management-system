package com.thirdfort.personalNotesManagementSystem.service;

import com.thirdfort.personalNotesManagementSystem.repository.NoteRepository;
import com.thirdfort.personalNotesManagementSystemModels.Model.Note;
import com.thirdfort.personalNotesManagementSystemModels.ModelDto.NoteDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Transactional
@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private NoteRepository noteRepository;

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
            Note newNote = new Note();
            newNote.setId(noteId);
            newNote.setUserId(note.getUserId());
            newNote.setDescription(note1.getDescription());
            newNote.setTitle(note1.getTitle());
            newNote.setCreateDate(new Date());
            newNote.setArchived(note.isArchived());
            newNote.setUserId(note.getUserId());
            noteRepository.deleteById(noteId);
            return noteRepository.save(newNote);
        }
        return null;
    }

    @Override
    public boolean archived(int id, boolean isArchive) throws RuntimeException {
        Note note = checkNoteById(id);
        if (note.isArchived())
            note.setArchived(false);
        else
            note.setArchived(true);
        noteRepository.deleteById(id);
        noteRepository.isArchived(id);
        return true;
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

    private Note checkNoteById(int id) {
        Optional<Note> note = noteRepository.findById(id);
        return note.get();
    }


}
