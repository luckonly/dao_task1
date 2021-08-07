package ru.netology.dao.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.dao.dao.DaoRepository;

import java.util.List;

@RestController("/")
public class Controller {

    public final DaoRepository daoRepository;

    public Controller(DaoRepository daoRepository) {
        this.daoRepository = daoRepository;
    }

    @GetMapping("/fetch_products")
    public List<String> fetchProductsByName(@RequestParam String name) {
       return daoRepository.productsList(name);
    }

}
