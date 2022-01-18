import Load.LoaderType.JsonLoader;
import Load.LoaderType.XmlLoader;

public class Main {
    public static void main(String[] args) {
        try{
           new JsonLoader("C:\\Users\\liran\\Downloads\\MadaReports - MadaReports.csv",
                   "C:\\Users\\liran\\Documents\\giTasks\\HdogemHamatmid\\src\\main\\resources\\StageA\\");

            new XmlLoader("C:\\Users\\liran\\Documents\\giTasks\\HdogemHamatmid\\src\\main\\resources\\LabTests - LabTests.csv",
                    "C:\\Users\\liran\\Documents\\giTasks\\HdogemHamatmid\\src\\main\\resources\\LABTESTS\\");
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
