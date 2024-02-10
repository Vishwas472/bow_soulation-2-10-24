package com.example.form;

import static com.example.form.MainActivity.list;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.form.databinding.ActivityAddDataBinding;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class AddDataActivity extends AppCompatActivity {
    private ActivityAddDataBinding binding;
    StudentModel student = new StudentModel();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddDataBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        binding.View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Fname = binding.firstname.getText().toString();
                String Mname = binding.MiddelName.getText().toString();
                String Lname = binding.Lastname.getText().toString();
                String City = binding.City.getText().toString();
                String Pincode = binding.Pincode.getText().toString();
                String Adrees = binding.Adrees.getText().toString();
                String Dob = binding.dob.getText().toString();
                String number = binding.Phonenumber.getText().toString();
                String email = binding.email.getText().toString();

                String dobString = Dob; // Replace with the actual date of birth string
                int age = calculateAge(dobString);
                System.out.println("Age: " + age);
                Log.d("dddd", "onClick: " + age);

                student.setUsername(Fname);

                String username = createUsername(Fname, Mname, Lname, number);
                String uu = username;

                Log.d("eTAg", "onClick: " + uu);


                if (Fname.isEmpty() || Mname.isEmpty() || Lname.isEmpty() || City.isEmpty() || Pincode.isEmpty() || Adrees.isEmpty() || Dob.isEmpty() ||
                        number.isEmpty() || email.isEmpty()) {
                    Toast.makeText(AddDataActivity.this, "Data is emapty", Toast.LENGTH_SHORT).show();
                    

                } else if (Pincode.length()==5) {

                    Toast.makeText(AddDataActivity.this, "pincode number is incorrect", Toast.LENGTH_SHORT).show();
                } else if (number.length()==9) {
                    Toast.makeText(AddDataActivity.this, "number is incorrect", Toast.LENGTH_SHORT).show();
                }  else {


                    student.setFullname(returnFullName(formatName(Fname), formatName(Mname), formatName(Lname)));
                    student.setFullAdreess(ReturnAdrees(formatName(Adrees), formatName(City), formatName(Pincode)));
                    student.setDate(age);
                    student.setUsername(uu);
                    student.setNumber(number);
                    student.setPincode(Pincode);
                    student.setEmail(email);
                    list.add(student);


                    Toast.makeText(AddDataActivity.this, "Data is Add Succesfully", Toast.LENGTH_SHORT).show();

                }


            }

            private String createUsername(String fname, String mname, String lname, String number) {

                return fname.substring(0, 2) + mname.substring(1, 3) + lname.substring(2, 4) + number.substring(2, 5);
            }


            private int calculateAge(String dobString) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    Date dob = sdf.parse(dobString);
                    Calendar dobCalendar = Calendar.getInstance();
                    dobCalendar.setTime(dob);

                    Calendar currentCalendar = Calendar.getInstance();

                    int age = currentCalendar.get(Calendar.YEAR) - dobCalendar.get(Calendar.YEAR);

                    // Adjust age if the birthday hasn't occurred yet this year
                    if (currentCalendar.get(Calendar.DAY_OF_YEAR) < dobCalendar.get(Calendar.DAY_OF_YEAR)) {
                        age--;
                    }

                    return age;
                } catch (ParseException e) {
                    e.printStackTrace();
                    // Handle parsing exception
                    return -1;
                }
            }

            private String returnFullName(String Fname, String Mname, String Lname) {
                return Fname.concat(" " + Mname.concat(" " + Lname));
            }

            public String formatName(String name) {
                String firstChar = name.substring(0, 1).toUpperCase();
                String otherChar = name.substring(1, name.length()).toLowerCase();
                return firstChar.concat(otherChar);
            }

            private String ReturnAdrees(String Adrees, String City, String Pincode) {
                return Adrees.concat(" " + City.concat(" " + Pincode));
            }


        });


    }
}