import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Test for com.urise.webapp.storage.ArrayStorage
 */
public class MainArray {
    private final static ArrayStorage ARRAY_STORAGE = new ArrayStorage();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Resume r;
        while (true) {
            System.out.print("Введите одну из команд - (1 = list | 2. size. | 3. save uuid | 4. delete uuid | 5. get uuid | 6. clear | 7. exit): ");
            String[] params = reader.readLine().trim().toLowerCase().split(" ");
            if (params.length < 1 || params.length > 2) {
                System.out.println("Неверная команда.");
                continue;
            }
            String uuid = null;
            if (params.length == 2) {
                uuid = params[1].intern();
            }

            switch ( Integer.parseInt(params[0])) {
                case 1: //"list":
                    printAll();
                    break;
                case 2: //"size":
                    System.out.println(ARRAY_STORAGE.size());
                    break;
                case 3: //"save":
                    r = new Resume();
                    r.uuid = uuid;
                    ARRAY_STORAGE.save(r);
                    printAll();
                    break;
                case 4: //"delete":
                    ARRAY_STORAGE.delete(uuid);
                    printAll();
                    break;
                case 5: //"get":
                    System.out.println(ARRAY_STORAGE.get(uuid));
                    break;
                case 6: //"clear":
                    ARRAY_STORAGE.clear();
                    printAll();
                    break;
                case 7: //"exit":
                    return;
                default:
                    System.out.println("Неверная команда.");
                    break;
            }
        }
    }

    static void printAll() {
        Resume[] all = ARRAY_STORAGE.getAll();
        System.out.println("----------------------------");
        if (all.length == 0) {
            System.out.println("Empty");
        } else {
            for (Resume r : all) {
                System.out.println(r);
            }
        }
        System.out.println("----------------------------");
    }
}