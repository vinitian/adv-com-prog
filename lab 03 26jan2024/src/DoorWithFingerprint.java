public class DoorWithFingerprint extends Door {
    private FingerprintModule fingerprintModule;

    public DoorWithFingerprint(String doorID) {
        super(doorID);
    }    
    
    public void installFingerprintModule(FingerprintModule fingerprintModule) {
        this.fingerprintModule = fingerprintModule;
        System.out.println("A fingerprint module with serial " + fingerprintModule.getFingerprintSerialNumber() + " already installed.");
    }

    public void close(String fingerprint) {
        if (this.fingerprintModule.getFingerprint() == null) {
            this.fingerprintModule.registerFingerprint(fingerprint);
            super.lock();
        } 
        else {
        }
        
    }

    public void open(String fingerprint) {
        if (this.fingerprintModule.checkFingerprint(fingerprint)) {
            super.unlock();
        }
        super.open();
    }
}
