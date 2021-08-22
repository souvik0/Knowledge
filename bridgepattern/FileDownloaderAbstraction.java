package bridgepattern;

public interface FileDownloaderAbstraction {

    public Object downloadFile(String path);
    public boolean storeFile(Object object);
    public boolean deleteFile(String path);
}