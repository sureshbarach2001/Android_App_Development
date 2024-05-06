package com.example.pmd_se_a_java_2nd_file.RecyclerViewExample;

public class MyMobiles
{
    private String Name, Company, Price;

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
    public MyMobiles(String name, String company, String price) {
        Name = name;
        Company = company;
        Price = price;
    }
}
