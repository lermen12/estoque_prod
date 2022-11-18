package com.estoque.estoque.controller;

import com.estoque.estoque.domain.Produto;
import com.estoque.estoque.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    @GetMapping(path = "/listaprod")
    public @ResponseBody List<Produto> getAllProdutos() {
        return repository.findAll();
    }

    @PostMapping(path = "/add")
    public @ResponseBody String addNewProdut(@RequestParam String name, @RequestParam Integer total) {
        Produto produto = new Produto();
        produto.setName(name);
        produto.setTotal(total);
        repository.save(produto);
        return "Salvo";
    }
}