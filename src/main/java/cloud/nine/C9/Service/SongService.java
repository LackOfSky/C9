package cloud.nine.C9.Service;

import cloud.nine.C9.DTO.SongTransfer;
import cloud.nine.C9.Model.Song;
import cloud.nine.C9.Model.SongData;
import cloud.nine.C9.Repository.SongDataRepository;
import cloud.nine.C9.Repository.SongRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SongService {

    private SongRepository songRepository;
    private SongDataRepository songDataRepository;
    private SongTransfer songTransfer;

    public SongService(SongRepository songRepository,SongDataRepository songDataRepository) {
        this.songRepository = songRepository;
        this.songDataRepository = songDataRepository;
        songTransfer = SongTransfer.getInstance();
    }

    public boolean createSong(String Jsong) throws EntityNotFoundException, JsonProcessingException {
        songRepository.save(
                getSong(songTransfer.songToObject(Jsong))
        );
        return true;
    }
    public boolean updateSong(String Jsong) throws EntityNotFoundException, JsonProcessingException {
        songRepository.save(
                getSong(songTransfer.songToObject(Jsong))
        );
        return true;
    }
    public boolean deleteSong(long id)throws EntityNotFoundException{
        songRepository.delete(
                readSong(id)
        );
        return true;
    }

    public String readSongData(long id) throws EntityNotFoundException, JsonProcessingException {
        return songTransfer.songDataToJSON(
                songDataRepository.findById(id).orElseThrow(
                        () -> new EntityNotFoundException("Entity by id "+id+" is not exist")
                )
        );
    }
    public String readSongs() throws JsonProcessingException {
        return songTransfer.songsToJSON(
                (ArrayList<Song>) songRepository.findAll());
    }

    private Song getSong(Song song){
        if(song == null){
            throw new EntityNotFoundException(
                    "An error occurred while adding/changing a value");
        }
        return song;
    }
    public Song readSong(long id) throws EntityNotFoundException {
        return songRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Entity by id "+id+" is not exist")
        );
    }
}
