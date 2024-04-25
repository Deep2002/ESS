package com.example.ess;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class EssController {

    private final String fromEmail = "shaktiflowentertainment@gmail.com";

    private final EmailSendingService emailSendingService;

    @Autowired
    public EssController(EmailSendingService emailSendingService) {
        this.emailSendingService = emailSendingService;
    }

    @CrossOrigin(origins = "*")
    @PostMapping("api/ess")
    public Boolean sendEmail(@RequestBody Map<String, String> data) {
        String name = data.get("name");
        String email = data.get("email");
        String phone = data.get("phone");
        String eventType = data.get("eventType");
        String numOfGuests = data.get("numOfGuests");
        String eventDate = data.get("eventDate");
        String eventTime = data.get("eventTime");

        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phone);
        System.out.println("Event type: " + eventType);
        System.out.println("# of Guests: " + numOfGuests);
        System.out.println("Event Date: " + eventDate);
        System.out.println("Event Time: " + eventTime);

        emailSendingService.sendEmail(fromEmail, email, "Thank you - "+name, "Hi "+name+", Thank you for contacting us!\n\nWe will reach out to you soon!");
        emailSendingService.sendEmail(fromEmail, email, name + " - New Event", "Event requested by: " + name);


        return true;
    }
}
 