package com.sakila.utils;

import java.util.regex.Pattern;

public class Validador {

    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");

    private static final Pattern TELEFONO_DOM_PATTERN =
            Pattern.compile("^(809|829|849)[0-9]{7}$");

    private static final Pattern CEDULA_PATTERN =
            Pattern.compile("^\\d{3}-\\d{7}-\\d{1}$");

    /**
     * Valida si un correo electrónico tiene el formato correcto.
     */
    public static boolean esEmailValido(String email) {
        return EMAIL_PATTERN.matcher(email).matches();
    }

    /**
     * Valida si un teléfono es dominicano (809, 829 o 849).
     */
    public static boolean esTelefonoValido(String telefono) {
        return TELEFONO_DOM_PATTERN.matcher(telefono).matches();
    }

    /**
     * Valida si una cédula dominicana está en el formato correcto.
     */
    public static boolean esCedulaValida(String cedula) {
        return CEDULA_PATTERN.matcher(cedula).matches();
    }
}
