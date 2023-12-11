package com.bhaskar.practiceSpring.repositories;

import com.bhaskar.practiceSpring.documents.NoteEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface NoteRepository extends MongoRepository<NoteEntity, String> {

    @Query(value = "{'user' : ?0}")
    List<NoteEntity> findAllNotesByUser(String user);

    @Query(value = "{'user' : ?0}", delete = true)
    List<NoteEntity> deleteAllByUsername(String user);
}
