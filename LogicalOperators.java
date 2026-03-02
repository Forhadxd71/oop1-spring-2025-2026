public class LogicalOperators {
    public static void main(String[] args) {
        boolean x = true;
        boolean y = false;

        // Logical AND
        System.out.println("x && y: " + (x && y));

        // Logical OR
        System.out.println("x || y: " + (x || y));

        // Logical NOT
        System.out.println("!x: " + (!x));
        System.out.println("!y: " + (!y));

        boolean hasHighIncome = false;
        boolean hasGoodCredit = true;
        boolean hasCriminalRecord = false;

        // Decision to approve a loan
        boolean isEligibleForLoan = (hasHighIncome || hasGoodCredit) && !hasCriminalRecord;
        System.out.println("Is eligible for loan: " + isEligibleForLoan);
    }
}
 