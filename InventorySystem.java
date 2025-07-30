//Author: Passant Shaaban Abdelazim
//ID: 20231036
//Section : S23
//Purpose : Assignment 1 task 1 (Inventory management system) 
//Date : 26 Feb 2025


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Iterator;

//A class for products
class ProductClass {

    private int id ;
    private String name;
    private int quantity;
    private double price;
    private String category;

    
    //constructor to initialize a product
    public ProductClass(int id, String name, int quantity, double price, String category ){
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.category = category;
    }
   
    //Getter for id
    public int getId(){
        return id;
    }

    //Getter for name
    public String getName(){
        return name;
    }    

    //Getter gor quantity
    public int getQuantity(){
        return quantity;
    }

    //Getter gor price
    public Double getPrice(){
        return price;
    }

    //Getter gor category
    public String getCategory(){
        return category;
    }

    //Setter for Name
    public void SetName(String newName){
        name = newName;
    }

    //Setter for quantity
    public void SetQuantity(int newQuantity){
        quantity = newQuantity;
    }

    //Setter for price
    public void SetPrice(double newprice){
        price = newprice;
    }

    //Setter for category
    public void SetCategory(String newCategory){
        category = newCategory;
    }

    // Method to display product details
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Quantity: " + quantity +
               ", Price: $" + price + ", Category: " + category;
    }
    
}


public class InventorySystem {
    public static void main(String[] args){
        ArrayList<ProductClass> Product = new ArrayList<>();
        InventorySystem system = new InventorySystem();            
        
        //initialize some products in the list
        Product.add(new ProductClass(15637, "Laptop", 25, 25400, "Electronics"));
        Product.add(new ProductClass(96749, "Chair", 34, 750, "Home essential"));
        Product.add(new ProductClass(89573, "Microwave", 41, 10000, "electronics"));
        Product.add(new ProductClass(94036, "Pasta", 86, 35, "Food"));

        boolean run = true;
        while(run){
            menu();
            Scanner input = new Scanner (System.in);
            int choice ;

            //Validate user input for the menu
            while(true){
                try {
                    System.out.println("Enter your choice: ");
                    choice = Integer.parseInt(input.nextLine());
                    if (choice <1 || choice>8){
                        System.out.println("Please choose a valid option from 1 to 8.");
                    }else{
                        break;
                    }
                } catch (NumberFormatException e){
                    System.out.println("Invalid input. Please enter a number");
                }
            }

            //Exiting the program
            if(choice==8){
                System.out.println("Thanks for using my program.");
                break;
            }

            //Executing features of the program by calling functions 
            switch (choice) {

                case 1:
                system.addProduct(Product);         
                    break;

                case 2:
                system.viewProduct(Product);
                    break;                    

                case 3:
                system.searchProduct(Product);
                    break;  

                case 4:
                system.editProduct(Product);
                    break;    

                case 5:
                system.deleteProduct(Product);
                    break;    
    
                case 6:
                system.sortProduct(Product);
                    break;

                case 7:
                system.generateReport(Product);    
                    break;   

                default:
                System.out.println("Invalid choice");
                    break;
            }

        }


    }

    // Display the menu
    public static void menu(){

        System.out.println("********************************************");
        System.out.println("Welcome to my management system application!\n");
        System.out.println("1. Add a product");
        System.out.println("2. View all products");
        System.out.println("3. Search for a product");
        System.out.println("4. Edit a product");
        System.out.println("5. Delete a product");
        System.out.println("6. Sort products");
        System.out.println("7. Generate a report");
        System.out.println("8. Exit");
        System.out.println("********************************************");
    }

