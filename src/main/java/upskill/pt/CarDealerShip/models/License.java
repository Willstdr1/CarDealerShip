package upskill.pt.CarDealerShip.models;

public class License {
    private String licenseNumber;

    public License(String licenseNumber) {
        if (isValidLicenseNumber(licenseNumber)) {
            this.licenseNumber = licenseNumber;
        } else {
            throw new IllegalArgumentException("Invalid license number format");
        }
    }

    public License() {
    }

    private boolean isValidLicenseNumber(String licenseNumber) {
        // Verifica se tem o formato "XX-XX-XX"
        return licenseNumber.matches("^\\w{2}-\\w{2}-\\w{2}$");
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        if (isValidLicenseNumber(licenseNumber)) {
            this.licenseNumber = licenseNumber;
        } else {
            throw new IllegalArgumentException("Invalid license number format");
        }
    }

    public static void main(String[] args) {
        // Exemplo de uso
        try {
            License license = new License("AB-12-CD");
            System.out.println("License number: " + license.getLicenseNumber());
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}

