package task_lms.task_set.models;

import javax.swing.plaf.synth.SynthRadioButtonMenuItemUI;

public class Admin {
    private String email;
    private String password;

    public Admin() {
    }

    public Admin(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String email() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String password() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Admin{" +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
