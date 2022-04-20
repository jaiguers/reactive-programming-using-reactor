package com.learnreactiveprogramming.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Locale;

public class FluxAndMonoGeneratorService {

    public Flux<String> namesFlux() {
        return Flux.fromIterable(List.of("alex", "ben", "chloe")).log();
    }

    public Mono<String> nameMono() {
        return Mono.just("alex");
    }

    public Flux<String> namesFluxMap() {
        return Flux.fromIterable(List.of("alex", "ben", "chloe"))
                .map(String::toUpperCase)
                //.map(j->j.toUpperCase(Locale.ROOT)) lambda
                .log();
    }

    public Flux<String> namesFluxImmutability() {
        var namesFlux = Flux.fromIterable(List.of("alex", "ben", "chloe"));
        namesFlux.map(String::toUpperCase);
        return namesFlux;
    }

    public static void main(String[] args) {
        var fluxAndMono = new FluxAndMonoGeneratorService();

        fluxAndMono.namesFlux().subscribe(name -> {
            System.out.println("Name is: " + name);
        });

        fluxAndMono.nameMono().subscribe(name -> {
            System.out.println("Mono name is: " + name);
        });
    }
}
