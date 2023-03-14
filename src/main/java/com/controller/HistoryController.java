package com.controller;

import com.domain.Address;
import com.domain.History;
import com.service.AddressService;
import com.service.HistoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.NoResultException;

@Controller
@RequestMapping("history")
public class HistoryController {
    private final HistoryService historyService;
    private History history;

    public HistoryController(HistoryService historyService) {
        this.historyService = historyService;
    }

    @RequestMapping(value = "/test-history", method = RequestMethod.GET)
    @ResponseBody
    public String test() {//localhost:9999/my/healthy/testHealthy
        return "Test, History!!!";
    }

    @PostMapping("/history")
    public void save(@RequestBody History history) {
        historyService.save(history);
    }

    @DeleteMapping("/history/{id}")
    public void removeById(@PathVariable("id") int id) {
        historyService.removeById(id);
    }

    @PutMapping("/history")
    public void update(@RequestBody History history) {
        historyService.update(history);
    }

    @GetMapping("/history")
    public History getById(@PathVariable("id") int id) {
        History history = null;

        try {
            history = historyService.getById(id);
        } catch (NoResultException e) {
            throw new IllegalArgumentException("History " + " with id " + id + " not found ");
        }

        return history;
    }
    @ExceptionHandler(IllegalArgumentException.class)
    private ResponseEntity<String> handlerHistory(IllegalArgumentException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
    }
}
