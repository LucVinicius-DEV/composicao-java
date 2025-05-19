// Importa classes necessárias
import java.util.Locale;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

// Importa classes do pacote entities

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Main {

    public static void main(String[] args) throws ParseException {

        // O método parse() lança uma exceção, por isso é necessário o throws ParseException na assinatura do método main().

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        // Leitura dos dados do departamento

        System.out.print("Enter department's name: ");
        String departmentName = sc.nextLine();
        System.out.print("Enter worker data: ");
        System.out.print("Name: ");
        String workerName = sc.nextLine();
        System.out.print("Level: ");
        String workerLevel = sc.nextLine();
        System.out.print("Base salary: ");
        double baseSalary = sc.nextDouble();

        // Instanciação do departamento e do trabalhador.
        // Note que a associação entre eles ocorre na instanciação do trabalhador.

        Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(departmentName));

        // Leitura dos dados dos contratos

        System.out.print("How many contracts to this worker? ");
        int n = sc.nextInt();

        for (int i=1; i<=n; i++) {

            System.out.println("Enter contract #" + i + " data:");
            // Leitura da data do contrato
            
            System.out.print("Date (DD/MM/YYYY): ");
            Date contractDate = sdf.parse(sc.next());
            
            // utilizando o conhecimento de Date e SimpleDateFormat para ler a data
            // o metodo parse() lança uma exceção, por isso é necessário o throws ParseException na assinatura do método main().
            // a excecao é lançada caso a data não esteja no formato correto.

            // Leitura dos dados do contrato
            
            System.out.print("Value per hour: ");
            double valuePerHour = sc.nextDouble();
            
            System.out.print("Duration (hours): ");
            int hours = sc.nextInt();

            // Instanciação do contrato
            
            HourContract contract = new HourContract(contractDate, valuePerHour, hours);

            // Associação do contrato com o trabalhador    
            
            worker.addContract(contract);
        
        }

        // Leitura do mês e ano para calcular a renda

        System.out.println(); // quebra de linha
        System.out.print("Enter month and year to calculate income (MM/YYYY): ");
        String monthAndYear = sc.next();
        int month = Integer.parseInt(monthAndYear.substring(0, 2));
        int year = Integer.parseInt(monthAndYear.substring(3));

        // Impressão da renda do trabalhador

        System.out.println("Name: " + worker.getName());
        System.out.println("Department: " + worker.getDepartment().getName());
        System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));
        

        sc.close();
    }
}
