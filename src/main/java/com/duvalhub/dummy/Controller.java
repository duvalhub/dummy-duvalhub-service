package com.duvalhub.dummy;

//import com.duvalhub.core.exceptions.DuvalhubException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/allo")
public class Controller {
    @GetMapping
    public String allo() {
        return "Allo from dummy";
    }

//    @PostMapping
//    public DuvalhubException error() {
//        return new DuvalhubException();
//    }
}
