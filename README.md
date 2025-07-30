# **InventoryMaster - Java Inventory Management System**  
**File:** `InventorySystem.java`  

### **Core Features**  
- **Product Management**  
  - Add/View/Edit/Delete products  
  - Input validation for all fields  
- **Advanced Search**  
  → By ID (exact match)  
  → By Name (case-insensitive)  
- **Multi-criteria Sorting**  
  ```plaintext
  1. ID      3. Quantity  5. Category  
  2. Name    4. Price  

### **Technical Highlights**  
- **OOP Design**: Separate `ProductClass` entity  
- **Data Structures**: `ArrayList<ProductClass>`  
- **Sorting**: `Collections.sort()` with custom `Comparator`  
- **Reporting**:  
  ```bash  
  Total products: 4  
  Total quantities: 186  
  Inventory value: $1,023,785  
