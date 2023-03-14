package com.controller;

import com.domain.Address;
import com.domain.Doctor;
import com.service.AddressService;
import com.service.DoctorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.NoResultException;

@Controller
@RequestMapping("doctor")
public class DoctorController {
    private final DoctorService doctorService;
    private Doctor doctor;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @RequestMapping(value = "/test-doctor", method = RequestMethod.GET)
    @ResponseBody
    public String test() {//localhost:9999/my/healthy/testHealthy
        return "Test, Doctor!!!";
    }

    @PostMapping("/doctor")
    public void save(@RequestBody Doctor doctor) {
        doctorService.save(doctor);
    }

    @DeleteMapping("/client/{id}")
    public void removeById(@PathVariable("id") int id) {
        doctorService.removeById(id);
    }

    @PutMapping("/doctor")
    public void update(@RequestBody Doctor doctor) {
        doctorService.update(doctor);
    }

    @GetMapping("/doctor/{id}")
    public Doctor getById(@PathVariable("id") int id) {
        Doctor doctor = null;

        try {
            doctor = doctorService.getById(id);
        } catch (NoResultException e) {
            throw new IllegalArgumentException("Doctor " + " with id " + id + " not found ");
        }

        return doctor;
    }
    @ExceptionHandler(IllegalArgumentException.class)
    private ResponseEntity<String> handlerDoctor(IllegalArgumentException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
    }
}
