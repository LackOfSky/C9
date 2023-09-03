package cloud.nine.C9.DTO;

import cloud.nine.C9.Model.Song;
import cloud.nine.C9.Model.SongData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

public class SongTransfer {
    private static SongTransfer songTransfer;
    ObjectMapper objectMapper = new ObjectMapper();

    private SongTransfer(){}
    public String songDataToJSON(SongData songData) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return  objectMapper.writeValueAsString(songData);
    }
    public String songsToJSON(ArrayList<Song> songs) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(songs);
    }
    public Song songToObject(String json) throws JsonProcessingException {
        return objectMapper.readValue(json, SongDTO.class).getSong();
    }

    public static SongTransfer getInstance(){
        return (songTransfer != null)?
                songTransfer : new SongTransfer();
    }
}
