package com.example.pmd_se_a_java_2nd_file.CardViewExamples;

public class My_Model {
    public String Name;
    public int total_downloads;
    public int thumbnails;

    public String getName()
    {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getTotal_downloads() {
        return total_downloads;
    }

    public void setTotal_downloads(int total_downloads) {
        this.total_downloads = total_downloads;
    }

    public int getThumbnails() {
        return thumbnails;
    }

    public void setThumbnails(int thumbnails) {
        this.thumbnails = thumbnails;
    }

    public My_Model(String nmae, int totel_downloads, int thumbnails) {
        Name = nmae;
        this.total_downloads = totel_downloads;
        this.thumbnails = thumbnails;
    }
}
