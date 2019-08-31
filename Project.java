import java.util.ArrayList;
import java.util.Scanner;

public class Project {
    private String name;
    private String initial_date;
    private String end_date;
    private String financial_agency;
    private double budget;
    private String goal;
    private String description;
    private ArrayList<Collaborator> CollaboratorsList = new ArrayList<>();
    private ArrayList<Publication> ProjectsPublications = new ArrayList<>();
    private String status;

    //--------------------------------- CREATE A PROJECT --------------------------
    public void Create_project (ArrayList<Project> ProjectList, ArrayList<Collaborator> TeachersList, ArrayList<Collaborator> CollaboratorsList){
        Scanner scan = new Scanner(System.in); // creates a object called scan to scan inputs along the code
        System.out.println("first choose a teacher to manage the project:");
        for (int i = 0; i < TeachersList.size(); i++){
            System.out.println(i+". "+TeachersList.get(i).getName());
        }
        int option = scan.nextInt();
        scan.nextLine();
        Collaborator teacher = TeachersList.get(option);

        Project new_project = new Project();
        new_project.getCollaboratorsList().add(teacher);
        teacher.getYourCurrentProjects().add(new_project);
        System.out.println("type the name of the project:");
        String name = scan.nextLine();
        new_project.setName(name);
        System.out.println(teacher.getName()+" will now be managing "+name);
        System.out.println("type the initial date of project as follow: '00/00/00':");
        String initial_date = scan.nextLine();
        new_project.setInitial_date(initial_date);
        System.out.println("type end date of project as follow '00/00/00':");
        String end_date = scan.nextLine();
        new_project.setEnd_date(end_date);
        System.out.println("type the name of the financial agency supporting this project:");
        String financial_agency = scan.nextLine();
        new_project.setFinancial_agency(financial_agency);
        System.out.println("type the budget of the project:");
        double budget = scan.nextDouble();
        scan.nextLine();
        new_project.setBudget(budget);
        System.out.println("type the goal of this project:");
        String goal = scan.nextLine();
        new_project.setGoal(goal);
        System.out.println("type the description of the project and type enter when ready:");
        String description = scan.nextLine();
        new_project.setDescription(description);
        String status = "On elaboration";
        new_project.setStatus(status);
        System.out.println("the project was registered with success!");
        ProjectList.add(new_project);
    }
    //--------------------------------- MANAGE PROJECTS  ----------------------------
    public void Manage_menu(ArrayList<Project> ProjectList, ArrayList<Collaborator> CollaboratorsList, ArrayList<Project> PastProjects){
        Scanner scan = new Scanner(System.in); // creates a object called scan to scan inputs along the code
        while(true){
            System.out.println("choose a project to manage");
            System.out.println("or type -1 to go back:");
            for (int i = 0; i < ProjectList.size(); i++){
                System.out.println(i+". "+ProjectList.get(i).getName());
            }
            int option = scan.nextInt();
            if(option == -1){
                return;
            }
            else if (option >= 0 && option < ProjectList.size()){
                Project thisProject = ProjectList.get(option);
                if(thisProject.getStatus().equals("On elaboration")){
                    Manage_project_in_elaboration(thisProject, CollaboratorsList);
                }
                else if(thisProject.getStatus().equals("Ongoing")){
                    Manage_ongoing_project(thisProject, PastProjects, ProjectList);
                }

            }
        }
    }
    //----------------------------------------- MANAGE ONGOING ----------------------------------------
    public void Manage_ongoing_project(Project Yourproject, ArrayList<Project> PastProjects, ArrayList<Project> ProjectList){
        Scanner scan = new Scanner(System.in); // creates a object called scan to scan inputs along the code

        while(true){
            System.out.println("Name: "+Yourproject.getName());
            System.out.println("Status: "+Yourproject.getStatus());
            System.out.println("Description: "+Yourproject.getDescription());
            System.out.println("Goal: "+Yourproject.getGoal());
            System.out.println("Initial date: "+Yourproject.getInitial_date());
            System.out.println("End date: "+Yourproject.getEnd_date());
            System.out.println("Financial agency: "+Yourproject.getFinancial_agency());
            System.out.println("Budget: "+Yourproject.getBudget());
            System.out.println("Collaborators:");
            ArrayList<Collaborator> YourProjectsCollaborators;
            YourProjectsCollaborators = Yourproject.CollaboratorsList;
            for(int i = 0; i < YourProjectsCollaborators.size(); i++){
                System.out.println(YourProjectsCollaborators.get(i).getName());
            }
            System.out.println("type -1 to go back");
            System.out.println("type -2 to change status to 'Complete'");
            int option = scan.nextInt();
            scan.nextLine();
            if(option == -1){
                break;
            }
            else if(option == -2){
                if(Yourproject.getProjectsPublications().size() > 0){
                    String status = "Complete";
                    Yourproject.setStatus(status);
                    PastProjects.add(Yourproject);
                    ProjectList.remove(Yourproject);
                    for(int i = 0; i < YourProjectsCollaborators.size(); i++){
                        YourProjectsCollaborators.get(i).getYourCurrentProjects().remove(Yourproject);
                        YourProjectsCollaborators.get(i).getYourPastProjects().add(Yourproject);
                    }
                    System.out.println("this project is now complete!");
                }
                else{
                    System.out.println("this projects have no publications to be complete");
                    System.out.println("type any key to exit");
                    String key = scan.nextLine();
                }
            }

        }
    }
    //----------------------------------------- MANAGE ELABORATION ------------------------------------
    public void Manage_project_in_elaboration(Project Yourproject, ArrayList<Collaborator> CollaboratorList){
        Scanner scan = new Scanner(System.in); // creates a object called scan to scan inputs along the code
        ArrayList<Collaborator> YourProjectCollaborators;
        YourProjectCollaborators = Yourproject.CollaboratorsList;
        Manage_manage:
        while(true){
            System.out.println("Name: "+Yourproject.getName());
            System.out.println("Status: "+Yourproject.getStatus());
            System.out.println("Description: "+Yourproject.getDescription());
            System.out.println("Goal: "+Yourproject.getGoal());
            System.out.println("Initial date: "+Yourproject.getInitial_date());
            System.out.println("End date: "+Yourproject.getEnd_date());
            System.out.println("Financial agency: "+Yourproject.getFinancial_agency());
            System.out.println("Budget: "+Yourproject.getBudget());
            System.out.println("Collaborators:");
            for(int i = 0; i < YourProjectCollaborators.size(); i++){
                System.out.println(YourProjectCollaborators.get(i).getName());
            }
            System.out.println("type 0 to go back");
            System.out.println("type 1 to change Status to 'Ongoing'");
            System.out.println("type 2 to add/remove Collaborators");
            int option = scan.nextInt();
            scan.nextLine();
            if(option == 0){
                return;
            }//go back
            else if(option == 1){
                int flag = 0;
                for(int i = 0; i < YourProjectCollaborators.size(); i++){
                    if(YourProjectCollaborators.get(i).getType() .equals("graduation")){
                        for(int j = 0; j < YourProjectCollaborators.get(i).getYourCurrentProjects().size(); j++){
                            if(YourProjectCollaborators.get(i).getYourCurrentProjects().get(j).getStatus().equals("Ongoing")){
                                flag++;
                            }
                            if(flag == 2){
                                System.out.println(YourProjectCollaborators.get(i).getName()+" is a graduation student and has 2 Ongoing projects");
                                System.out.println("remove him to complete action or wait for him to finish a ongoing project.");
                                System.out.println("type any key to continue");
                                String oloko = scan.nextLine();
                                continue Manage_manage;
                            }
                        }
                        flag = 0;
                    }
                }
                String status = "Ongoing";
                Yourproject.setStatus(status);
                System.out.println("this project is now in 'ongoing' status.");
                System.out.println("type any key to continue");
                String oloko = scan.nextLine();
                return;
            }//change to ongoing if everyone is available
            else if(option == 2){
                OLOKO:
                while(true){
                    System.out.println("type 0 to go back");
                    System.out.println("type 1 if you want to add a collaborator to this project");
                    System.out.println("type 2 if you want to remove a collaborator to this project:");
                    int choice = scan.nextInt();
                    scan.nextLine();
                    if(choice == 0){
                        continue Manage_manage;
                    }//go back
                    else if(choice == 1){
                        System.out.println("choose a collaborator from this lab to add to this project");
                        for(int p = 0; p < CollaboratorList.size(); p++){
                            System.out.println(p+". "+CollaboratorList.get(p).getName());
                        }
                        int index = scan.nextInt();
                        for (int h = 0; h < YourProjectCollaborators.size(); h++){
                            if(CollaboratorList.get(index).getName().equals(YourProjectCollaborators.get(h).getName())){
                                System.out.println("this collaborator is already on this project!");
                                continue OLOKO;
                            }
                        }
                        YourProjectCollaborators.add(CollaboratorList.get(index));
                        CollaboratorList.get(index).getYourCurrentProjects().add(Yourproject);
                        System.out.println(CollaboratorList.get(index).getName()+" is now on this project!");
                    }//add collaborator
                    else if(choice == 2){
                        System.out.println("choose a collaborator to remove from project:");
                        int teachers = 0;
                        for(int i = 0; i < YourProjectCollaborators.size(); i++){
                            System.out.println(i+". "+YourProjectCollaborators.get(i).getName());
                            if(YourProjectCollaborators.get(i).getType().equals("teacher")){
                                teachers++;
                            }
                        }
                        int choice2 = scan.nextInt();
                        if(YourProjectCollaborators.get(choice2).getType().equals("teacher") && teachers == 1){
                            System.out.println("you cannot remove "+YourProjectCollaborators.get(choice2).getName()+" because its the only teacher on this project");
                            System.out.println("type a number to continue:");
                            choice2 = scan.nextInt();
                        }
                        else{
                            System.out.println(YourProjectCollaborators.get(choice2).getName()+" is now removed from this project");
                            YourProjectCollaborators.get(choice2).getYourCurrentProjects().remove(Yourproject);
                            YourProjectCollaborators.remove(choice2);
                            continue Manage_manage;
                        }
                    }//remove collaborator
                }
            }//add/remove
        }
    }
    //----------------------------------------- ACADEMIC REPORT ------------------------
    public void Show_academic_report(ArrayList<Collaborator> CollaboratorsList, ArrayList<Project> ProjectList, ArrayList<Project> PastProjects, ArrayList<Publication> AllPublications, ArrayList<Orientations> AllOrientations){
        Scanner scan = new Scanner(System.in); // creates a object called scan to scan inputs along the code

        System.out.println("-- LABORATORY ACADEMIC PRODUCTIVITY REPORT --");
        System.out.println("Number of Collaborators: "+CollaboratorsList.size());
        int elab = 0;
        for(int i = 0; i < ProjectList.size(); i++){
            if(ProjectList.get(i).getStatus().equals("On elaboration")){
                elab++;
            }
        }
        System.out.println("Number of Projects 'On elaboration': "+elab);
        int ongoing = 0;
        for (int i = 0; i < ProjectList.size(); i++){
            if(ProjectList.get(i).getStatus().equals("Ongoing")){
                ongoing++;
            }
        }
        System.out.println("Number of 'Ongoing' Projects: "+ongoing);
        System.out.println("Number of 'Complete' Projects: "+PastProjects.size());
        int total = PastProjects.size() + ProjectList.size();
        System.out.println("Number of Projects in total: "+total);
        System.out.println("Number of Orientations: "+AllOrientations.size());
        System.out.println("Number of Publications: "+AllPublications.size());
        System.out.println("type any key to continue..");
        String string = scan.nextLine();
    }
    //----------------------------------------- PROJECT SELECTION -----------------------
    public void Project_selection(ArrayList<Project> AllProjects){
        Scanner scan = new Scanner(System.in); // creates a object called scan to scan inputs along the code

        System.out.println("choose a project to consult:");
        for(int i = 0; i < AllProjects.size(); i++){
            System.out.println(i+". "+AllProjects.get(i).getName());
        }
        int option = scan.nextInt();
        scan.nextLine();
        Consult_by_project(AllProjects.get(option));
    }


