import java.util.UUID

import models.{Boss, Employee}

object PayrollApp extends App {

  val emp1 = new Employee(
    name = "Josh",
    employeeId = UUID.randomUUID().toString,
    salaryAnnual = 24000.86
  )
  println(f"${emp1.monthlySalary()}%4.2f")

  val boss = new Boss("Adam")
  println(f"${boss.monthlySalary()}%4.2f")
}
