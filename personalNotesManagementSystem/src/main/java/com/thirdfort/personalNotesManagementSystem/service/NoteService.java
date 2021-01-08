package com.thirdfort.personalNotesManagementSystem.service;

import com.thirdfort.personalNotesManagementSystemModels.Model.Note;
import com.thirdfort.personalNotesManagementSystemModels.ModelDto.NoteDto;

import java.util.List;

public interface NoteService {
    Note initiate(NoteDto note, int userId);

    Note update(NoteDto note, int noteId);

    boolean archived(int id,boolean isArchive);

    List<Note> archiveNotes(int userId);

    List<Note> unarchiveNotes(int userId);
}
