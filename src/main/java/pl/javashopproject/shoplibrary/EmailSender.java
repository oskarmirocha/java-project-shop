package pl.javashopproject.shoplibrary;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class EmailSender {

    @Autowired
    private EmailSenderConfig senderConfig;

    @GetMapping(value = "/simple-email/{user-email}")
    public @ResponseBody ResponseEntity sendSimpleEmail(@PathVariable("user-email") String email) {
            senderConfig.sendSimpleEmail(email, "Welcome", "This is a welcome email for your!!");

             return new ResponseEntity<>("Please check your inbox", HttpStatus.OK);
    }
}
