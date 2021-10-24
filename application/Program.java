package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entitite.Employee;

public class Program {
    public static void main(String[] args) throws Exception {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in); // Para ler os dados digitados

        // Criando a lista do tipo Enployee
        // Necessário instanciar a lista para poder receber dados
        List<Employee> list = new ArrayList<>();

        System.out.print("How many employess will be registered? ");
        int N = sc.nextInt();

        for (int i=0; i<N; i++) {
            System.out.println();
            System.out.println("Employee " + (i+1) + ":");  
            System.out.println("Id: ");
            Integer id = sc.nextInt(); // Para ler o dado do Id

            // Função para não deixar digitar um ID que já foi digitado
            while (hasId(list, id)) {
                System.out.println("Id already taken! Try again: ");
                id = sc.nextInt();
            }

            System.out.println("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.println("Salary: ");
            Double salary = sc.nextDouble();

            // Intanciando o objeto Employee

            Employee emp = new Employee(id, name, salary);

            // Inserindo o Funcionário na lista
            // Instanciando o objeto declarado na lista

            list.add(emp);
        }

        System.out.println("Enter the employee id that will be have salary increase : ");
        int idsalary = sc.nextInt();
        // funcão para procurar o idsalary dentro da lista

        Employee emp = list.stream().filter(x -> x.getId() == idsalary).findFirst().orElse(null);

       // Integer pos = positionInteger(list, idsalary);

        if (emp == null) {
            
            System.out.println("This id does not exist!");
        } else {
            System.out.print("Enter the percentage: ");
            double percent = sc.nextDouble();
            // Chamando na lista a posição do funcionário para qual será atribuido o aumento do salário
            emp.increaseSalary(percent);
        }

        System.out.println();
        System.out.println("List of employee: ");
        for (Employee e : list) {
            System.out.println(e);
        }

        sc.close();
    }

    // Funçao para retorna a posição do Integer na lista
    

    public static Integer positionInteger(List<Employee> list, int id){
        // Este métod vai retornar a posição do id na lista
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                return i;
            }
        }
        return null;
    }
        // Função para bloquear um ID que já foi digitado
    public static boolean hasId(List<Employee>list, int id) {
        Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        return emp != null;
    }
    
}
