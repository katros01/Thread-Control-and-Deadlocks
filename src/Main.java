//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ThreadInterruption threadInterruption = new ThreadInterruption();
        ForkJoin forkJoin = new ForkJoin();
        Deadlock deadlock = new Deadlock();

        // -------------------------------------------------------------------------------

        System.out.println("Demonstrating Thread Interruption:");
        threadInterruption.demonstrateThreadInterruption();

        // -------------------------------------------------------------------

        System.out.println("\nDemonstrating Fork/Join Framework:");
        forkJoin.demonstrateForkJoin();

        // -------------------------------------------------------------------------

        System.out.println("\nDemonstrating Deadlock Scenario:");
        deadlock.demonstrateDeadlock();
    }
}