package com.LockedMe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LockedMeProject 
{
	static final String folderpath="D:\\Eclipse\\LockedMeFiles";
	
	public static void main(String[] args) 
	{
				// TODO Auto-generated method stub
				//variable declaration
				Scanner sc = new Scanner(System.in);
				int ch;
				int proceed=1;
				
				
						
				do
				{
					//display company welcome screen
					companyLogo();
					
					//display menu
					displayMenu();
					System.out.println("Enter the choice you want to perform:");
					ch = Integer.parseInt(sc.nextLine());
			
					switch(ch)
					{
					case 1: getAllFiles();
							break;
					case 2: createFile();
							break;
					case 3: deleteFile();
							break;
					case 4: searchFile();
							break;
					case 5: System.exit(0);
							break;
					default : System.out.println("Invalid Option");
							break;
					}
				}
				while(proceed>0);
					
	}
	
	/**
	 * This method will display the Welcome Screen
	 */
	public static void companyLogo()
	{
				System.out.println("**********************************************************");
				System.out.println("\t\tCompany Lockers Pvt. Ltd");
				System.out.println("\t\t\tLockedMe.com");
				System.out.println();
				System.out.println("Developed by- Deepak");
				System.out.println("**********************************************************");
	}
	
	/**
	 * This method displays the Menu option
	 */
	public static void displayMenu()
	{
				System.out.println();
				System.out.println("Please select from below options:");
				System.out.println("1. Get All file names");
				System.out.println("2. Add a file");
				System.out.println("3. Delete a file");
				System.out.println("4. Search a file");
				System.out.println("5. Exit");
				System.out.println("----------------------------");
	}
	
	/**
	 * This method will return the file names present in the folder
	 */
	public static void getAllFiles()
	{
				List<String> fileNames = AllMethods.getAllFiles(folderpath);
				
				for(String f:fileNames)
					System.out.println(f);
	}
	
	/**
	 * This method will add a file in the folder
	 */
	public static void createFile()
	{
				//Variable declaration
				Scanner sc= new Scanner(System.in);
				String fileName;
				int noOfLines;
				List<String> content=new ArrayList<String>();
				
				//Read file name from the user
				System.out.println("Enter the file name: ");
				fileName = sc.nextLine();
				
				//Read number of lines from the user
				System.out.println("Enter the no. of lines: ");
				noOfLines = Integer.parseInt(sc.nextLine());
				
				//Read the content of file from the user
				for(int i=1;i<=noOfLines;i++)
				{
					System.out.println("Enter line "+i+":");
					content.add(sc.nextLine());
				}
				
				//Save the content into the file
				boolean isSaved = AllMethods.createFile(folderpath, fileName, content);
				
				if(isSaved)
				{
					System.out.println("File saved successfully");
				}
				else
				{
					System.out.println("Some error occurred. Please try again.");
				}
	}
	
	/**
	 * This method will delete specified file in the folder
	 */
	public static void deleteFile()
	{
		//Variable declaration
				String fileName;
				Scanner sc = new Scanner(System.in);

				//Read the file name from the user
				System.out.println("Enter the file to be deleted: ");
				fileName=sc.nextLine();
				
				//deleting the file
				boolean isDeleted = AllMethods.deleteFile(folderpath, fileName);
						
				if(isDeleted)
				{
					System.out.println("File deleted successfully");
				}
				else
				{
					System.out.println("Some issue occurred. Either file is not there or access issue");
				}
	}
	
	/**
	 * This method will search specified file in the folder
	 */
	public static void searchFile()
	{
				//Variable declaration
				String fileName;
				Scanner sc = new Scanner(System.in);
		
				//Read the file name from the user
				System.out.println("Enter the file to be searched: ");
				fileName=sc.nextLine();
				
				//searching the file
				boolean isFound = AllMethods.searchFile(folderpath, fileName);
						
				if(isFound)
				{
					System.out.println("File is present in the folder");
				}
				else
				{
					System.out.println("File is not present in the folder");
				}
	}

}
