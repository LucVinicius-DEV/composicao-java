package entities;

import java.util.Date;

// Classe que representa um contrato de trabalho por hora
public class HourContract {
  
  // Atributos
  private Date date;           // Data do contrato
  private Double valuePerHour; // Valor por hora trabalhada
  private Integer hours;       // Quantidade de horas contratadas
  
  // Construtor padrão
  public HourContract() {
  }
  
  // Construtor com parâmetros
  public HourContract(Date date, Double valuePerHour, Integer hours) {
    this.date = date;
    this.valuePerHour = valuePerHour;
    this.hours = hours;
  }
  
  // Métodos getters e setters
  public Date getDate() {
    return date;
  }
  
  public void setDate(Date date) {
    this.date = date;
  }
  
  public Double getValuePerHour() {
    return valuePerHour;
  }
  
  public void setValuePerHour(Double valuePerHour) {
    this.valuePerHour = valuePerHour;
  }
  
  public Integer getHours() {
    return hours;
  }
  
  public void setHours(Integer hours) {
    this.hours = hours;
  }
  
  // Método para calcular o valor total do contrato
  public double totalValue() {
    return valuePerHour * hours;
  }
}
