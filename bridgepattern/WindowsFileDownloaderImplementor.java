package bridgepattern;

public class WindowsFileDownloaderImplementor implements FileDownloaderImplementor {

    @Override
    public Object downloadFile (String path) {
        return new Object();
    }

    @Override
    public boolean storeFile (Object object) {
        System.out.println("File downloaded in windows machine");
        return true;
    }

    @Override
    public boolean deleteFile(String path) {
        System.out.println("File deteted from windows machine");
        return true;
    }
}