    // Add a new product to the inventory
    public void addProduct(ArrayList<ProductClass> Product){
        Scanner input = new Scanner (System.in);
        System.out.println("To add a product, you need to enter some info:");
      
        //Enable user to add the ID
        int id ;
        while (true) {
            try{
                System.out.println("Enter product ID (positive number): ");
                id = Integer.parseInt(input.nextLine());
                if(id <= 0){
                    System.out.println("ID must be a positive number.");
                } else{
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");

            }
            
        }

        //Enable user to add the name
        System.out.println("Enter product name: ");
        String name = input.nextLine().trim();
        while(name.isEmpty()){
            System.out.println("Name cannot be empty. Enter product name: ");
            name = input.nextLine().trim();
        }


        //Enable user to add the quantity
        int quantity;
        while (true) {
            try {
                System.out.print("Enter product quantity: ");
                quantity = Integer.parseInt(input.nextLine());
                if (quantity < 0) {
                    System.out.println("Quantity cannot be negative.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }


        //Enable user to add the price
        double price ;
        while (true) {
            try{
                System.out.println("Enter product price: ");
                price = Double.parseDouble(input.nextLine());
                if(price < 0){
                    System.out.println("Price cannot be negative.");
                } else {
                    break;
                }
            } catch (NumberFormatException e){
                System.out.println("Invalid input. Please enter a valid number.");
            }
            
        }

        System.out.println("Enter product category: ");
        String category = input.nextLine().trim();
        while(category.isEmpty()){
            System.out.println("Category cannot be empty. Enter product category: ");
            category = input.nextLine().trim();
        }

        //Adding all details about the product
        Product.add(new ProductClass(id, name, quantity, price, category));
        System.out.println("Product added successfully!");

    }

    //Function to display all available inventory products
    public void viewProduct(ArrayList<ProductClass> Product){
        if (Product.isEmpty()){
            System.out.println("No products in the inventory");
        }else{
        System.out.println("Displaying all available products: ");
            for (ProductClass item : Product ){
                System.out.println(item);

            }
        }
               
    }

    //Function to search a product by ID or by name
    public void searchProduct(ArrayList<ProductClass> Product){
        System.out.println("Search by: ");
        System.out.println("1. ID");
        System.out.println("2. Name");
        Scanner input = new Scanner(System.in);
        int searchOption;

        //Validate user input for searching option
        while(true){
            try {
                searchOption = Integer.parseInt(input.nextLine());
                if (searchOption <1 || searchOption>2){
                    System.out.println("Please choose a valid option (1 or 2).");
                }else{
                    break;
                }
            } catch (NumberFormatException e){
                System.out.println("Invalid input. Please enter a number");
            }
        }
       
        boolean founded = false ;

        //Search by product ID
        if (searchOption == 1){
            System.out.println("Please enter the ID for search");
            int searchedID = input.nextInt();
            for(ProductClass item : Product){
                if(item.getId() == searchedID ){
                    System.out.println("Product founded: " + item );
                    founded=true;
                    break;
                }
            }
            if(founded==false){
                System.out.println("Product not founded");
            }

            //Search by product name
        }else if(searchOption == 2){
            System.out.println("Please enter the name for search");
            String searchedName = input.nextLine();
            for(ProductClass item : Product){
                if(item.getName().compareToIgnoreCase(searchedName)==0){
                    System.out.println("Product founded: " + item );
                    founded=true;
                    break;
                }
            }
            if(founded==false){
                System.out.println("Product not founded");
            }            
        }else{
            System.out.println("invalid search option");
        }
    }

    //Function for editing a product details
    public void editProduct(ArrayList<ProductClass> Product){

        System.out.println("Enter the product ID to edit: ");
        Scanner input = new Scanner(System.in);
        int searchedID = input.nextInt();
        // input.nextLine();
        boolean founded = false;

        for(ProductClass item : Product){
            if(item.getId() == searchedID ){
                founded=true;
                System.out.println("Product founded: " + item );
                System.out.println("Edit the product info: " );

                //Prompt the new name
                System.out.println("Enter new name: ");
                input.nextLine(); // Consume leftover newline
                String newName = input.nextLine();
                if( !newName.isEmpty()){
                    item.SetName(newName);
                }
                
                //Prompt the new quantity 
                System.out.println("Enter new quantity");
                String newQuantity = input.nextLine();
                if( !newQuantity.isEmpty()){
                    item.SetQuantity(Integer.parseInt(newQuantity));
                }
                
                //Prompt the new price
                System.out.println("Enter new price");
                String newPrice = input.nextLine();
                if( !newPrice.isEmpty()){
                    item.SetPrice(Double.parseDouble(newPrice));
                }
                
                //Prompt the new category
                System.out.println("Enter new Category");
                String newCategory = input.nextLine();
                if( !newCategory.isEmpty()){
                    item.SetCategory(newCategory);
                }
                
                System.out.println("Product updated successfully: " + item);
                
                break;
            }
        }

        if (founded==false){
            System.out.println("there is no product founded with this ID: " + searchedID);
        }


    }

    public void deleteProduct(ArrayList<ProductClass> Product) {
        System.out.println("Enter the product ID to delete: ");
        Scanner input = new Scanner(System.in);
        int searchedID = input.nextInt();
        input.nextLine(); // Consume the newline character
        boolean found = false;
    
        // Use Iterator for safe removal
        Iterator<ProductClass> iterator = Product.iterator();
    
        while (iterator.hasNext()) {
            ProductClass item = iterator.next();
            if (item.getId() == searchedID) {
                System.out.println("Product found: " + item);
                System.out.print("Are you sure you want to delete this product? (yes/no): ");
                String confirmation = input.nextLine();
    
                if (confirmation.equalsIgnoreCase("yes")) {
                    iterator.remove(); // Safely remove the product
                    System.out.println("Product deleted successfully!");
                } else {
                    System.out.println("Deletion cancelled.");
                }
    
                found = true;
                break;
            }
        }
    
        if (!found) {
            System.out.println("No product found with ID: " + searchedID);
        }
    }

    //Function to sort products by ID, name, quantity, price, or category
    public void sortProduct(ArrayList<ProductClass> Product){
        System.out.println("Choose what you need to sort by: ");
        System.out.println("1. Sort by ID");
        System.out.println("2. Sort by name");
        System.out.println("3. Sort by quantity");
        System.out.println("4. Sort by price");
        System.out.println("5. Sort by category");

        Scanner input = new Scanner(System.in);
        int sortChoice = input.nextInt();
        input.nextLine();
        switch (sortChoice) {

            //Enable user to sort IDs
            case 1:
            Collections.sort(Product, new Comparator<ProductClass>() {
                @Override
                public int compare(ProductClass p1, ProductClass p2){
                    return Integer.compare(p1.getId(), p2.getId());
                }
            });

            System.out.println("Products sorted by ID: ");
            for(ProductClass item : Product){
                System.out.println(item);
            }
                break;

            //Enable user to sort names
            case 2:
            Collections.sort(Product, new Comparator<ProductClass>() {
                @Override
                public int compare(ProductClass p1, ProductClass p2){
                    return p1.getName().compareToIgnoreCase(p2.getName());
                }
            });

            System.out.println("Products sorted by name: ");
            for(ProductClass item : Product){
                System.out.println(item);
            }
                break;

            //Enable user to sort quantities
            case 3:
            Collections.sort(Product, new Comparator<ProductClass>() {
                @Override
                public int compare(ProductClass p1, ProductClass p2){
                    return Integer.compare(p1.getQuantity(), p2.getQuantity());
                }
            });

            System.out.println("Products sorted by quantity: ");
            for(ProductClass item : Product){
                System.out.println(item);
            }
                break;

            //Enable user to sort prices
            case 4:
            Collections.sort(Product, new Comparator<ProductClass>() {
                @Override
                public int compare(ProductClass p1, ProductClass p2){
                    return Double.compare(p1.getPrice(), p2.getPrice());
                }
            });

            System.out.println("Products sorted by price: ");
            for(ProductClass item : Product){
                System.out.println(item);
            }
                break;    
            
            //Enable user to sort categories
            case 5:
            Collections.sort(Product, new Comparator<ProductClass>() {
                @Override
                public int compare(ProductClass p1, ProductClass p2){
                    return p1.getCategory().compareToIgnoreCase(p2.getCategory());
                }
            });

            System.out.println("Products sorted by category: ");
            for(ProductClass item : Product){
                System.out.println(item);
            }
                break;
        
        
            default:
                break;
        }
    }

    //Function to generate a statistical report for user
    public void generateReport(ArrayList<ProductClass> Product){
        int total_products=0;
        int total_quantities=0;
        int total_inventory=0;

        //For loop to calculate total quantities, total available inventory products, and total inventory value
        for( ProductClass item : Product){
            total_quantities += item.getQuantity();
            total_products++ ;
            total_inventory += (item.getQuantity()*item.getPrice());

        }

        //Displaying the report
        System.out.println("Here is a generated report:");
        System.out.println("Total products: " + total_products);
        System.out.println("Total quantities: " + total_quantities);
        System.out.println("Total value of inventory: " + total_inventory);

    }

}
