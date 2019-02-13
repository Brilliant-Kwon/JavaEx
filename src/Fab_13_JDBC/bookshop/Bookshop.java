package Fab_13_JDBC.bookshop;

import java.util.List;

public class Bookshop {
    public static void main(String[] args) {

        printAuthors();
//        insertAuthor("손건우", "두산 베어스");
//        updateAuthor(4L, "권찬근", "롯데 자이언츠");
//        deleteAuthor(6L);
        getAuthor(3L);
        getAuthor(5L);

    }

    private static void getAuthor(Long id) {
        AuthorDAO dao = new AuthorDAOImpl();
        AuthorVO authorVO = dao.get(id);
        if (authorVO != null) {
            System.out.printf("작가 %s를 찾았습니다.\n", authorVO);
        } else {
            System.out.println("작가를 찾지 못했습니다.");
        }
    }

    private static void deleteAuthor(Long id) {
        AuthorDAO dao = new AuthorDAOImpl();
        boolean success = dao.delete(id);

        if (success) {
            System.out.printf("저자 %d를 삭제했습니다. \n", id);
        } else {
            System.out.printf("저자 %d를 삭제하지 못 했습니다. \n", id);
        }
        printAuthors();
    }

    private static void updateAuthor(Long id, String name, String desc) {
        AuthorDAO dao = new AuthorDAOImpl();
        AuthorVO authorVO = new AuthorVO(id, name, desc);//디비에 입력할 객체
        boolean success = dao.update(authorVO);

        if (success) {
            System.out.printf("저자 %s를 업데이트했습니다.%n", authorVO);
        } else {
            System.out.printf("저자 %s를 업데이트하지 못 했습니다. %n", authorVO);
        }
        printAuthors();
    }

    private static void insertAuthor(String name, String desc) {
        AuthorDAO dao = new AuthorDAOImpl();
        AuthorVO authorVO = new AuthorVO(null, name, desc);//디비에 입력할 객체
        boolean success = dao.insert(authorVO);

        if (success) {
            System.out.printf("저자 %s를 추가했습니다.%n", authorVO);
        } else {
            System.out.printf("저자 %s를 추가하지 못 했습니다. %n", authorVO);
        }

        printAuthors();

    }

    private static void printAuthors() {
        AuthorDAO dao = new AuthorDAOImpl();
        List<AuthorVO> list = dao.getList();

        System.out.println("------------- 저자 목록 ------------");
        for (AuthorVO authorVO : list) {
            System.out.println(authorVO);
        }
    }
}
