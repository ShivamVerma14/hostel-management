package utils;

public class Warden {
    private String employeeID, name, email, mobile, dob, joiningDate, password;
    private double salary;
    private char hostelBlock, isAdmin;
    
    public Warden (
            String employeeID, 
            String name, 
            String email, 
            String mobile, 
            String dob, 
            String joiningDate,
            double salary,
            char isAdmin,
            char hostelBlock) {
        this.employeeID = employeeID;
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.dob = dob;
        this.joiningDate = joiningDate;
        this.salary = salary;
        this.isAdmin = isAdmin;
        this.hostelBlock = hostelBlock;
        this.password = RandomPasswordGenerator.generateRandomPassword(10);
    }
    
    public String getEmployeeId() {
        return this.employeeID;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public String getMobile() {
        return this.mobile;
    }
    
    public String getDob() {
        return this.dob;
    }
    
    public String getJoiningDate() {
        return this.joiningDate;
    }
    
    public double getSalary() {
        return this.salary;
    }
    
    public char getIsAdmin() {
        return this.isAdmin;
    }
    
    public char getHostelBlock() {
        return this.hostelBlock;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public void setEmployeeId(String employeeId) {
        this.employeeID = employeeId;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    
    public void setDob(String dob) {
        this.dob = dob;
    }
    
    public void setJoiningDate(String joiningDate) {
        this.joiningDate = joiningDate;
    }
    
    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    public void setIsAdmin(char isAdmin) {
        this.isAdmin = isAdmin;
    }
    
    public void setHostelBlock(char hostelBlock) {
        this.hostelBlock = hostelBlock;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
}
