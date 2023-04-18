package edu.ucalgary.oop;

public class Employee {

    private String name;
    private final String IDNUMBER;
    private String managerID;
    private Employee[] supervisedEmployees;

    public Employee(String name, String idNumber) {
        this.name = new String(name);
        this.IDNUMBER = new String(idNumber);
        this.managerID = null;
        this.supervisedEmployees = new Employee[10];
    }

    public Employee(String name, String idNumber, String managerID) {
        this.name = new String(name);
        this.IDNUMBER = new String(idNumber);
        this.managerID = new String(managerID);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIDNumber() {
        return this.IDNUMBER;
    }

    public String getManagerID() {
        return this.managerID;
    }

    public void setManagerID(String newManager) {
        this.managerID = newManager;
    }

    public void addEmployee(Employee newEmployee) {
        if (this.supervisedEmployees == null) {
            this.supervisedEmployees = new Employee[10];
        }
        for (int i = 0; i < this.supervisedEmployees.length; i++) {
            if (this.supervisedEmployees[i] == null) {
                this.supervisedEmployees[i] = newEmployee;
                break;
            }
        }
    }

    public Employee[] getEmployees() {
        return this.supervisedEmployees;
    }

}
