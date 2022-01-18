import Load.JsonLoader.JsonLoader;

public class Main {
    public static void main(String[] args) {
        try{
            new JsonLoader("C:\\Users\\liran\\Downloads\\MadaReports - MadaReports.csv", "C:\\Users\\liran\\Downloads\\test\\");
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
