package ru.aston.homework.module5.proxy;

public class RealImage implements Image {
    private final String url;

    public RealImage(String url) {
        this.url = url;
        loadImage();
    }

    private void loadImage() {}

    @Override
    public void display() {}
}
