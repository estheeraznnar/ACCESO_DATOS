package org.iesch.ad.Ej2.control;

import org.iesch.ad.Ej2.modelo.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    Post post;

    @PostMapping("/crearPost")
    public void crearPost(){

    }

}
