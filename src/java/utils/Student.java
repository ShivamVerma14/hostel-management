package utils;

public class Student {
    private String regno, name, email, mobile, dob, course, password;
    private double hostelFeesPerYear, feesPaid, messFeesPerYear;
    private int courseDuration;
    private char hostelBlock;
    
    public Student(
            String regno, 
            String name, 
            String email, 
            String mobile, 
            String dob, 
            double hostelFeesPerYear,
            double messFeesPerYear,
            double feesPaid,
            String course, 
            int courseDuration, 
            char hostelBlock) {
        this.regno = regno;
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.dob = dob;
        this.hostelFeesPerYear = hostelFeesPerYear;
        this.messFeesPerYear = messFeesPerYear;
        this.feesPaid = feesPaid;
        this.course = course;
        this.courseDuration = courseDuration;
        this.hostelBlock = hostelBlock;
        this.password = RandomPasswordGenerator.generateRandomPassword(10);
    }
    
    public String getRegNo() {
        return this.regno;
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
    
    public double getHostelFeesPerYear() {
        return this.hostelFeesPerYear;
    }
    
    public double getMessFeesPerYear() {
        return this.messFeesPerYear;
    }
    
    public double getFeesPaid() {
        return this.feesPaid;
    }
    
    public String getCourse() {
        return this.course;
    }
    
    public int getCourseDuration() {
        return this.courseDuration;
    }
    
    public char getHostelBlock() {
        return this.hostelBlock;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public void setRegNo(String regno) {
        this.regno = regno;
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
    
    public void setHostelFeesPerYear(double hostelFeesPerYear) {
        this.hostelFeesPerYear = hostelFeesPerYear;
    }
    
    public void setMessFeesPerYear(double messFeesPerYear) {
        this.messFeesPerYear = messFeesPerYear;
    }
    
    public void setFeesPaid(double feesPaid) {
        this.feesPaid = feesPaid;
    }
    
    public void setCourse(String course) {
        this.course = course;
    }
    
    public void setCourseDuration(int courseDuration) {
        this.courseDuration = courseDuration;
    }
    
    public void setHostelBlock(char hostelBlock) {
        this.hostelBlock = hostelBlock;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
}
