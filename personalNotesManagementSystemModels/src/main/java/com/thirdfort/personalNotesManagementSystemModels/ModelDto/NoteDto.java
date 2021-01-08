package com.thirdfort.personalNotesManagementSystemModels.ModelDto;

import lombok.Data;
import lombok.NonNull;

@Data
public class NoteDto {

    private String title;
    private String description;
    @NonNull
    private int userId;
}
