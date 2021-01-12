package com.thirdfoot.personalNotesManagementSystemModels.ModelDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoteDto {

    private String title;
    private String description;
    @NonNull
    private int userId;
}
