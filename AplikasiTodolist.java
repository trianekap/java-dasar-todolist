public class AplikasiTodolist {

    public static String[] model = new String[10]; 
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);
    public static void main(String[] args) {
        testViewRemoveTodoList();
    }

    // untuk menampilan todolist
    public static void showTodoList(){
        System.out.println("TODOLIST");
        for(var i = 0; i < model.length; i++){
            var todo = model[i];
            var no = i + 1;

            if (todo != null) {
                System.out.println(no + ". " + todo);
            }
        }
    }

    // untuk testing show todo list
    public static void testShowTodoList(){
        model[0] = "Belajar Java";
        model[1] = "Studi Kasus Membuat Aplikasi TodoList";
        showTodoList();
    }

    // untuk menambahkan todo ke list
    public static void addTodoList(String todo){
        // cek apakah model nya sudah penuh
        var isFull = true;
        for (int i = 0; i < model.length; i++) {
            if (model[i] == null) {
                //masih ada yang kosong
                isFull = false;
                break;
            }
        }

        //jika penuh kita resize ukurannya menjadi 2x lipat
        if (isFull) {
            var temp = model;
            model = new String[model.length * 2];

            for (int i = 0; i < temp.length; i++) {
                model[i] = temp[i];
            }
        }

        // tambahkan ke posisi array yang datanya NULL
        for (int i = 0; i < model.length; i++) {
            if (model[i] == null) {
                model[i] = todo;
                break;
            }
        }
    }

    // untuk test addtodolist 
    public static void testAddTodoList(){
        for (int i = 0; i < 25; i++) {
            addTodoList("contoh todo list ke " + i);
        }

        showTodoList();
    }

    // untuk menghapus todo dari list
    public static boolean removeTodoList(Integer number){
        if ((number - 1) >= model.length) {
            return false;
        } else if (model[number -1] == null) {
            return false;
        } else {
            for (int i = (number - 1); i < model.length; i++) {
                if (i == (model.length - 1)) {
                    model[i] = null;
                } else {
                    model[i] = model[i + 1];
                }
            }

            return true;
        }
    }

    // untuk testing hapus todolist
    public static void testRemoveTodoList(){
        addTodoList("satu");
        addTodoList("dua");
        addTodoList("tiga");
        addTodoList("empat");
        addTodoList("lima");

        var result = removeTodoList(20);
        System.out.println(result);

        result = removeTodoList(7);
        System.out.println(result);

        result = removeTodoList(2);
        System.out.println(result);

        showTodoList();
    }

    public static String input(String info){
        System.out.print(info + " : ");
        String data = scanner.nextLine();
        return data;
    }

    public static void testInput(){
        var name = input("Nama");
        System.out.println("Hi " + name);

        var channel = input("Channel");
        System.out.println(channel);
    }


    // untuk menampilkan view todo list
    public static void viewShowTodolist(){
        while (true) {
            showTodoList();
            
            System.out.println("MENU : ");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("x. Keluar");

            var input = input("Pilih");

            if (input.equals("1")) {
                viewAddTodoList();
            } else if (input.equals("2")) {
                viewRemoveTodoList();
            } else if (input.equals("x")) {
                break;
            } else {
                System.out.println("pilihan menu tidak ada");
            }
        }
    }

    public static void testViewShowTodoList(){
        addTodoList("satu");
        addTodoList("dua");
        addTodoList("tiga");
        addTodoList("empat");
        addTodoList("lima");

        viewShowTodolist();
    }

    // untuk menampilkan view add todo list
    public static void viewAddTodoList(){
        System.out.println("MENAMBAH TODOLIST");

        var todo = input("Todo (x jika batal)");

        if (todo.equals("x")) {
            //batal
        } else {
            addTodoList(todo);
        }
    }

    // untuk test view add todolist
    public static void testViewAddTodoList(){
        addTodoList("satu");
        addTodoList("dua");

        viewAddTodoList();
        showTodoList();
    }

    // untuk menampilkan view remove todo list
    public static void viewRemoveTodoList(){
        System.out.println("MENGHAPUS TODOLIST");

        var number = input("Nomor yang dihapus (x jika batal)");

        if (number.equals("x")) {
            //batalkan
        } else {
            var success = removeTodoList(Integer.valueOf(number));
            if (!success) {
                System.out.println("Gagal menghapus todolist " + number);
            }
        }
    }

    // untuk test view remove todolist
    public static void testViewRemoveTodoList(){

        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");

        showTodoList();

        viewRemoveTodoList();

        showTodoList();
    }
}