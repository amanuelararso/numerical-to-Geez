package com.amanuel.n2g;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class n2gController {

    private String geezNumber = "";
    wedeGeez geez = new wedeGeez();

    //this section is shown when the default page is loaded
    // default value of numerical and the Geez representation is set, so that it will not be just null
    @GetMapping("/")
    public String hello ( Model model) {
        model.addAttribute("numerical", "2016");
        model.addAttribute("number", geez.ቀይር(2016));
        return "index";
    }

    //this section will be excuted after user filled the input box
    @PostMapping("/change")
    public String c2G(@ModelAttribute changeToGeez att, Model model) {
        geezNumber = geez.ቀይር(att.getAlphanumber());
        model.addAttribute("numerical", att.getAlphanumber());
        model.addAttribute("number", geezNumber);
        return "index"; // reloads the page with the new numerical value and the Geez counterpart
    }
}
