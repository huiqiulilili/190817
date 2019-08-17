import java.util.Arrays;

public class Main  implements List{

    int[] array = null;
    int size = 0;
    int capacity ;
    private void ensureCapacity(){
        if(array != null && size < array.length){
            return;
        }
        if(array == null){
            capacity = 10;
        }else{
            capacity = 2 * capacity;
        }
            if(array != null){
                array = Arrays.copyOf(array,capacity);
            }else{
                array = new int[capacity];
            }

    }

    @Override
    public boolean add(int element) {
        add(size ,element);
        return true;
    }

    @Override
    public boolean add(int index, int element) {
        if(index < 0 || index > size){
            System.out.println("下标错误");
            return false;
        }else{
            ensureCapacity();
//            for(int i = size - 1;i >= index;i --){
//                array[i+1] = array[i];
//            }
//            array[index] = element;
            System.arraycopy(array,index,array,index + 1,size - index);
        }
        array[index] = element;
        size++;
        return true;
    }

    @Override
    public int get(int index) {
        if(index < 0 || index > size){
            System.out.println("下标错误");
            return -1;
        }
        return array[index];
    }

    @Override
    public int set(int index, int val) {
        if(index < 0 || index > size){
            System.out.println("下标错误");
            return -1;
        }
        int oldValu = array[index];
        array[index] = val;
        return oldValu;

    }

    @Override
    public int remove(int index) {
        if(index < 0 || index > size){
            System.out.println("下标错误");
            return -1;
        }else{
            int c = array[index];
            System.arraycopy(array,index + 1,array,index ,size - index - 1);
            size --;
            return c;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if(size == 0){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public Iterator iterator() {
        return null;
    }
}
