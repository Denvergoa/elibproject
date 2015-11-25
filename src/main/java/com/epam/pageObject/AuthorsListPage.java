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


@DefaultUrl("http://ecsc00101f71.epam.com/authors")
public class AuthorsListPage extends PageObject {

    @FindBy(xpath = "//ng-view//ul//div/div[2]/a/strong")
    List<WebElementFacade> authorList;
    @FindBy(xpath = "//ng-view/div/div/div[3]/div/ul//p")
    List<WebElementFacade> dateList;
    @FindBy(xpath = "//sorting-directive/ul/li[1]")
    WebElementFacade firstNameOrderField;
    @FindBy(xpath = "//sorting-directive/ul/li[2]")
    WebElementFacade lastNameOrderField;
    @FindBy(xpath = "//sorting-directive/ul/li[3]")
    WebElementFacade dateOfBirthOrderField;
    @FindBy(xpath = "//sorting-directive/ul/li[1]/span[2]")
    WebElementFacade firstNameOrderArrow;
    @FindBy(xpath = "//sorting-directive/ul/li[2]/span[2]")
    WebElementFacade lastNameOrderArrow;
    @FindBy(xpath = "//sorting-directive/ul/li[3]/span[2]")
    WebElementFacade dateOfBirthOrderArrow;

    public void orderByValue(String value) {
        switch (value) {
            case "FirstName":
                firstNameOrderField.click();
                break;
            case "LastName":
                lastNameOrderField.click();
                break;
            case "DateOfBirth":
                dateOfBirthOrderField.click();
                break;
        }
    }

    public boolean checkPresenceOfArrow(String value) {
        boolean presence = false;
        switch (value) {
            case "FirstName":
                presence = firstNameOrderArrow.isPresent();
                break;
            case "LastName":
                presence = lastNameOrderArrow.isPresent();
                break;
            case "DateOfBirth":
                presence = dateOfBirthOrderArrow.isPresent();
                break;
        }
        return presence;
    }

    public boolean checkCorrectBookOrdering(String value) throws ParseException {
        boolean b = false;
        List<String> lst = new ArrayList<String>();
        switch (value) {
            case "FirstName":
                lst = firstNameListMaker(authorList);
                b = stringOrder(lst);
                break;
            case "LastName":
                lst = stringConvert(authorList);
                b = stringOrder(lst);
                break;
            case "DateOfBirth":
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
            case "FirstName":
                lst = firstNameListMaker(authorList);
                b = stringDescendingOrder(lst);
                break;
            case "LastName":
                lst = stringConvert(authorList);
                b = stringDescendingOrder(lst);
                break;
            case "DateOfBirth":
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
            case "FirstName":
                lst = firstNameListMaker(authorList);
                break;
            case "LastName":
                lst = stringConvert(authorList);
                break;
            case "DateOfBirth":
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

    public static List<String> firstNameListMaker(List<WebElementFacade> lst) {
        String s1;
        String s2;
        List<String> lst1 = new ArrayList<String>();
        int a;
        for (int i = 0; i < lst.size(); i++) {
            s1 = lst.get(i).getText();
            a = s1.indexOf(" ");
            s2 = s1.substring(0, a);
            lst1.add(i, s2);
        }
        return lst1;
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
            DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
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
            DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
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

