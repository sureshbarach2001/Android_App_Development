package com.example.pmd_se_a_java_2nd_file.ClassActivity;

public class ValueSet {
    String Name, Company, Price;

    public ValueSet() {
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCompany() {
        return Company;
    }

    public void setCompany(String company) {
        Company = company;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public ValueSet(String name, String company, String price) {
        Name = name;
        Company = company;
        Price = price;
    }
}
