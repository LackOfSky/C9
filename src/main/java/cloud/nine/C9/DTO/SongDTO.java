package cloud.nine.C9.DTO;

import cloud.nine.C9.Model.Song;
import cloud.nine.C9.Model.SongData;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

public class SongDTO {
    @Getter @Setter
    @JsonProperty("id")
    private long id;
    @Getter @Setter
    @JsonProperty("song_name")
    private String song_name;
    @Getter @Setter
    @JsonProperty("author")
    private String author;
    @Getter @Setter
    @JsonProperty("lyrics")
    private String lyrics;
    @Getter @Setter
    @JsonProperty("file")
    private byte[] file;

    public Song getSong(){
        SongData data = new SongData(lyrics,file);
        return new Song(id,song_name,author,data);
    }
}
