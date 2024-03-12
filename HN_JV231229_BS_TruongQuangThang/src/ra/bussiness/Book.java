package ra.bussiness;

import java.util.Objects;
import java.util.Scanner;

public class Book {
    private static int currentId = 0;
    private int bookId;
    private String bookName;
    private String author;
    private String descriptions;
    private double importPrice;
    private double exportPrice;
    private float interest = (float) (exportPrice - importPrice);
    private boolean bookStatus = true;

    public Book(int bookId, String bookName, String author, String descriptions, double importPrice, double exportPrice, float interest, boolean bookStatus) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.descriptions = descriptions;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.interest = interest;
        this.bookStatus = bookStatus;
    }

    public Book() {
        this.bookId = currentId++;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public double getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(double importPrice) {
        this.importPrice = importPrice;
    }

    public double getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(double exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public boolean isBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }

    //    inputData nhập thông tin từ bàn phím trừ interest
    public void inputData(Scanner scanner) {
//      Nhập tên sách
        boolean checkName = false;
        do {
            System.out.println("Nhập tên sách");
            String inputName = scanner.nextLine();
            if (inputName != " ") {
                checkName = true;
                bookName = inputName;
                System.out.println("Tên hợp lệ");
            } else {
                System.out.println("Tên sách không được để trống !!! Vui lòng nhập lại.");
            }
        } while (!checkName);

//      Nhập tên tác giả\
        boolean checkAuthor = false;
        do {
            System.out.println("Nhập tên tác giả");
            String inputAuthor = scanner.nextLine();
            if (inputAuthor != " ") {
                checkAuthor = true;
                author = inputAuthor;
                System.out.println("Tên tác giả hợp lệ");
            } else {
                System.out.println("Tên tác giả không được để trống !!! Vui lòng nhập lại.");
            }
        } while (!checkAuthor);

//        Nhập mô tả sách
        boolean checkDesc = false;
        do {
            System.out.println("Nhập mô tẩ sách");
            String inputDesc = scanner.nextLine();
            if (!Objects.equals(inputDesc, " ") && inputDesc.length()>=10){
                checkDesc = true;
                descriptions = inputDesc;
                System.out.println("Mô tả sách hợp lệ");
            }else{
                System.out.println("Mô tả sách không được để trống và phải có ít nhất 10 ký tự");
            }
        } while (!checkDesc);

//        Nhập giá nhập > 0
        boolean checkImport = false;
        do {
            System.out.println("Nhập giá nhập của sản phẩm");
            double inputImport = Double.parseDouble(scanner.nextLine());
            if (inputImport > 0){
                importPrice = inputImport;
                System.out.println("Giá nhập hợp lệ");
                checkImport=true;
            }else{
                System.out.println("Giá nhập không hợp lệ");
            }
        }while(!checkImport);

//        Nhập giá xuất
        boolean checkExport = false;
        do {
            System.out.println("Nhập giá xuất của sản phẩm");
            double inputExport = Double.parseDouble(scanner.nextLine());
            if(inputExport > getImportPrice()*1.2){
                exportPrice = inputExport;
                checkExport = true;
                System.out.println("Giá xuất hợp lệ");
            }else{
                System.out.println("Giá xuất không hợp lệ !!! Vui lòng nhập lại.");
            }
        }while (!checkExport);
    }

    public void calInterest() {
        interest = (float) (exportPrice - importPrice);
    };

//    hiển thị các thông tin sách
public void displayData() {
    System.out.println("{" +
            "bookId='" + bookId + "\'" +
            ", bookName='" + bookName + "\'" +
            ", author=" + author +
            ", descriptions='" + descriptions + "\'" +
            ", importPrice=" + importPrice +
            ", exportPrice=" + exportPrice +
            ", interest=" + interest +
            ", status=" + (bookStatus ? "Đang bán" : "Không bán") +
            "}"
    );
    System.out.println("========================================");
}
}
