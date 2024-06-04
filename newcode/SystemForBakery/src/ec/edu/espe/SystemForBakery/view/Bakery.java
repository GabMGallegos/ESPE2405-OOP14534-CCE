package ec.edu.espe.SystemForBakery.view;

import ec.edu.espe.SystemForBakery.model.Profile;


import java.io.IOException;
import java.util.Scanner;
import utils.FileManage;




public class Bakery{
    //bfgnn
    public static void main(String[] args) {
        System.out.println("Team Code Crafting");
        Scanner scanner = new Scanner(System.in);
        
        
        System.out.println("Enter file type to save (csv/txt): ");
        String fileType = scanner.nextLine().toLowerCase();
        
        StringBuilder csvData = new StringBuilder();
        csvData.append("IDProfile,NameProfile,Description\n");
        
        for (int i = 0; i < 2; i++) {
            System.out.println("Enter profile data " + (i + 1) + ":");
            System.out.println("ID: ");
            int profile_id = scanner.nextInt();
            
            scanner.nextLine();
            
            System.out.println("Name Profile: ");
            String nameProfile = scanner.nextLine();
            
            System.out.println("Description: ");
            String description = scanner.nextLine();
            
            Profile profile = new Profile(profile_id, nameProfile, description);
            String data = profile.toCSV();
            try {
                FileManage.save(data, "profile", fileType);
            } catch (IOException e) {
                System.err.println("An error occurred while saving the data: " + e.getMessage());
            }
        }
    }
}