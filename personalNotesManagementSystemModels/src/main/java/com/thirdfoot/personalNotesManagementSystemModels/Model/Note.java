package com.thirdfoot.personalNotesManagementSystemModels.Model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="note")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String description;
    private Date createDate= new Date();
    private boolean isArchived;
    private int userId;

}
