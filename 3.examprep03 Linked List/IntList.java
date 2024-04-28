public class IntList {
    public int first;
    public IntList rest;

    public IntList(int f, IntList r) {
        this.first = f;
        this.rest = r;
    }

    public static void evenOdd(IntList lst) {
        if (lst == null || lst.rest == null) {
            return;
        }
        IntList p = lst.rest;
        IntList second = lst.rest;
        while (p != null && p.rest != null) {
            lst.rest = p.rest;
            p.rest = lst.rest.rest;
            p = p.rest;
            lst = lst.rest;
        }
        lst.rest = second;
    }

    public static IntList reverse(IntList lst) {
        if (lst.rest == null) return lst;
        IntList p = lst.rest;
        IntList head = lst; //保存目前链表的头结点
        while(p != null){
            lst.rest = lst.rest.rest;
            p.rest = head;
            head = p;
            p = lst.rest;
        }
        return head;
    }

    public static IntList[] partition(IntList lst, int k){
        IntList[] array = new IntList[k];
        int index = 0;
        IntList L = reverse(lst);
        while (L != null) {
            IntList p = array[index];
            array[index] = L;
            L = L.rest;
            array[index].rest = p;
            index = (index + 1) % array.length;
        }
        return array;
    }

    public static void main(String[] args) {
        IntList lst1 = new IntList(0, null);
        lst1.rest = new IntList(3, null);
        lst1.rest.rest = new IntList(1, null);
        lst1.rest.rest.rest = new IntList(4, null);
        lst1.rest.rest.rest.rest = new IntList(2, null);
        lst1.rest.rest.rest.rest.rest = new IntList(5, null);
        //lst1.rest.rest.rest.rest.rest.rest = new IntList(100, null);
        IntList.evenOdd(lst1);
        lst1 = IntList.reverse(lst1);
        IntList p = lst1;
        while (p != null) {
            System.out.println(p.first);
            p = p.rest;
        }
        IntList[] array1 = IntList.partition(lst1, 3);
        for(int i = 0; i < array1.length; i++){
            p = array1[i];
            while(p != null){
                System.out.print(p.first + " ");
                p = p.rest;
            }
            System.out.println();
        }
    }
}