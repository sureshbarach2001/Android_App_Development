package com.example.pmd_se_a_java_2nd_file.FirebaseExamples;

public class Student {
    String Name, Url;

    public Student() {
    }

    public Student(String name, String url) {
        Name = name;
        Url = url;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }
}
