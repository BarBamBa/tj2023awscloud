package com.tj.edu.practice2.validation.model.dto;

// 3.0 validation
import com.tj.edu.practice2.validation.annotation.YearMonth;
import jakarta.validation.constraints.*;

public class User {
    @NotBlank(message="이름은 필수로 작성하십시오")
//    @Size(min=2, max=4, message="이름은 2자에서 4자 사이로만 작성이 가능합니다.")
    private String name;

    @Max(value = 200, message = "나이는 200을 넘을 수 없습니다.")
    @Min(value = 1, message = "나이는 최소 1 이어야 합니다.")
    private int age;

    @Email(message = "이메일 형식 오류")
//  @Pattern(regexp = "", message = "이메일 형식 오류")
    private String email;

    @Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$", message = "폰 번호 오류")
    private String phoneNumber;

    @AssertTrue(message = "Email은 .com으로 끝나야 합니다.") //<-> AssertFalse
    public boolean isTestSuccess() {
        if(email.endsWith(".com"))
            return true;
        return false;
    }

//    @Size(min=8, max=8)
//    private String birth;

    @YearMonth
    private String birth;



    // Getter Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
