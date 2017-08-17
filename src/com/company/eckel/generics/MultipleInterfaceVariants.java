package company.eckel.generics;//: generics/MultipleInterfaceVariants.java
// {CompileTimeError} (Won't compile)

interface Payable<T> {}

class Employee implements Payable<Employee> {}

//Compile error
class Hourly extends Employee /*implements Payable<Hourly>*/ {} ///:~
