package cloud.nine.C9.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    @JsonProperty("id")
    private int id;

    @Getter @Setter
    @Column(name = "song_name", nullable = false)
    @JsonProperty("song_name")
    private String name;

    @Getter @Setter
    @Column(name = "author", nullable = false)
    @JsonProperty("author")
    private String author;

    @Getter @Setter
    @Column(name = "text", nullable = false)
    @JsonProperty("text")
    private String text;

    @Getter @Setter
    @Column(name = "file", nullable = false)
    @JsonProperty("file")
    private byte[] file;


}