    //----------------------------------------- PROJECT CONSULT ------------------------
    public static void Consult_by_project(Project Yourproject){

        System.out.println("Name: "+Yourproject.getName());
        System.out.println("Status: "+Yourproject.getStatus());
        System.out.println("Description: "+Yourproject.getDescription());
        System.out.println("Goal: "+Yourproject.getGoal());
        System.out.println("Initial date: "+Yourproject.getInitial_date());
        System.out.println("End date: "+Yourproject.getEnd_date());
        System.out.println("Financial agency: "+Yourproject.getFinancial_agency());
        System.out.println("Budget: "+Yourproject.getBudget());
        System.out.println("Collaborators:");
        for(int i = 0; i < Yourproject.getCollaboratorsList().size(); i++){
            System.out.println(Yourproject.getCollaboratorsList().get(i).getName());
        }

        Publication newPublication = new Publication();
        newPublication.Sort_publications(Yourproject.getProjectsPublications());


    }


    public ArrayList<Publication> getProjectsPublications() {
        return ProjectsPublications;
    }

    public void setProjectsPublications(ArrayList<Publication> projectsPublications) {
        ProjectsPublications = projectsPublications;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInitial_date() {
        return initial_date;
    }

    public void setInitial_date(String initial_date) {
        this.initial_date = initial_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getFinancial_agency() {
        return financial_agency;
    }

    public void setFinancial_agency(String financial_agency) {
        this.financial_agency = financial_agency;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public ArrayList<Collaborator> getCollaboratorsList() {
        return CollaboratorsList;
    }

    public void setCollaboratorsList(ArrayList<Collaborator> collaboratorsList) {
        CollaboratorsList = collaboratorsList;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Project() {
    }
}
