package cloud.nine.C9.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Songs")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    @JsonProperty("id")
    private long id;

    @Getter @Setter
    @Column(name = "song_name", nullable = false)
    @JsonProperty("song_name")
    private String name;

    @Getter @Setter
    @Column(name = "author", nullable = false)
    @JsonProperty("author")
    private String author;

    @OneToOne(mappedBy = "song", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private SongData songData;

    public Song() {}
    public Song(long id, String name, String author, SongData songData){
        this.id = id;
        this.name = name;
        this.author = author;
        this.songData = songData;
        songData.setSong(this);
    }

}
