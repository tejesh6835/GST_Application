package com.app.boot.gst.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
public class NotesAndTerms {
    @Id
    private Long notesAndTermsId;
    private String notes;
}
