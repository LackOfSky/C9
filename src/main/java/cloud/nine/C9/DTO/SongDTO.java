package cloud.nine.C9.DTO;

import cloud.nine.C9.Model.Song;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;

public class SongDTO {
    private static SongDTO songDTO;
    ObjectMapper objectMapper = new ObjectMapper();

    private SongDTO(){}
    public String toJSON(Song song) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return  objectMapper.writeValueAsString(song);
    }
    public String toJSON(ArrayList<Song> songs) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(songs);
    }
    public Song toObject(String json) throws JsonProcessingException {
        return objectMapper.readValue(json, Song.class);
    }
    public static SongDTO getInstance(){
        return (songDTO != null)?
                songDTO : new SongDTO();
    }
}
