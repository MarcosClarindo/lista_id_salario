package entitite;

public class Employee {
    private Integer id; // int
    private String name; // 
    private Double salary; // double


    // Construtor padrão sem argumento

    public Employee(){

    }

    public Employee(Integer id, String name, Double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public Integer getId(){
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary(){
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
        
    }

    public void increaseSalary(double percentage) {
        // Aumentndo o salário com a função percentage
        
        salary += salary * percentage / 100.0;
    }

    // Funcão para Exibir mensagem na tela.
    @Override // Auxilia quando a função estiver digitada errada
    public String toString() {
        return id + ", " + name + ", " + String.format("%.2f", salary);
    }
}