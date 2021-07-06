package com.bridgepattern;

public class LinuxFileDownloaderImplementor implements FileDownloaderImplementor {

    @Override
    public Object downloadFile(String path) {
        return new Object();
    }

    @Override
    public boolean storeFile(Object object) {
        System.out.println("File downloaded in linux machine");
        return true;
    }

    @Override
    public boolean deleteFile(String path) {
        System.out.println("File deteted from linux machine");
        return true;
    }
}
