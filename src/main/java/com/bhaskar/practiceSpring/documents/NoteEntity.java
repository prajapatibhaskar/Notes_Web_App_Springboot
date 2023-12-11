package com.bhaskar.practiceSpring.documents;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@Getter
@Setter
@Document(collection = "notes")
public class NoteEntity {
    String text;
    String id;
    String user;
}
