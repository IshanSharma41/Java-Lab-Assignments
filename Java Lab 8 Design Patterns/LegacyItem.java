import java.util.*;

// ---------------- PRODUCT INTERFACE ----------------
interface Product {
    void displayDetails();
}

// ---------------- LEGACY ITEM CLASS ----------------
class LegacyItem {
    private int itemId;
    private String description;

    // Parameterized Constructor
    public LegacyItem(int itemId, String description) {
        this.itemId = itemId;
        this.description = description;
    }

    // Print method
    public void print() {
        System.out.println("Legacy Item -> ID: " + itemId + ", Description: " + description);
    }
}

// ---------------- ADAPTER CLASS ----------------
class ProductAdapter implements Product {
    private LegacyItem legacyItem;

    // Constructor accepts LegacyItem
    public ProductAdapter(LegacyItem legacyItem) {
        this.legacyItem = legacyItem;
    }

    // Override displayDetails()
    public void displayDetails() {
        legacyItem.print();
    }
}

// ---------------- NEW PRODUCT CLASS ----------------
class NewProduct implements Product {
    private String name;

    // Constructor
    public NewProduct(String name) {
        this.name = name;
    }

    // Override displayDetails()
    public void displayDetails() {
        System.out.println("New Product -> Name: " + name);
    }
}

// ---------------- INVENTORY MANAGER (SINGLETON) ----------------
class InventoryManager {

    private static InventoryManager instance;
    private List<Product> productList;

    // Private Constructor
    private InventoryManager() {
        productList = new ArrayList<>();
    }

    // Singleton Instance
    public static InventoryManager getInstance() {
        if (instance == null) {
            instance = new InventoryManager();
        }
        return instance;
    }

    // Add Product
    public void addProduct(Product p) {
        productList.add(p);
    }

    // Return Iterator
    public Iterator<Product> returnInventory() {
        return productList.iterator();
    }
}

// ---------------- MAIN CLASS ----------------
public class MainApp {
    public static void main(String[] args) {

        // Singleton Instance
        InventoryManager manager = InventoryManager.getInstance();

        // Adding New Products
        manager.addProduct(new NewProduct("Laptop"));
        manager.addProduct(new NewProduct("Mobile"));
        manager.addProduct(new NewProduct("Tablet"));

        // Adding Legacy Items using Adapter
        LegacyItem item1 = new LegacyItem(101, "Old Printer");
        LegacyItem item2 = new LegacyItem(102, "Old Scanner");

        manager.addProduct(new ProductAdapter(item1));
        manager.addProduct(new ProductAdapter(item2));

        // Iterator
        Iterator<Product> iterator = manager.returnInventory();

        System.out.println("Inventory Details:");
        System.out.println("---------------------------");

        while (iterator.hasNext()) {
            Product p = iterator.next();
            p.displayDetails();
        }
    }
}

