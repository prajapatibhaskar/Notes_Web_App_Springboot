package com.bhaskar.practiceSpring.documents;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@Getter
@Setter
@Document(collection = "users")
public class User {
    String id;
    String username;
    String password;
}
