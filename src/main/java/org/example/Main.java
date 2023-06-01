package org.example;

import Presentation.Controller;
import Presentation.View;

public class Main {
    public static void main(String[] args) {
        View warehouseView = new View();
        Controller controller = new Controller(warehouseView);
    }
}