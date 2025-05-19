package entities;

// Classe que representa um departamento da empresa
public class Department {
  
  private String name; // Nome do departamento
  
  // Construtor padrão
  public Department() {
  }
  
  // Construtor com parâmetro
  public Department(String name) {
    this.name = name;
  }
  
  // Métodos getters e setters
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
}
