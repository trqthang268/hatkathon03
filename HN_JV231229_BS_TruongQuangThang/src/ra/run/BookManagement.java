package ra.run;

import ra.bussiness.Book;

import java.util.Scanner;

public class BookManagement {
    private static Book[] books = new Book[100];
    private static int length = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println(
                    "****************JAVAVAVA-HACKATATHON-05-BASIC-MENU***************\n" +
                            "1. Nhập số lượng sách thêm mới và nhập thông tin cho từng cuốn sách \n" +
                            "2. Hiển thị thông tin tất cả sách trong thư viện \n" +
                            "3. Sắp xếp sách theo lợi nhuận tăng dần \n" + "" +
                            "4. Xóa sách theo mã sách \n" +
                            "5. Tìm kiếm tương đối sách theo tên sách hoặc mô tả \n" +
                            "6. Thay đổi thông tin sách theo mã sách \n" +
                            "7. Thoát");
            System.out.println("Xin mời lựa chọn chức năng");
            switch (Integer.parseInt(scanner.nextLine())) {
                case 1:
                    createBook();
                    break;
                case 2:
                    showAllBook();
                    break;
                case 3:
                    sortInterest();
                    break;
                case 4:
                    deleteBook();
                    break;
                case 5:
                    searchBook();
                    break;
                case 6:
                    updataBook();
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Nhập liệu sai !!! Xin hãy thực hiện lại");
            }
        } while (true);
    }

    public static void createBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số lượng sách muốn thêm mới :");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            books[length] = new Book();
            books[length].inputData(scanner);
            books[length].calInterest();
            length++;
        }
    }

    public static void showAllBook() {
        for (int i = 0; i < length; i++) {
            books[i].displayData();
        }
    }

    public static void sortInterest() {
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (books[i].getInterest() > books[j].getInterest()) {
                    Book temp = books[i];
                    books[i] = books[j];
                    books[j] = temp;
                }
            }
        }
        System.out.println("Đã sắp xếp sách theo lợi nhuận tăng dần");
    }

    public static void deleteBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập mã sản phẩm muốn xóa :");
        int delBookId = Integer.parseInt(scanner.nextLine());
        boolean checkDel = false;
        for (int i = 0; i < length; i++) {
            if (books[i].getBookId() == delBookId) {
                checkDel = true;
                for (int j = i; j < length - 1; j++) {
                    books[j] = books[j + 1];
                }
                length--;
                System.out.println("Đã xóa sản phẩm có mã : " + delBookId);
                break;
            }
        }
        if (!checkDel) {
            System.out.println("Không tìm thấy sản phẩm có mã:" + delBookId);
        }
    }

    public static void searchBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mời bạn nhập tên sách cần tìm");
        String inputSearch = scanner.nextLine();
        boolean checkName = false;
        for (int i = 0; i < length; i++) {
            if (books[i].getBookName().equals(inputSearch) || books[i].getDescriptions().equals(inputSearch)) {
                books[i].displayData();
                checkName = true;
            }
        }
        if (!checkName) {
            System.out.println("Không có sản phẩm cần tìm");
        }
    }

    public static void updataBook(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập mã sách muốn sửa");
        int n =Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < length; i++) {
            if (books[i].getBookId()==n){
                books[i].inputData(scanner);
            }
        }
    }
}
