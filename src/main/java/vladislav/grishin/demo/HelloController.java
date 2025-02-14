package vladislav.grishin.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class HelloController {

        // In-memory list to store items
        private List<String> items = new ArrayList<>();

        // GET /hello - Returns "Hello, World!"
        @GetMapping("/hello")
        public String sayHello() {
            return "Hello, World!";
        }

        // GET /items - Returns all items
        @GetMapping("/items")
        public List<String> getAllItems() {
            return items;
        }

        // GET /items/{id} - Returns a specific item by ID
        @GetMapping("/items/{id}")
        public String getItemById(@PathVariable int id) {
            if (id >= 0 && id < items.size()) {
                return items.get(id);
            } else {
                throw new IllegalArgumentException("Item not found with ID: " + id);
            }
        }

        // POST /items - Adds a new item
        @PostMapping("/items")
        public String addItem(@RequestBody String item) {
            items.add(item);
            return "Item added: " + item;
        }

        // PUT /items/{id} - Updates an existing item by ID
        @PutMapping("/items/{id}")
        public String updateItem(@PathVariable int id, @RequestBody String updatedItem) {
            if (id >= 0 && id < items.size()) {
                items.set(id, updatedItem);
                return "Item updated: " + updatedItem;
            } else {
                throw new IllegalArgumentException("Item not found with ID: " + id);
            }
        }

        // DELETE /items/{id} - Deletes an item by ID
        @DeleteMapping("/items/{id}")
        public String deleteItem(@PathVariable int id) {
            if (id >= 0 && id < items.size()) {
                String deletedItem = items.remove(id);
                return "Item deleted: " + deletedItem;
            } else {
                throw new IllegalArgumentException("Item not found with ID: " + id);
            }
        }
}
