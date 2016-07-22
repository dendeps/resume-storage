import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayList;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int size = 0;

    void clear() {
        for(int i=0;i<storage.length;i++){
            storage[i]=null;
        }
        size = 0;

        System.out.println("Cleared");
    }

    void save(Resume r) {
        for(int i=0;i<storage.length;i++){
            if(storage[i]==null){
                storage[i]=r;
                size++;

                System.out.println(storage[i].uuid+" Saved with index "+i);
                break;
            }
        }
    }

    Resume get(String uuid) {
        for(int i=0;i<storage.length;i++){
            if((storage[i]!=null) && uuid.equals(storage[i].uuid)){
                return storage[i];
            }
        }
        System.out.println(uuid+" not found");
        return null;
    }

    void delete(String uuid) {
        for(int i=0;i<storage.length;i++){
            if((storage[i]!=null) && uuid.equals(storage[i].uuid)){
                storage[i]=null;
                size--;
                System.out.println("Deleted: "+ uuid);
                return;
            }
        }
        System.out.println(uuid+" not found");
        return;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */

    Resume[] getAll() {

        Resume[] allResume = new Resume[size];

        int k=0;

        for(int i=0;i<storage.length;i++){
            if(storage[i]!=null){
                allResume[k]=storage[i];
                k++;
            }
        }

        return allResume;

    }

    int size() {
        return size;
    }
}
