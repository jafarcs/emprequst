package com.k8s.kubernetes.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class KubernetesController {

    @RequestMapping("/k8s")
    public String welcomeMsg(){
        return "Welcome to Kubernetes";
    }

    @GetMapping("/emprequest")
    public String getEmployeesResponse(){
        //String url = "http://127.0.0.1:8000/employee/employees";
        String url = "http://192.168.99.100:31419/employees";

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);
        return result;

    }

    @GetMapping("/emprequest/{empId}")
    public String getEmployeeResponseById(@PathVariable int empId){
        //String url = "http://127.0.0.1:8000/employee/employees/"+empId;
        String url = "http://192.168.99.100:31419/employees/"+empId;

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);
        return result;
    }
}
