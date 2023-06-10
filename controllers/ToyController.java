package controllers;

import model.Repository;
import model.Toy;

import java.util.List;

public class ToyController {

    private final Repository repository;

    public ToyController(Repository repository) {
        this.repository = repository;
    }

    public void saveToy(Toy toy) {
        repository.CreateToy(toy);
    }

    public Toy readToy(String toyId) throws Exception {
        List<Toy> toys = repository.getAllToys();
        for (Toy toy : toys) {
            if (toy.getId() == Integer.parseInt(toyId)) {
                return toy;
            }
        }
        throw new Exception("Игрушка не найдена");
    }

    public List<Toy> allToys() {
        return repository.getAllToys();

    }
}
