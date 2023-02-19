package com.bridgepattern;

// Bridge Pattern prefers Composition over Inheritance.
public class Client {

    public static void main(String[] args) {

         //String os = "windows";
         OSType os = OSType.WINDOWS;
         FileDownloaderAbstraction downloader = null;

         switch(os) {
             case WINDOWS:
                 downloader = new FileDownloaderAbstractionImpl(new WindowsFileDownloaderImplementor());
                 break;
             case LINUX :
                 downloader = new FileDownloaderAbstractionImpl(new LinuxFileDownloaderImplementor());
                 break;
             case MAC :
                 downloader = new FileDownloaderAbstractionImpl(new MacFileDownloaderImplementor());
                 break;
             default:
                 System.out.println("OS not supported !!");
         }

         Object fileContent = downloader.downloadFile("some path");
         downloader.storeFile(fileContent);
         downloader.deleteFile("some path");
    }
}