package at.fhtw.swkom.paperless.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Home redirection to OpenAPI api documentation
 */
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Controller
public class HomeController {
    @RequestMapping("/")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public String index() {
        return "redirect:swagger-ui.html";
    }

}