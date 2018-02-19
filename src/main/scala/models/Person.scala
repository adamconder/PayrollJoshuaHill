package models

import java.util.UUID

abstract class Person(val name : String,
                      protected val employeeId : String,
                      protected val salaryAnnual: Double) {

  def monthlySalary() : Double

}

class Employee(override val name : String,
               override protected val employeeId: String,
               override protected val salaryAnnual: Double) extends Person(name, employeeId, salaryAnnual) {

  override def monthlySalary(): Double = {
    // take annual salary from salaryAnnual
    val twentyPercent : Double = salaryAnnual * 0.20
    // take off 20%
    val deducted = salaryAnnual - twentyPercent
    // divide by 12 payments
    deducted / 12
  }

}

// A Boss class
// Their monthly salary also adds on 5% of their annual each month
// for a car benefit
// plus 10% on top each month for a medical benefit

class Boss(override val name: String, override val employeeId: String, override val salaryAnnual: Double) extends Employee(name, employeeId, salaryAnnual) {

  def this(name : String, employeeId: String) = {
    this(name, employeeId, 34000)
  }

  def this(name : String) = {
    this(name, UUID.randomUUID().toString, 34000)
  }

  override def monthlySalary(): Double = {
    val salaryPerMonthMinus20PercentTax = super.monthlySalary()
    // five percent for car
    val fivePercent = (salaryAnnual * 0.05) /12
    // 10 percent for medical
    val tenPercent = (salaryAnnual * 0.1) /12
    // return total plus car and med
    salaryPerMonthMinus20PercentTax + fivePercent + tenPercent
  }
}