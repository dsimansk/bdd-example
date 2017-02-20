package com.github.zregvart.bdd.example.cameleers;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CameleerRepository extends PagingAndSortingRepository<Cameleer, Integer> {
}
