package practica9;

class Employee implements Comparable<Employee> {
    int id;
    int origin;
    int destination;

    Employee(int id, int origin, int destination) {
        this.id = id;
        this.origin = origin;
        this.destination = destination;
    }

    @Override
    public int compareTo(Employee e) {
        return this.id - e.id; // Comparamos empleados por su ID.
    }
}