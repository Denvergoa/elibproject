package com.epam.pageObject;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

import java.text.Collator;
import java.util.ArrayList;
import java.util.List;

@DefaultUrl("http://ecsc00101f71.epam.com/books")
public class BookPage extends PageObject {

    @FindBy(xpath = "//*[@id='books']/div[3]/div/ul")
    List<WebElementFacade> booksList;
    @FindBy(xpath = ".//*[@id='books']/div[3]/div/ul//div//ul")
    List<WebElementFacade> authorList;
    @FindBy(xpath = ".//*[@id='books']/div[3]/div/ul//div//a/strong")
    List<WebElementFacade> titleList;
    @FindBy(xpath = ".//*[@id='books']/div[3]/div/ul//span[2]")
    List<WebElementFacade> yearList;
    @FindBy(xpath = ".//*[@id='books']/div[3]/div/ul//span[1]")
    List<WebElementFacade> publisherList;
    @FindBy(xpath = ".//*[@id='books']/div[3]/div/ul//span[4]")
    List<WebElementFacade> ratingList;
    @FindBy(xpath = ".//*[@id='books']/div[3]/div/ul//span[6]")
    List<WebElementFacade> dateList;
    @FindBy(xpath = ".//sorting-directive//li[1]")
    WebElementFacade titleOrderField;
    @FindBy(xpath = ".//sorting-directive//li[2]")
    WebElementFacade yearOrderField;
    @FindBy(xpath = ".//sorting-directive//li[3]")
    WebElementFacade authorOrderField;
    @FindBy(xpath = ".//sorting-directive//li[4]")
    WebElementFacade publisherOrderField;
    @FindBy(xpath = ".//sorting-directive//li[5]")
    WebElementFacade ratingOrderField;
    @FindBy(xpath = ".//sorting-directive//li[6]")
    WebElementFacade dateOrderField;
    @FindBy(xpath = ".//sorting-directive//li[1]/span[2]")
    WebElementFacade titleOrderArrow;
    @FindBy(xpath = ".//sorting-directive//li[2]/span[2]")
    WebElementFacade yearOrderArrow;
    @FindBy(xpath = ".//sorting-directive//li[3]/span[2]")
    WebElementFacade authorOrderArrow;
    @FindBy(xpath = ".//sorting-directive//li[4]/span[2]")
    WebElementFacade publisherOrderArrow;
    @FindBy(xpath = ".//sorting-directive//li[5]/span[2]")
    WebElementFacade ratingOrderArrow;
    @FindBy(xpath = ".//sorting-directive//li[6]/span[2]")
    WebElementFacade dateOrderArrow;

    public void orderByValue(String value) {
        switch (value) {
            case "Title":
                titleOrderField.click();
                break;
            case "Year":
                yearOrderField.click();
                break;
            case "Authors":
                authorOrderField.click();
                break;
            case "Publishers":
                publisherOrderField.click();
                break;
            case "Rating":
                ratingOrderField.click();
                break;
            case "Date":
                dateOrderField.click();
                break;
        }
    }

    public boolean checkPresenceOfArrow(String value) {
        boolean presence = false;
        switch (value) {
            case "Title":
                presence = titleOrderArrow.isPresent();
                break;
            case "Year":
                presence = yearOrderArrow.isPresent();
                break;
            case "Authors":
                presence = authorOrderArrow.isPresent();
                break;
            case "Publishers":
                presence = publisherOrderArrow.isPresent();
                break;
            case "Rating":
                presence = ratingOrderArrow.isPresent();
                break;
            case "Date":
                presence = dateOrderArrow.isPresent();
                break;
        }
        return presence;
    }

