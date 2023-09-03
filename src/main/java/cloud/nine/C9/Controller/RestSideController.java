package cloud.nine.C9.Controller;


import cloud.nine.C9.Model.Song;
import cloud.nine.C9.Service.SongService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.juli.logging.Log;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RestSideController {

    SongService songService;
    public RestSideController(SongService songService){
        this.songService = songService;
    }
    @GetMapping("/songs")
    public String getSongs(){
        try {
            return songService.readSongs();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "Something went wrong";
        }
    }
    @PostMapping("/save")
    public String saveSong(@RequestBody String JSong) throws JsonProcessingException {
        songService.createSong(JSong);
        return "its ok";
    }

}
