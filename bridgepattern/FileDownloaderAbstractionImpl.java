package com.bridgepattern;

// Concrete abstraction uses implementor hierarchies to satisfy needs

public class FileDownloaderAbstractionImpl implements FileDownloaderAbstraction {

    FileDownloaderImplementor provider;

    public FileDownloaderAbstractionImpl(FileDownloaderImplementor provider) {
        this.provider = provider;
    }

    @Override
    public Object downloadFile(String path) {
        return provider.downloadFile(path);
    }

    @Override
    public boolean storeFile(Object object) {
        return provider.storeFile(object);
    }

    @Override
    public boolean deleteFile(String path) {
        return provider.deleteFile(path);
    }
}
