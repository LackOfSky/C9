package cloud.nine.C9.Controller;

import cloud.nine.C9.Service.SongService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    SongService songService;
    public HomeController(SongService songService){
        this.songService = songService;
    }
    @GetMapping("*")
        public String getSongs(Model model) throws JsonProcessingException {
            model.addAttribute(songService.readSongs());

        return
        }
}
