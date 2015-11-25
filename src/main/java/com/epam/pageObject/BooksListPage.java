package com.epam.pageObject;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import java.text.Collator;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import static java.lang.Integer.compare;

//TODO Error in Author descending order

@DefaultUrl("http://ecsc00101f71.epam.com/books")
public class BooksListPage extends PageObject {

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

    public boolean checkBookOrder(String value) throws ParseException {
        boolean b = false;
        List<String> lst = new ArrayList<String>();
        switch (value) {
            case "Title":
                lst = listChanger(titleList);
                b = stringOrder(lst);
                break;
            case "Year":
                lst = listChanger(yearList);
                b = intOrder(lst);
                break;
            case "Authors":
                lst = stringConvert(authorList);
                b = stringOrder(lst);
                break;
            case "Publishers":
                lst = listChanger(publisherList);
                b = stringOrder(lst);
                break;
            case "Rating":
                lst = listChanger(ratingList);
                b = stringOrder(lst);
                break;
            case "Date":
                lst = listChanger(dateList);
                b = dateOrder(lst);
                break;
        }
        return b;
    }

    public boolean checkBookDescendingOrder(String value) throws ParseException {
        boolean b = false;
        List<String> lst = new ArrayList<String>();
        switch (value) {
            case "Title":
                lst = listChanger(titleList);
                b = stringDescendingOrder(lst);
                break;
            case "Year":
                lst = listChanger(yearList);
                b = intDescendingOrder(lst);
                break;
            case "Authors":
                lst = stringConvert(authorList);
                b = stringDescendingOrder(lst);
                break;
            case "Publishers":
                lst = listChanger(publisherList);
                b = stringDescendingOrder(lst);
                break;
            case "Rating":
                lst = listChanger(ratingList);
                b = intDescendingOrder(lst);
                break;
            case "Date":
                lst = listChanger(dateList);
                b = dateDescendingOrder(lst);
                break;
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
        String s2 = null;
        List<String> lst1 = new ArrayList<String>();
        int a = 0;
        int b = 0;
        for (int i = 0; i < lst.size(); i++) {
            s1 = lst.get(i).getText();
            a = s1.indexOf(" ");
            b = a + s1.indexOf(" ", a);
            if(b == 0) {
                s2 = s1.substring(a + 1);
            }
            else {
            //else if(b != 0) {
                s2 = s1.substring(a + 1, b);
            }
            lst1.add(i, s2);
        }
        return lst1;
    }

    public static boolean intOrder(List<String> lst) {
        int result = 0;
        boolean b = false;
        int a1 = 0;
        int a2 = 0;
        String s1 = new String();
        String s2 = new String();
        for (int i = 1; i < lst.size(); i++) {
            a1 = Integer.parseInt(lst.get(i - 1));
            System.out.println(a1);
            a2 = Integer.parseInt(lst.get(i));
            System.out.println(s2);
            result = compare(a1, a2);
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

    public static boolean intDescendingOrder(List<String> lst) {
        int result = 0;
        boolean b = false;
        int a1 = 0;
        int a2 = 0;
        String s1 = new String();
        String s2 = new String();
        for (int i = 1; i < lst.size(); i++) {
            a1 = Integer.parseInt(lst.get(i-1));
            System.out.println(a1);
            a2 = Integer.parseInt(lst.get(i));
            System.out.println(a2);
            if (a1 >= a2) {
                b = true;
            }
            else if (a1 < a2){
                b = false;
                break;
            }
            System.out.println(b);
        }
        return b;
    }

    public static boolean stringOrder(List<String> lst) {
        Collator myCollator = Collator.getInstance();
        int result;
        boolean b = false;
        String s1 = new String();
        String s2 = new String();
        for (int i = 1; i < lst.size(); i++) {
            s1 = lst.get(i - 1);
            System.out.println(s1);
            s2 = lst.get(i);
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

    public static boolean stringDescendingOrder(List<String> lst) {
        Collator myCollator = Collator.getInstance();
        int result;
        boolean b = false;
        String s1 = new String();
        String s2 = new String();
        for (int i = 1; i < lst.size(); i++) {
            s1 = lst.get(i - 1);
            System.out.println(s1);
            s2 = lst.get(i);
            System.out.println(s2);
            result = s1.compareTo(s2);
            System.out.println(result);
            if (result >= 0)
                b = true;
            else if(result < 0) {
                b = false;
                break;
            }
            System.out.println(b);
        }
        return b;
    }

    public static boolean dateOrder(List<String> lst) throws ParseException {
        int result;
        boolean b = false;
        String s1 = new String();
        String s2 = new String();
        Date date1 = new Date();
        Date date2 = new Date();
        int a = 0;
        for (int i = 1; i < lst.size()/2*2; i++) {
            s1 = lst.get(i - 1);
            a = s1.indexOf(" ");
            s1 = s1.substring(0, a);
            System.out.println(s1);
            s2 = lst.get(i);
            a = s2.indexOf(" ");
            s2 = s2.substring(0, a);
            System.out.println(s2);
            DateFormat format = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
            date1 = format.parse(s1);
            date2 = format.parse(s2);
            result = date1.compareTo(date2);
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

    public static boolean dateDescendingOrder(List<String> lst) throws ParseException {
        int result;
        boolean b = false;
        String s1 = new String();
        String s2 = new String();
        Date date1 = new Date();
        Date date2 = new Date();
        int a = 0;
        for (int i = 1; i < lst.size()/2*2; i++) {
            s1 = lst.get(i - 1);
            a = s1.indexOf(" ");
            s1 = s1.substring(0, a);
            System.out.println(s1);
            s2 = lst.get(i);
            a = s2.indexOf(" ");
            s2 = s2.substring(0, a);
            System.out.println(s2);
            DateFormat format = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
            date1 = format.parse(s1);
            date2 = format.parse(s2);
            result = date1.compareTo(date2);
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
}
