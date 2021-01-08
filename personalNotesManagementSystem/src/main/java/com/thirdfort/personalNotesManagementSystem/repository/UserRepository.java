package com.thirdfort.personalNotesManagementSystem.repository;

import com.thirdfort.personalNotesManagementSystemModels.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
}
