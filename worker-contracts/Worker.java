package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;
import entities.enums.WorkerLevel;

// Classe que representa um trabalhador com contratos
public class Worker {
  
  // Atributos básicos
  private String name;         // Nome do trabalhador
  private WorkerLevel level;   // Nível de experiência (enum)
  private Double baseSalary;   // Salário base
  
  // Relações de composição
  private Department department;                // Associação "tem-um" com Department
  private List<HourContract> contracts = new ArrayList<>(); // Composição "tem-muitos" com HourContract
  
  // Construtor padrão
  public Worker() {
  }
  
  // Construtor com parâmetros (não inclui a lista de contratos)
  public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
    this.name = name;
    this.level = level;
    this.baseSalary = baseSalary;
    this.department = department;
  }
  
  // Métodos getters e setters (exceto para contracts que tem métodos especiais)
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public WorkerLevel getLevel() {
    return level;
  }
  
  public void setLevel(WorkerLevel level) {
    this.level = level;
  }
  
  public Double getBaseSalary() {
    return baseSalary;
  }
  
  public void setBaseSalary(Double baseSalary) {
    this.baseSalary = baseSalary;
  }
  
  public Department getDepartment() {
    return department;
  }
  
  public void setDepartment(Department department) {
    this.department = department;
  }
  
  public List<HourContract> getContracts() {
    return contracts;
  }
  
  // Métodos para manipular contratos (composição)
  public void addContract(HourContract contract) {
    contracts.add(contract);
  }
  
  public void removeContract(HourContract contract) {
    contracts.remove(contract);
  }
  
  // Método para calcular ganhos em um mês/ano específico
  public double income(int year, int month) {
    double sum = baseSalary;
    Calendar cal = Calendar.getInstance();
    
    for (HourContract c : contracts) {
      cal.setTime(c.getDate());
      int c_year = cal.get(Calendar.YEAR);
      int c_month = 1 + cal.get(Calendar.MONTH);
      
      if (year == c_year && month == c_month) {
        sum += c.totalValue();
      }
    }
    return sum;
  }
}
