package cloud.nine.C9.Service;

import cloud.nine.C9.DTO.SongDTO;
import cloud.nine.C9.Model.Song;
import cloud.nine.C9.Repository.SongRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class SongService {

    private SongRepository songRepository;
    private SongDTO songDTO;

    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
        songDTO = SongDTO.getInstance();
    }

    public boolean createSong(String Jsong) throws EntityNotFoundException, JsonProcessingException {
        songRepository.save(
                getSong(songDTO.toObject(Jsong))
        );
        return true;
    }
    public boolean updateSong(String Jsong) throws EntityNotFoundException, JsonProcessingException {
        songRepository.save(
                getSong(songDTO.toObject(Jsong))
        );
        return true;
    }
    public boolean deleteSong(long id)throws EntityNotFoundException{
        songRepository.delete(
                readSong(id)
        );
        return true;
    }
    public Song readSong(long id) throws EntityNotFoundException {
        return songRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Entity by id "+id+" is not exist")
        );
    }
    public String readSongs() throws JsonProcessingException {
        return songDTO.toJSON(
                (ArrayList<Song>) songRepository.findAll());
    }

    private Song getSong(Song song){
        if(song == null){
            throw new EntityNotFoundException(
                    "An error occurred while adding/changing a value");
        }
        return song;
    }

}
