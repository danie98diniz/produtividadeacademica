import java.util.ArrayList;
import java.util.Scanner;

public class Collaborator {
    private String name;
    private String type;
    private String email;
    private ArrayList<Project> YourCurrentProjects = new ArrayList<>();
    private ArrayList<Project> YourPastProjects = new ArrayList<>();
    private ArrayList<Publication> YourPublications = new ArrayList<>();
    private ArrayList<Orientations> YourOrientations = new ArrayList<>();

    //--------------------------------- ADD COLLABORATOR  --------------------------
    public void Add_collaborator(ArrayList<Collaborator> CollaboratorsList, ArrayList<Collaborator> TeachersList){
        Scanner scan = new Scanner(System.in); // creates a object called scan to scan inputs along the code
        System.out.println("type the name of new collaborator:");
        String name = scan.nextLine();
        System.out.println("type the collaborator´s email:");
        String email = scan.nextLine();
        System.out.println("type 1 if the collaborator is a graduation student");
        System.out.println("type 2 if the collaborator is a masters degree student");
        System.out.println("type 3 if the collaborator is a PhD student");
        System.out.println("type 4 if the collaborator is a teacher");
        System.out.println("type 5 if the collaborator is a researcher");
        int option = scan.nextInt();
        scan.nextLine();
        String type = "new string";
        if(option == 1){
            type = "graduation";
        }
        else if(option == 2){
            type = "masters";
        }
        else if(option == 3){
            type = "phd";
        }
        else if(option == 4){
            type = "teacher";
        }
        else if(option == 5){
            type = "researcher";
        }

        Collaborator new_collaborator = new Collaborator(name, type, email);
        if(option == 4){
            TeachersList.add(new_collaborator);
        }
        CollaboratorsList.add(new_collaborator);
    }

    public Collaborator(String name, String type, String email) {
        this.name = name;
        this.type = type;
        this.email = email;
    }

    public ArrayList<Orientations> getYourOrientations() {
        return YourOrientations;
    }

    public void setYourOrientations(ArrayList<Orientations> yourOrientations) {
        YourOrientations = yourOrientations;
    }

    public ArrayList<Publication> getYourPublications() {
        return YourPublications;
    }

    public void setYourPublications(ArrayList<Publication> yourPublications) {
        YourPublications = yourPublications;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<Project> getYourCurrentProjects() {
        return YourCurrentProjects;
    }

    public void setYourCurrentProjects(ArrayList<Project> yourCurrentProjects) {
        YourCurrentProjects = yourCurrentProjects;
    }

    public ArrayList<Project> getYourPastProjects() {
        return YourPastProjects;
    }

    public void setYourPastProjects(ArrayList<Project> yourPastProjects) {
        YourPastProjects = yourPastProjects;
    }

    public Collaborator() {
    }
}
