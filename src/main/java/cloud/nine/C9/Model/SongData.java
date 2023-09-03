package cloud.nine.C9.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class SongData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    @Getter @Setter
    private long id;
    @Getter @Setter
    @OneToOne
    @JoinColumn(name = "song_id")
    private Song song;
    @Getter @Setter
    @Column(name = "file", nullable = false)
    @JsonProperty("file")
    private byte[] file;

    @Getter @Setter
    @Column(name = "lyrics", nullable = false)
    @JsonProperty("lyrics")
    private String lyrics;

    public SongData(String lyrics,byte[] file){
        this.lyrics=lyrics;
        this.file=file;
    }
    public SongData(){}
}
