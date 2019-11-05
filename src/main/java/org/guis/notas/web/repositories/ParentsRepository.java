package org.guis.notas.web.repositories;

import org.guis.notas.web.entities.Parent;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "http://localhost:8081/parents", name="parents")
public interface ParentsRepository {

    @GetMapping("/{dni}")
    Parent findByDni(@PathVariable String dni);
}
