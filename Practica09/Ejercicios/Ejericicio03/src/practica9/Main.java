package practica9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import exceptions.ItemDuplicated;
import exceptions.ItemNotFound;
import exceptions.ExceptionIsEmpty;

public class Main {
    public static void main(String[] args) throws ItemDuplicated {
        Map<Integer, AVLTree<Employee>> trees = new HashMap<>();
        trees.put(1, new AVLTree<Employee>());
        trees.put(2, new AVLTree<Employee>());
        trees.put(3, new AVLTree<Employee>());
        Employee newEmployee = new Employee(1001, 2, 1);
        
        String line;
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("C:\\Algoritmia\\Practica9\\EMPRESA.txt"));
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                int origin = Integer.parseInt(parts[1]);
                int destination = Integer.parseInt(parts[2]);

                trees.get(origin).insert(new Employee(id, origin, destination));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("EMPRESA.txt", true));
            writer.write(newEmployee.id + "," + newEmployee.origin + "," + newEmployee.destination);
            writer.newLine();
            writer.close();
            System.out.println("Nuevo empleado agregado al archivo EMPRESA.txt.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al agregar el nuevo empleado al archivo EMPRESA.txt.");
        }
        // Ahora intercambiamos los empleados
        for (AVLTree<Employee> tree : trees.values()) {
            Iterator<Employee> iterator = tree.iterator();  
            while (iterator.hasNext()) {
                Employee emp = iterator.next();
                iterator.remove();  // Esto eliminará el empleado del árbol AVL actual
                trees.get(emp.destination).insert(emp);  // Insertamos el empleado en el nuevo árbol AVL
       
            }
        }
    }
}