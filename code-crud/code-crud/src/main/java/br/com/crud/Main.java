package br.com.crud;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import io.quarkus.runtime.annotations.QuarkusMain;
import io.quarkus.runtime.Quarkus;


    @QuarkusMain
     public class Main {

        public static void main(String... args) {
            System.out.println("Running main method");
            Quarkus.run(args);
        }

    }
