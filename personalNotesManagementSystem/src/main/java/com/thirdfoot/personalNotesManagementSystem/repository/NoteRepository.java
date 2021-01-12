package com.thirdfoot.personalNotesManagementSystem.repository;

import com.thirdfoot.personalNotesManagementSystemModels.Model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note,Integer> {

    @Modifying(clearAutomatically = true)
    @Query("update Note set isArchived=?2 where userId=?1")
    void isArchived(int id, boolean isArchive);

    List<Note> findAllByUserId(int userId);
}
