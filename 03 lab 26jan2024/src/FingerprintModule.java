public class FingerprintModule {
    private String fingerprintSerialNumber;
    private String fingerprint;

    public FingerprintModule(String fingerprintSerialNumber) {
        this.fingerprintSerialNumber = fingerprintSerialNumber;
        this.fingerprint = null;
    
    }

    public String getFingerprintSerialNumber() {
        return fingerprintSerialNumber;
    }

    public String getFingerprint() {
        return this.fingerprint;
    }
    public void registerFingerprint(String fingerprint) {
        this.fingerprint = fingerprint;
    }

    public boolean checkFingerprint(String fingerprint) {
        if (this.fingerprint.equals(fingerprint)) {
            return true;
        }
        else {
            return false;
        }
    }
}
