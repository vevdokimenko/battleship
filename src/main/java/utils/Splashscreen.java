package utils;

import gameplay.Field;

public class Splashscreen {
    public Splashscreen() {
        String splashscreen = "";
        splashscreen += "   ______  _______ _______ _______        _______ _______ _     _ _____  _____\n";
        splashscreen += "   |_____] |_____|    |       |    |      |______ |______ |_____|   |   |_____]\n";
        splashscreen += "   |_____] |     |    |       |    |_____ |______ ______| |     | __|__ |\n";
        System.out.println(splashscreen);
        new Field().drawDemo();
    }
}