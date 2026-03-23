public class ProceduralProgramming {
    public static int CalculateWage(int baseSalary, int extraHours, int hourlyRate){
        return baseSalary + (extraHours * hourlyRate);
}
    public static void main(String[] args) {
        int baseSalary = 50_000;
        int extraHours = 10;
        int hourlyRate = 20;
        int totalWage = CalculateWage(baseSalary, extraHours, hourlyRate);
        System.out.println("Total Wage: " + totalWage);
    }

}