    public boolean checkBookOrder(String value) {
        Collator myCollator = Collator.getInstance();
        int result;
        boolean b = false;
        String s1 = new String();
        String s2 = new String();
        List<String> lst = new ArrayList<String>();
        switch (value) {
            case "Title":
                lst = listChanger(titleList);
                break;
            case "Year":
                lst = listChanger(yearList);
                break;
            case "Authors":
                lst = stringConvert(authorList);
                break;
            case "Publishers":
                lst = listChanger(publisherList);
                break;
            case "Rating":
                lst = listChanger(ratingList);
                break;
            case "Date":
                lst = listChanger(dateList);
                break;
        }
        for (int i = 1; i < lst.size(); i++) {
                s1 = lst.get(i);
                System.out.println(s1);
                s2 = lst.get(i - 1);
                System.out.println(s2);
                result = myCollator.compare(s1, s2);
                System.out.println(result);
                if (result <= 0)
                    b = true;
                else {
                    b = false;
                    break;
                }
                System.out.println(b);
            }
        return b;
    }

    public boolean checkBookDescendingOrder(String value) {
        Collator myCollator = Collator.getInstance();
        int result;
        boolean b = false;
        String s1 = new String();
        String s2 = new String();
        List<String> lst = new ArrayList<String>();
        switch (value) {
            case "Title":
                lst = listChanger(titleList);
                break;
            case "Year":
                lst = listChanger(yearList);
                break;
            case "Authors":
                lst = stringConvert(authorList);
                break;
            case "Publishers":
                lst = listChanger(publisherList);
                break;
            case "Rating":
                lst = listChanger(ratingList);
                break;
            case "Date":
                lst = listChanger(dateList);
                break;
        }
        for (int i = 1; i < lst.size(); i++) {
            s1 = lst.get(i);
            System.out.println(s1);
            s2 = lst.get(i - 1);
            System.out.println(s2);
            result = myCollator.compare(s1, s2);
            System.out.println(result);
            if (result >= 0)
                b = true;
            else {
                b = false;
                break;
            }
            System.out.println(b);
        }
        return b;
    }

    public boolean checkNullBookOrder(String value) {
        boolean b = false;
        List<String> lst = new ArrayList<String>();
        switch (value) {
            case "Title":
                lst = listChanger(titleList);
                break;
            case "Year":
                lst = listChanger(yearList);
                break;
            case "Authors":
                lst = stringConvert(authorList);
                break;
            case "Publishers":
                lst = listChanger(publisherList);
                break;
            case "Rating":
                lst = listChanger(ratingList);
                break;
            case "Date":
                lst = listChanger(dateList);
                break;
        }
        int indexOfFirstNull = lst.indexOf(null);
        if (indexOfFirstNull == -1) {
            b = true;
        } else {
            if (lst == null || lst.isEmpty()) {
                b = false;
            }
            boolean nullsFinished = false;
            for (int i = lst.size() - 1; i >= 0; i--) {
                if (lst.get(i) != null) {
                    nullsFinished = true;
                    b = true;
                } else {
                    if (nullsFinished) {
                        return false;
                    }
                }
            }
        }
        return b;
    }

    public static List<String> listChanger(List<WebElementFacade> lst) {
        List<String> lst1 = new ArrayList<String>();
        for (int i = 0; i < lst.size(); i++) {
            lst1.add(i, lst.get(i).getText());
        }
        return lst1;
    }

    public static List<String> stringConvert(List<WebElementFacade> lst) {
        String s1;
        String s2;
        List<String> lst1 = new ArrayList<String>();
        int a;
        for (int i = 0; i < lst.size(); i++) {
            s1 = lst.get(i).getText();
            a = s1.indexOf(" ");
            s2 = s1.substring(a + 1);
            lst1.add(i, s2);
        }
        return lst1;
    }
}








