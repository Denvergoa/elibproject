package com.epam.pageObject;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import java.text.Collator;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PublishersPage extends PageObject {

    @FindBy(xpath = ".//*[@id='publishers']/ul[1]//p")
    List<WebElementFacade> publisherList;
    @FindBy(xpath = "//sorting-directive//li")
    WebElementFacade nameOrderField;
    @FindBy(xpath = "//sorting-directive//li/span[2]")
    WebElementFacade nameOrderArrow;


    public void orderByValue(String value) {
        switch (value) {
            case "Name":
                nameOrderField.click();
                break;
        }
    }

    public boolean checkPresenceOfArrow(String value) {
        boolean presence = false;
        switch (value) {
            case "Name":
                presence = nameOrderArrow.isPresent();
        }
        return presence;
    }

    public boolean checkCorrectBookOrdering(String value) throws ParseException {
        Collator myCollator = Collator.getInstance();
        int result;
        boolean b = false;
        String s1 = new String();
        String s2 = new String();
        List<String> lst = new ArrayList<String>();
        switch (value) {
            case "Name":
                lst = listChanger(publisherList);
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
            case "Name":
                lst = listChanger(publisherList);
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

    public boolean checkNullBookOrder(String value) { boolean b = false;
        List<String> lst = new ArrayList<String>();
        switch (value) {
            case "Name":
                lst = listChanger(publisherList);
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


}
