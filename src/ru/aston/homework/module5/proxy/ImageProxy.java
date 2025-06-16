package ru.aston.homework.module5.proxy;

public class ImageProxy implements Image {
    private final String url;
    private RealImage realImage;

    public ImageProxy(String url) throws IllegalArgumentException {
        if (url == null || url.isBlank()) throw new IllegalArgumentException("URL не может быть пустым");
        this.url = url;
    }

    @Override
    public void display() {
        if (realImage == null) realImage = new RealImage(url);
        realImage.display();
    }
}
