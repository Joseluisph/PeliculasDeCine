package com.sakila.app;

import com.sakila.bll.ActorManager;
import com.sakila.models.Actor;

import java.util.List;

public class ActorTest {

    public static void main(String[] args) {
        ActorManager gestor = new ActorManager();

        System.out.println("📌 Buscando actor por ID...");
        Actor actor = gestor.buscarPorId(1);

        if (actor != null) {
            System.out.println("✅ Actor encontrado:");
            System.out.println("ID: " + actor.getId());
            System.out.println("Nombre: " + actor.getNombre());
            System.out.println("Apellido: " + actor.getApellido());
            System.out.println("Última actualización: " + actor.getUltimaActualizacion());
        } else {
            System.out.println("❌ No se encontró el actor con ID 1.");
        }

        System.out.println("\n📌 Listando todos los actores:");
        List<Actor> lista = gestor.obtenerTodos();

        for (Actor a : lista) {
            System.out.println("ID: " + a.getId() + " | Nombre: " + a.getNombre() + " " + a.getApellido());
        }
    }
}