//
//    public boolean checkCorrectBookOrdering(String value) throws ParseException {
////        Collator myCollator = Collator.getInstance();
//        String s1 = new String();
//        String s2 = new String();
//        Date date1 = new Date();
//        Date date2 = new Date();
//        boolean b = false;
////        int result = 0;
//        for (int i = 1; i < booksList.size(); i++) {
//            switch (value) {
//                case "Authors":
//                    bookOrderForAuthor(stringConvert(authorList), b);
////                    s1 = booksList.get(i).findElement((By) titleField).getText();
////                    s2 = booksList.get(i - 1).findElement((By) titleField).getText();
//                case "Year":
//                    bookOrder(yearList, b);
////                    s1 = booksList.get(i).findElement((By) yearField).getText();
////                    s2 = booksList.get(i - 1).findElement((By) yearField).getText();
//                case "Title":
//                    bookOrder(titleList, b);
////                    s1 = booksList.get(i).findElement((By) authorField).getText();
////                    s2 = booksList.get(i - 1).findElement((By) authorField).getText();
//                case "Publishers":
//                    bookOrder(publisherList, b);
////                    s1 = booksList.get(i).findElement((By) publisherField).getText();
////                    s2 = booksList.get(i - 1).findElement((By) publisherField).getText();
//                case "Rating":
//                    bookOrder(ratingList, b);
////                    s1 = booksList.get(i).findElement((By) ratingField).getText();
////                    s2 = booksList.get(i - 1).findElement((By) ratingField).getText();
//                case "Date":
//                    bookOrderByDate(dateList, b);
////                    s1 = booksList.get(i).findElement((By) dateField).getText();
////                    s2 = booksList.get(i - 1).findElement((By) dateField).getText();
////                    DateFormat format = new SimpleDateFormat("MM/dd/yy hh:mm a", Locale.ENGLISH);
////                    date1 = format.parse(s1);
////                    date2 = format.parse(s2);
//            }
////
////            if (date1 != null) {
////                result = date2.compareTo(date1);
////            } else result = myCollator.compare(s1, s2);
////            if (result >= 0) b = true;
////            else break;
//        }
//        return b;
//    }

//    public static boolean endsWithNulls(List<String> lst, boolean b) {
//        int indexOfFirstNull = lst.indexOf(null);
//        if (indexOfFirstNull == -1) {
//            b = true;
//        } else {
//            if (lst == null || lst.isEmpty()) {
//                b = false;
//            }
//            boolean nullsFinished = false;
//            for (int i = lst.size() - 1; i >= 0; i--) {
//                if (lst.get(i) != null) {
//                    nullsFinished = true;
//                    b = true;
//                } else {
//                    if (nullsFinished) {
//                        return false;
//                    }
//}
//        }
//        return b;
//        }

    //public static boolean bookOrderByDate(List<WebElementFacade> lst, boolean b) throws ParseException {
//        int result;
//        String s1 = new String();
//        String s2 = new String();
//        Date date1 = new Date();
//        Date date2 = new Date();
//        for (int i = 1; i < lst.size(); i++) {
//            s1 = lst.get(i).getText();
//            s2 = lst.get(i - 1).getText();
//            DateFormat format = new SimpleDateFormat("MM/dd/yy hh:mm a", Locale.ENGLISH);
//            date1 = format.parse(s1);
//            date2 = format.parse(s2);
//            result = date2.compareTo(date1);
//            if (result >= 0) b = true;
//            else {
//                b = false;
//                break;
//            }
//        }
//        return b;
//    }
//
//    public static boolean bookOrder(List<WebElementFacade> lst, boolean b) {
//        Collator myCollator = Collator.getInstance();
//        int result;
//        String s1 = new String();
//        String s2 = new String();
//        for (int i = 1; i < lst.size(); i++) {
//            s1 = lst.get(i).getText();
//            s2 = lst.get(i - 1).getText();
//            result = myCollator.compare(s1, s2);
//            if (result <= 0) b = true;
//            else {
//                b = false;
//                break;
//            }
//        }
//        return b;
//    }
//
//    public static boolean bookOrderForAuthor(List<String> lst, boolean b) {
//        Collator myCollator = Collator.getInstance();
//        int result;
//        String s1 = new String();
//        String s2 = new String();
//        for (int i = 1; i < lst.size(); i++) {
//            s1 = lst.get(i);
//            s2 = lst.get(i - 1);
//            result = myCollator.compare(s1, s2);
//            if (result >= 0) b = true;
//            else {
//                b = false;
//                break;
//            }
//        }
//        return b;
//    }