package com.controller;

import com.domain.Client;
import com.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.NoResultException;

@Controller
@RequestMapping("client")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @RequestMapping(value = "/test-client", method = RequestMethod.GET)
    //@ResponseBody
    public String test() {//localhost:9999/my/healthy/testHealthy
        return "/index";
    }
    //
    @RequestMapping(value = "/test-jsp", method = RequestMethod.GET)
    public ModelAndView main() {
        ModelAndView modelAndView = new ModelAndView();
        //modelAndView.addObject("userJSP", new User());
        modelAndView.setViewName("index");
        return modelAndView;
    }
    @RequestMapping(value = "/developer", method = RequestMethod.GET)
    public String developer(){ return "developer";}
    //

    @PostMapping("/client")
    public void save(@RequestBody Client client) {
        clientService.save(client);
    }

    @DeleteMapping("/client/{id}")
    public void removeById(@PathVariable("id") int id) {
        clientService.removeById(id);
    }

    @PutMapping("/client")
    public void update(@RequestBody Client client) {
        clientService.update(client);
    }

    @GetMapping("/client/{id}")
    public Client getById(@PathVariable("id") int id) {
        Client client = null;

        try {
            client = clientService.getById(id);
        } catch (NoResultException e) {
            throw new IllegalArgumentException("Client " + " with id " + id + " not found ");
        }

        return client;
    }
    @ExceptionHandler(IllegalArgumentException.class)
    private ResponseEntity<String> handlerClient(IllegalArgumentException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
    }
}
