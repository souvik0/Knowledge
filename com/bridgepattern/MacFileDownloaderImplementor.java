package com.bridgepattern;

public class MacFileDownloaderImplementor implements FileDownloaderImplementor {

    @Override
    public Object downloadFile(String path) {
        return new Object();
    }

    @Override
    public boolean storeFile(Object object) {
        System.out.println("File downloaded in MAC machine");
        return true;
    }

    @Override
    public boolean deleteFile(String path) {
        System.out.println("File deteted from MAC machine");
        return true;
    }
}
