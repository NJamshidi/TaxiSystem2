package taxiSystem.model.person;

import taxiSystem.enumeration.UserStatus;

public class Person {
    protected String userName;
    protected String name;
    protected String family;
    protected String nationalCode;
    protected String phoneNumber;
    protected int age;
    protected UserStatus userStatus;


    public Person() {

    }

    public Person(String userName, String name, String family, String nationalCode, String phoneNumber, int age, UserStatus userStatus) {
        this.userName = userName;
        this.name = name;
        this.family = family;
        this.nationalCode = nationalCode;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.userStatus = userStatus;

    }
    public Person(String userName, String name, String family, String nationalCode, String phoneNumber, int age) {
        this.userName = userName;
        this.name = name;
        this.family = family;
        this.nationalCode = nationalCode;
        this.phoneNumber = phoneNumber;
        this.age = age;

    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }



    public UserStatus getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
    }

    @Override
    public String toString() {
        return "Person{" +
                "userName='" + userName + '\'' +
                ", name='" + name + '\'' +
                ", family='" + family + '\'' +
                ", nationalCode='" + nationalCode + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", age=" + age +
                ", userStatus=" + userStatus +
                '}';
    }
}
