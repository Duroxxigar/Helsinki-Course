public class Main {
    public static void main(String[] args) {

        CivilService civilService = new CivilService();
        MilitaryService militaryService = new MilitaryService(180);

        civilService.work();
        System.out.println(civilService.getDaysLeft());

        militaryService.work();
        System.out.println(militaryService.getDaysLeft());
    }
}
