package com.vladimercury;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by vladimercury on 6/12/16.
 */
@Controller
public class MsgController {
    @RequestMapping(value="/msg", method = RequestMethod.GET)
    public String msgForm(Model model){
        model.addAttribute("msg", new Msg());
        return "msg";
    }

    @RequestMapping(value = "/msg", method = RequestMethod.POST)
    public String msgSubmit(@ModelAttribute Msg msg, Model model){
        model.addAttribute("msg", msg);
        return "result";
    }
}
