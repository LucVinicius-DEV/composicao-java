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
    
    // O método parse() lança uma exceção, por isso é necessário o throws ParseException na assinatura do método
    
    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    // Leitura dos dados do departamento
    System.out.print("Enter department's name: ");
    String departmentName = sc.nextLine();
    
    // Leitura dos dados do trabalhador
    System.out.print("Enter worker data: ");
    System.out.print("Name: ");
    String workerName = sc.nextLine();
    System.out.print("Level: ");
    String workerLevel = sc.nextLine();
    System.out.print("Base salary: ");
    double baseSalary = sc.nextDouble();
    
    // Instancia objetos com os dados lidos
    Worker worker = new Worker(
        workerName, 
        WorkerLevel.valueOf(workerLevel), 
        baseSalary, 
        new Department(departmentName)
    );
    
    // Leitura dos contratos
    System.out.print("How many contracts to this worker? ");
    int n = sc.nextInt();
    
    // Lê cada contrato e adiciona ao trabalhador
    for (int i=1; i<=n; i++) {
      System.out.println("Enter contract #" + i + " data:");
      System.out.print("Date (DD/MM/YYYY): ");
      Date contractDate = sdf.parse(sc.next());
      System.out.print("Value per hour: ");
      double valuePerHour = sc.nextDouble();
      System.out.print("Duration (hours): ");
      int hours = sc.nextInt();
      
      // Cria contrato com os dados lidos
      HourContract contract = new HourContract(contractDate, valuePerHour, hours);
      
      // Adiciona contrato ao trabalhador (composição)
      worker.addContract(contract);
    }
    
    // Leitura do mês e ano para cálculo de renda
    System.out.println();
    System.out.print("Enter month and year to calculate income (MM/YYYY): ");
    String monthAndYear = sc.next();
    int month = Integer.parseInt(monthAndYear.substring(0, 2));
    int year = Integer.parseInt(monthAndYear.substring(3));
    
    // Exibe resultado
    System.out.println("Name: " + worker.getName());
    System.out.println("Department: " + worker.getDepartment().getName());
    System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));
    
    sc.close();
  }
}
